/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FacturaElectronica.GuruSoft;

import Entidades.DatosEmpresa;
import Entidades.DetalleFactura;
import Entidades.Estado;
import Entidades.Factura;
import Impresoras.Epson.ControladorImpresion;
import WSFacturaElectronica.ArrayOfClsDetalleServicio;
import WSFacturaElectronica.ArrayOfOtros;
import WSFacturaElectronica.ClsDetalleServicio;
import WSFacturaElectronica.ClsEmisor;
import WSFacturaElectronica.ClsOtros;
import WSFacturaElectronica.ClsReceptor;
import WSTiqueteElectronco.ClsDetalleImpuesto;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;
import servidor1.ControladorDB;
import servidor1.LogMessageHandler;
import servidor1.Servidor;

/**
 *
 * @author Usuario
 */
public class ControladorFacturaElectronica implements Runnable {
    
    private Thread t;
    private DatosEmpresa datosEmpresa;
    
    public ControladorFacturaElectronica(DatosEmpresa datosEmpresa){
        this.datosEmpresa = datosEmpresa;
        System.out.println("Creating ControladorFacturaElectronica");
    }
    
    @Override
    public void run() { 
        while(true)
        {
            try {
                EnviarFacturas();
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControladorFacturaElectronica.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Hello from a thread ControladorFacturaElectronica!"); 
        }
    }
    
    //Se revisa si hay facturas electrónicas pendientes de enviar a Guru:
   private void EnviarFacturas(){
       
       Estado estadoFactura;
       int reintento = 0;
       Estado estado = Estado.CREADA;
       String json = null;
       Gson gson = new Gson();
       ControladorDB cDB = new ControladorDB();
       ControladorImpresion cImpresion = new ControladorImpresion();
       List<Factura> listaFacturas = cDB.BuscarFacturas(Estado.CREADA);
       
        Holder<String> mensaje = new Holder<String>(); 
        Holder<WSTiqueteElectronco.RespuestaEDOC> enviarFacturaResult = new Holder<WSTiqueteElectronco.RespuestaEDOC>(); 
        mensaje.value = "1"; 
       
        for (Factura factura : listaFacturas) {
            reintento = factura.getReintentos();
            json = gson.toJson(factura);
            System.out.println("Factura " + factura.getSecuencia() + ": " + json);
            
            WSTiqueteElectronco.ClsTiquete tiquete =  ConvertirATiqueteGuru(factura);
            
            enviarTiquete(datosEmpresa.getPassword(), "2", tiquete, mensaje, enviarFacturaResult);
            System.out.println("Mensaje: " + mensaje.value);
            if(enviarFacturaResult.value.getEstado().equals("1") ||             //En proceso.
                    enviarFacturaResult.value.getEstado().equals("2") ||        //Autorizada.
                    enviarFacturaResult.value.getEstado().equals("5")){         //Recibido, en proceso por hacienda.

                if(enviarFacturaResult.value.getEstado().equals("2")){
                   estadoFactura = Estado.AUTORIZADA; 
                }else{
                   estadoFactura = Estado.EN_PROCESO;  
                }

                //Se actualizan los datos en la tabla de facturas:
                cDB.AgregarResultado(
                        factura.getSecuencia(),
                        estadoFactura, 
                        enviarFacturaResult.value.getFechaAutorizacion().toString(),
                        enviarFacturaResult.value.getNumeroConsecutivo(), 
                        enviarFacturaResult.value.getClaveComprobante()
                );
                
                factura.addHaciendaInfo(enviarFacturaResult.value.getClaveComprobante(), enviarFacturaResult.value.getNumeroConsecutivo());
                
                //Enviar a imprimir la factura:
                cImpresion.printInvoice(factura);
                
            }
            else{
                reintento++;                
                if(reintento == datosEmpresa.getCantidadMaximaReintentos()){
                    estado = Estado.NO_AUTORIZADA;
                }
                cDB.CambiarEstado(factura.getSecuencia(), estado, reintento);
                cDB.GuardarBitacoraRechazos(factura.getSecuencia(), json, enviarFacturaResult.value.getMensajeRespuesta());
            }
        }
   }
    
    public void start (){
        System.out.println("Starting ControladorFacturaElectronica");
        if (t == null)
        {
            t = new Thread (this);
            t.start ();
        }
    }

    public static void enviarFactura(java.lang.String clave, java.lang.String entorno, WSFacturaElectronica.ClsFactura factura, javax.xml.ws.Holder<java.lang.String> mensaje, javax.xml.ws.Holder<WSFacturaElectronica.RespuestaEDOC> enviarFacturaResult) {
        WSFacturaElectronica.WSEDOCFACTURAS service = new WSFacturaElectronica.WSEDOCFACTURAS();
        WSFacturaElectronica.IWSEDOCFACTURAS port = service.getBasicHttpBindingIWSEDOCFACTURAS();
        
        BindingProvider bindingProvider = (BindingProvider) port;
        Binding binding = bindingProvider.getBinding();
        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new LogMessageHandler());
        binding.setHandlerChain(handlerChain);
        
        port.enviarFactura(clave, entorno, factura, mensaje, enviarFacturaResult);
        
        
        
    }
    
    private WSFacturaElectronica.ClsFactura ConvertirAFacturaGuru(Factura factura){
        WSFacturaElectronica.ClsFactura clsFactura = new WSFacturaElectronica.ClsFactura();
        try{
            //Datos de la empresa emisora de la factura.
            WSFacturaElectronica.ClsEmisor emisor = new WSFacturaElectronica.ClsEmisor();
            emisor.setRazonSocial(datosEmpresa.getRazonSocial());
            emisor.setTipoIdentificacion(datosEmpresa.getTipoIdentificacion());
            emisor.setNumIdentificacion(datosEmpresa.getNumIdentificacion());
            emisor.setNombreComercial(datosEmpresa.getNombreComercial());
            emisor.setProvincia(datosEmpresa.getProvincia());
            emisor.setCanton(datosEmpresa.getCanton());
            emisor.setDistrito(datosEmpresa.getDistrito());
            emisor.setBarrio(1);
            emisor.setDireccion(datosEmpresa.getDireccion());
            emisor.setCorreoElectronico(datosEmpresa.getCorreoElectronico());
            clsFactura.setEmisor(emisor);  
            clsFactura.setCodigoMoneda("CRC");
                        
            clsFactura.setMatrizEstab(datosEmpresa.getMatriz());
            clsFactura.setPuntoVenta(datosEmpresa.getPuntoVenta());
            clsFactura.setSecuencial(factura.getSecuencia());

            Timestamp elTimeStamp = new Timestamp(System.currentTimeMillis());
            GregorianCalendar unGregorianCalendar = new GregorianCalendar();
            unGregorianCalendar.setTime(elTimeStamp);
            try {
            XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(unGregorianCalendar);
            clsFactura.setFechaEmision(fecha);
            } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }

            WSFacturaElectronica.ClsReceptor receptor =  new WSFacturaElectronica.ClsReceptor();
            receptor.setRazonSocial(factura.getNombreCliente());
            if(factura.getCorreoElectronicoCliente() != null && !factura.getCorreoElectronicoCliente().isEmpty()){
                receptor.setCorreoElectronico(factura.getCorreoElectronicoCliente());
            }
            //receptor.setProvincia(1);
            //receptor.setCanton(1);
            //receptor.setDistrito(1);
            //receptor.setBarrio(1);
            //receptor.setDireccion("Prueba de dirección");
            clsFactura.setReceptor(receptor);

            clsFactura.setTipoCambio(BigDecimal.ONE);
            clsFactura.setTotalServGravados(BigDecimal.ZERO);
            clsFactura.setTotalServExentos(BigDecimal.ZERO);
            clsFactura.setTotalMercanciasGravadas(BigDecimal.ZERO);
            clsFactura.setTotalMercanciasExentas(BigDecimal.ZERO);
            clsFactura.setTotalGravado(BigDecimal.ZERO);
            clsFactura.setTotalExento(BigDecimal.ZERO);
            clsFactura.setSinInternet(false);
            clsFactura.setAdjunto(null);

            WSFacturaElectronica.ArrayOfClsDetalleServicio detalleServicioArray = new WSFacturaElectronica.ArrayOfClsDetalleServicio();
            ClsDetalleServicio detalleServicio;
            for (DetalleFactura detalleFactura : factura.getDetalleFactura()) {
                detalleServicio = new ClsDetalleServicio();                
                detalleServicio.setCantidad(BigDecimal.valueOf(detalleFactura.getCantidad()));
                detalleServicio.setUnidadMedida(detalleFactura.getUnidadMedida());
                detalleServicio.setDetalleDescripcion(detalleFactura.getDescripcion());
                detalleServicio.setPrecioUnitario(detalleFactura.getPrecioUnitario());  //Unidades de Medida basadas en el estándar RTC 443:2010.
                detalleServicio.setMontoTotal(detalleFactura.getMonto());
                detalleServicio.setSubTotal(detalleFactura.getSubTotal());
                detalleServicio.setMontoTotalLinea(detalleFactura.getMontoTotalLinea());  
                detalleServicio.setMontoDescuento(detalleFactura.getMontoDescuento());
                detalleServicioArray.getClsDetalleServicio().add(detalleServicio);
            }          
            clsFactura.setDetalleServicio(detalleServicioArray);

            clsFactura.setInformacionReferencia(null);
            ClsOtros otros = new ClsOtros();
            ArrayOfOtros array = new ArrayOfOtros();
            otros.setOtrosTexto(array);
            clsFactura.setOtros(otros);            

            clsFactura.setCodCondicionVenta(factura.getCondicionVenta());
            clsFactura.setCodMedioPago1(factura.getCodigMedioPago1());
            clsFactura.setCodMedioPago2(factura.getCodigMedioPago2());
            clsFactura.setCodMedioPago3(factura.getCodigMedioPago3());
            clsFactura.setCodMedioPago4(factura.getCodigMedioPago4());
            clsFactura.setTotalVenta(factura.getTotalVenta());
            clsFactura.setTotalDescuentos(factura.getTotalDescuentos());    //-
            clsFactura.setTotalVentaNeta(factura.getTotalVentaNeta());      //=   
            clsFactura.setTotalImpuesto(factura.getTotalImpuesto());        //-
            clsFactura.setTotalComprobante(factura.getTotalComprante());    //=
            clsFactura.setSecuencialERP(String.valueOf(factura.getSecuencia()));            
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return clsFactura;
    }

    private static void enviarTiquete(java.lang.String clave, java.lang.String entorno, WSTiqueteElectronco.ClsTiquete tiquete, javax.xml.ws.Holder<java.lang.String> mensaje, javax.xml.ws.Holder<WSTiqueteElectronco.RespuestaEDOC> enviarTiqueteResult) {
        
        try
        {
            WSTiqueteElectronco.WSEDOCTIQUETE service = new WSTiqueteElectronco.WSEDOCTIQUETE();
            WSTiqueteElectronco.IWSEDOCTIQUETE port = service.getBasicHttpBindingIWSEDOCTIQUETE();

            BindingProvider bindingProvider = (BindingProvider) port;
            Binding binding = bindingProvider.getBinding();
            List<Handler> handlerChain = binding.getHandlerChain();
            handlerChain.add(new LogMessageHandler());
            binding.setHandlerChain(handlerChain);        

            port.enviarTiquete(clave, entorno, tiquete, mensaje, enviarTiqueteResult);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }  
    }
    
        private WSTiqueteElectronco.ClsTiquete ConvertirATiqueteGuru(Factura factura){
        WSTiqueteElectronco.ClsTiquete clsTiquete = new WSTiqueteElectronco.ClsTiquete();
        try
        {
            //Datos de la empresa emisora de la factura.
            WSTiqueteElectronco.ClsEmisor emisor = new WSTiqueteElectronco.ClsEmisor();
            emisor.setRazonSocial(datosEmpresa.getRazonSocial());
            emisor.setTipoIdentificacion(datosEmpresa.getTipoIdentificacion());
            emisor.setNumIdentificacion(datosEmpresa.getNumIdentificacion());
            emisor.setNombreComercial(datosEmpresa.getNombreComercial());
            emisor.setProvincia(datosEmpresa.getProvincia());
            emisor.setCanton(datosEmpresa.getCanton());
            emisor.setDistrito(datosEmpresa.getDistrito());
            emisor.setBarrio(1);
            emisor.setDireccion(datosEmpresa.getDireccion());
            emisor.setCorreoElectronico(datosEmpresa.getCorreoElectronico());
            clsTiquete.setEmisor(emisor);  
            clsTiquete.setCodigoMoneda("CRC");
                        
            clsTiquete.setMatrizEstab(datosEmpresa.getMatriz());
            clsTiquete.setPuntoVenta(datosEmpresa.getPuntoVenta());
            clsTiquete.setSecuencial(factura.getSecuencia());

            Timestamp elTimeStamp = new Timestamp(System.currentTimeMillis());
            GregorianCalendar unGregorianCalendar = new GregorianCalendar();
            unGregorianCalendar.setTime(elTimeStamp);
            try {
            XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(unGregorianCalendar);
            clsTiquete.setFechaEmision(fecha);
            } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }

            clsTiquete.setTipoCambio(BigDecimal.ONE);
            //clsTiquete.setTotalServGravados(BigDecimal.ZERO);
            //clsTiquete.setTotalServExentos(BigDecimal.ZERO);
            //clsTiquete.setTotalMercanciasGravadas(BigDecimal.ZERO);
            //clsTiquete.setTotalMercanciasExentas(BigDecimal.ZERO);
            //clsTiquete.setTotalGravado(BigDecimal.ZERO);
            //clsTiquete.setTotalExento(BigDecimal.ZERO);
            clsTiquete.setSinInternet(false);
            clsTiquete.setAdjunto(null);

            WSTiqueteElectronco.ArrayOfClsDetalleServicio detalleServicioArray = new WSTiqueteElectronco.ArrayOfClsDetalleServicio();
            WSTiqueteElectronco.ClsDetalleServicio detalleServicio;
            for (DetalleFactura detalleFactura : factura.getDetalleFactura()) {
                detalleServicio = new WSTiqueteElectronco.ClsDetalleServicio();                
                detalleServicio.setCantidad(BigDecimal.valueOf(detalleFactura.getCantidad()));
                detalleServicio.setUnidadMedida(detalleFactura.getUnidadMedida());
                detalleServicio.setDetalleDescripcion(detalleFactura.getDescripcion());
                detalleServicio.setPrecioUnitario(detalleFactura.getPrecioUnitario());  //Unidades de Medida basadas en el estándar RTC 443:2010.
                detalleServicio.setMontoTotal(detalleFactura.getMonto());
                detalleServicio.setSubTotal(detalleFactura.getSubTotal());
                detalleServicio.setMontoTotalLinea(detalleFactura.getMontoTotalLinea());  
                detalleServicio.setMontoDescuento(detalleFactura.getMontoDescuento());
                detalleServicio.setNaturalezaDescuento(detalleFactura.getNaturalezaDescuento());
                
                
                WSTiqueteElectronco.ArrayOfClsDetalleImpuesto detalleImpuestoList = new WSTiqueteElectronco.ArrayOfClsDetalleImpuesto();
                for(int i = 0; i < detalleFactura.getdImpuesto().size(); i++){
                    ClsDetalleImpuesto cDetalleImpuesto = new ClsDetalleImpuesto();
                    
                    cDetalleImpuesto.setCodigo(detalleFactura.getdImpuesto().get(i).getCodigo());
                    cDetalleImpuesto.setTarifa(detalleFactura.getdImpuesto().get(i).getTarifa());
                    cDetalleImpuesto.setMonto(detalleFactura.getdImpuesto().get(i).getMonto());
                    
                    detalleImpuestoList.getClsDetalleImpuesto().add(cDetalleImpuesto);
                }
                detalleServicio.setImpuestos(detalleImpuestoList);
                
                detalleServicioArray.getClsDetalleServicio().add(detalleServicio);
            }         
            clsTiquete.setDetalleServicio(detalleServicioArray);           

            clsTiquete.setInformacionReferencia(null);
            WSTiqueteElectronco.ClsOtros otros = new WSTiqueteElectronco.ClsOtros();
            WSTiqueteElectronco.ArrayOfOtros array = new WSTiqueteElectronco.ArrayOfOtros();
            otros.setOtrosTexto(array);
            clsTiquete.setOtros(otros);            

            clsTiquete.setCodCondicionVenta(factura.getCondicionVenta());
            clsTiquete.setCodMedioPago1(factura.getCodigMedioPago1());
            clsTiquete.setCodMedioPago2(factura.getCodigMedioPago2());
            clsTiquete.setCodMedioPago3(factura.getCodigMedioPago3());
            clsTiquete.setCodMedioPago4(factura.getCodigMedioPago4());
            clsTiquete.setTotalMercanciasGravadas(factura.getTotalVenta());
            clsTiquete.setTotalGravado(factura.getTotalVenta()); //En Lavu no hay produtos que no esten exentos.
            clsTiquete.setTotalVenta(factura.getTotalVenta());
            clsTiquete.setTotalDescuentos(factura.getTotalDescuentos());    //-
            clsTiquete.setTotalVentaNeta(factura.getTotalVentaNeta());      //=   
            clsTiquete.setTotalImpuesto(factura.getTotalImpuesto());        //-
            clsTiquete.setTotalComprobante(factura.getTotalComprante());    //=
            clsTiquete.setSecuencialERP(String.valueOf(factura.getSecuencia()));            
        }
        catch(Exception ex){
            
        }
        
        return clsTiquete;
    }
}
