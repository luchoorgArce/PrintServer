package servidor1;

import FacturaElectronica.GuruSoft.ControladorFacturaElectronica;
import Lavu.ControladorERPConector;
import Lavu.ControladorParser;
import WSTiqueteElectronco.ArrayOfClsDetalleServicio;
import WSTiqueteElectronco.ArrayOfOtros;
import WSTiqueteElectronco.ClsDetalleServicio;
import WSTiqueteElectronco.ClsEmisor;
import WSTiqueteElectronco.ClsOtros;
import WSTiqueteElectronco.ClsReceptor;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;
/**
 * @author vmora
 */
public class Servidor {  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ControladorParser lavuParser = new ControladorParser();
        ControladorSocket socket = new ControladorSocket(lavuParser);
        socket.run();
        
        //Conector hacia Lavu para obtener los datos de las facturas.
        //ControladorERPConector cLavu = new ControladorERPConector();
        //cLavu.PostData("&table=orders&column=order_id&value=1024-88");
        
        //Se abre el puerto para impresiones entrantes:
        //ControladorSocket cSocket = new ControladorSocket();
        //cSocket.start();
                        
        //Hilo de ejecucion para enviar facturas electrónicas a guru.
        //ControladorFacturaElectronica cFacturaElectronica = new ControladorFacturaElectronica();
        //cFacturaElectronica.start();
        
        //Hilo de ejecución para enviar facturas a imprimir.
        //ControladorImpresion cImpresion = new ControladorImpresion();
        //cImpresion.start();        
        
        //Investigando como llamar el wcf desde un cliente java.
//        WSTiqueteElectronco.ClsTiquete factura = new WSTiqueteElectronco.ClsTiquete(); 
//        factura.setMatrizEstab(1);
//        factura.setPuntoVenta(4);
//        factura.setSecuencial(3);
//
//        Timestamp elTimeStamp = new Timestamp(System.currentTimeMillis());
//        GregorianCalendar unGregorianCalendar = new GregorianCalendar();
//        unGregorianCalendar.setTime(elTimeStamp);
//        try {
//        XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(unGregorianCalendar);
//        factura.setFechaEmision(fecha);
//        } catch (DatatypeConfigurationException ex) {
//        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        ClsEmisor emisor = new ClsEmisor();
//        emisor.setRazonSocial("GuruSoft S.A.");
//        emisor.setTipoIdentificacion("02");
//        emisor.setNumIdentificacion("3101746795");
//        emisor.setNombreComercial("GuruSoft S.A.");
//        emisor.setProvincia(1);
//        emisor.setCanton(13);
//        emisor.setDistrito(1);
//        emisor.setBarrio(1);
//        emisor.setDireccion("123");
//        emisor.setCorreoElectronico("vichms06@hotmail.com");
//        factura.setEmisor(emisor);
//
//        ClsReceptor receptor =  new ClsReceptor();
//        receptor.setRazonSocial("123");
//        receptor.setProvincia(1);
//        receptor.setCanton(1);
//        receptor.setDistrito(1);
//        receptor.setBarrio(1);
//        receptor.setDireccion("Prueba de dirección");
//        factura.setReceptor(receptor);
//
//        factura.setTipoCambio(BigDecimal.ZERO);
//        factura.setTotalServGravados(BigDecimal.ZERO);
//        factura.setTotalServExentos(BigDecimal.ZERO);
//        factura.setTotalMercanciasGravadas(BigDecimal.ZERO);
//        factura.setTotalMercanciasExentas(BigDecimal.ZERO);
//        factura.setTotalGravado(BigDecimal.TEN);
//        factura.setTotalExento(BigDecimal.ZERO);
//        factura.setTotalDescuentos(BigDecimal.ZERO);
//        factura.setTotalImpuesto(BigDecimal.ZERO);
//        factura.setTotalComprobante(BigDecimal.TEN);
//        factura.setSinInternet(false);
//        factura.setAdjunto(null);
//
//        ClsDetalleServicio detalleServicio = new ClsDetalleServicio();
//        detalleServicio.setCantidad(BigDecimal.ONE);
//        detalleServicio.setUnidadMedida("1");
//        detalleServicio.setDetalleDescripcion("Prueba");
//        detalleServicio.setPrecioUnitario(BigDecimal.TEN);  //Unidades de Medida basadas en el estándar RTC 443:2010.
//        detalleServicio.setMontoTotal(BigDecimal.TEN);
//        detalleServicio.setSubTotal(BigDecimal.TEN);
//        detalleServicio.setMontoTotalLinea(BigDecimal.TEN);
//
//        ArrayOfClsDetalleServicio detalleServicioArray = new ArrayOfClsDetalleServicio();
//        detalleServicioArray.getClsDetalleServicio().add(detalleServicio);
//        factura.setDetalleServicio(detalleServicioArray);
//
//        factura.setInformacionReferencia(null);
//        ClsOtros otros = new ClsOtros();
//        ArrayOfOtros array = new ArrayOfOtros();
//        otros.setOtrosTexto(array);
//        factura.setOtros(otros);            
//
//        factura.setCodCondicionVenta("01");
//        factura.setCodMedioPago1("01");
//        factura.setTotalVenta(BigDecimal.TEN);
//        factura.setTotalVentaNeta(BigDecimal.TEN);
//        factura.setTotalComprobante(BigDecimal.TEN);
//        factura.setSecuencialERP("2");
//
//        Holder<String> mensaje = new Holder<String>(); 
//        Holder<WSTiqueteElectronco.RespuestaEDOC> enviarTiqueteResult = new Holder<WSTiqueteElectronco.RespuestaEDOC>(); 
//
//        mensaje.value = "1";
//
//        ControladorFacturaElectronica.enviarTiquete("P@$$wsedocCR", "2", factura, mensaje, enviarTiqueteResult);       
//        System.out.println("Proceso Finalizado...");
    }
}
