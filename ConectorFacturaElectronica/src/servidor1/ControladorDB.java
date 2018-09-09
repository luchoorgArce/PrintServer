/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor1;

import Entidades.DatosEmpresa;
import Entidades.Factura;
import Entidades.DetalleFactura;
import Entidades.Estado;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ControladorDB {

    //Se abre la conexión:
    public Connection Connect() {

        String url = "C:\\Users\\Usuario\\Documents\\Proyectos\\Lavu\\v1\\db\\Conectorlavu.db";
        Connection connect = null;

        try {
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connect != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }

        return connect;
    }
    
    public DatosEmpresa ObtenerDatosEmpresa() {
        DatosEmpresa datosEmpresa = new DatosEmpresa();
        String sql = "Select Matriz, PuntoVenta, RazonSocial, TipoIdentificacion, NumIdentificacion, NombreComercial, Provincia, Canton, Distrito, Direccion, CorreoElectronico, Password, CantidadMaximaReintentos From DatosEmpresa";
        //String sql = "Select * From DatosEmpresa"; 
        Connection conn = null;
        try {
            conn = this.Connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                datosEmpresa.setMatriz(rs.getInt("Matriz"));
                datosEmpresa.setPuntoVenta(rs.getInt("PuntoVenta"));
                datosEmpresa.setRazonSocial(rs.getString("RazonSocial"));
                datosEmpresa.setTipoIdentificacion(rs.getString("TipoIdentificacion"));
                datosEmpresa.setNumIdentificacion(rs.getString("NumIdentificacion"));
                datosEmpresa.setNombreComercial(rs.getString("NombreComercial"));
                datosEmpresa.setProvincia(rs.getInt("Provincia"));
                datosEmpresa.setCanton(rs.getInt("Canton"));
                datosEmpresa.setDistrito(rs.getInt("Distrito"));
                datosEmpresa.setDireccion(rs.getString("Direccion"));
                datosEmpresa.setCorreoElectronico(rs.getString("CorreoElectronico"));
                datosEmpresa.setPassword(rs.getString("Password"));
                datosEmpresa.setCantidadMaximaReintentos(rs.getInt("CantidadMaximaReintentos"));
                datosEmpresa.setMensajeError("NA");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return datosEmpresa;
    }
    
    //0:Creada, cuando se ingresa un nuevo registro desde el parser.
    //1:Autorizada en Hacienda.
    //2:No autorizada.
    //3:En proceso, en estos casos se debe volver a preguntar por el estado.
    //4:Impresa.
    public List<Factura> BuscarFacturas(Estado estado) {

        List<Factura> lista = new ArrayList<Factura>();
        List<String> lineas = new ArrayList<String>();
        boolean primerRegistro = true;
        int consecutivo = 0;
        Factura factura = null;
        DetalleFactura dFactura = null;

        //Factura factura = new Factura();
        //String sql = "Select * From Facturas Where Estado = " + estado; 
        String sql = "select ";
        sql = sql + "t1.Secuencia, t1.IdOrden, t1.Estado, t1.TotalVenta, t1.TotalImpuesto, t1.TotalComprobante, ";
        sql = sql + "t1.TotalDescuento, t1.TotalVentaNeta, ";
        sql = sql + "t1.CodCondicionVenta, t1.CodMedioPago1, t1.CodMedioPago2, t1.CodMedioPago3, t1.CodMedioPago4, ";
        sql = sql + "t2.Linea, t2.Descripcion, t2.Cantidad, t2.UnidadMedida, t2.PrecioUnitario, ";
        sql = sql + "t2.Monto, t2.MontoDescuento, t2.NaturalezaDescuento, t2.SubTotal, ";
        sql = sql + "t2.MontoTotalLinea, ";
        sql = sql + "t1.NombreCliente, t1.CorreoElectronicoCliente, t1.Reintentos ";
        sql = sql + "from Facturas t1 ";
        sql = sql + "inner join DetalleFactura t2 On t1.Secuencia = t2.Secuencia ";
        sql = sql + "Where t1.Estado = " + estado.toInt() + " ";
        sql = sql + "Order By t1.Secuencia, t2.Linea asc";
        Connection conn = null;

        try {

            conn = this.Connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                dFactura = new DetalleFactura();
                dFactura.setCantidad(rs.getInt("Cantidad"));
                dFactura.setDescripcion(rs.getString("Descripcion"));
                dFactura.setLinea(rs.getInt("Linea"));
                dFactura.setMonto(rs.getBigDecimal("Monto"));
                dFactura.setMontoDescuento(rs.getBigDecimal("MontoDescuento"));
                dFactura.setMontoTotalLinea(rs.getBigDecimal("MontoTotalLinea"));
                dFactura.setNaturalezaDescuento(rs.getString("NaturalezaDescuento"));
                dFactura.setPrecioUnitario(rs.getBigDecimal("PrecioUnitario"));
                dFactura.setSubTotal(rs.getBigDecimal("SubTotal"));
                //dFactura.setTotalImpuesto(rs.getBigDecimal("TotalImpuesto"));
                dFactura.setUnidadMedida(rs.getString("UnidadMedida"));

                if (consecutivo != rs.getInt("Secuencia")) {
                    
                    if (!primerRegistro) {
                        lineas = SearchLinesToPrint(factura.getSecuencia(), conn);
                        factura.setInvoiceLinesToPrint(lineas);
                        lista.add(factura);                      
                    }else{
                        primerRegistro = false;
                    }

                    consecutivo = rs.getInt("Secuencia");
                    factura = new Factura();
                    factura.setSecuencia(consecutivo);
                    factura.setNombreCliente(rs.getString("NombreCliente"));
                    factura.setCorreoElectronicoCliente(rs.getString("CorreoElectronicoCliente"));
                    factura.setCodigMedioPago1(rs.getString("CodMedioPago1"));
                    factura.setCodigMedioPago2(rs.getString("CodMedioPago2"));
                    factura.setCodigMedioPago3(rs.getString("CodMedioPago3"));
                    factura.setCodigMedioPago4(rs.getString("CodMedioPago4"));
                    factura.setCondicionVenta(rs.getString("CodCondicionVenta"));
                    factura.setIdOrden(rs.getString("IdOrden"));
                    factura.setTotalComprante(rs.getBigDecimal("TotalComprobante"));
                    factura.setTotalImpuesto(rs.getBigDecimal("TotalImpuesto"));
                    factura.setTotalVenta(rs.getBigDecimal("TotalVenta"));
                    factura.setTotalDescuentos(rs.getBigDecimal("TotalDescuento"));
                    factura.setTotalVentaNeta(rs.getBigDecimal("TotalVentaNeta"));
                    factura.setReintentos(rs.getInt("Reintentos"));
                    factura.setDetalleFactura(dFactura);
                } else {
                    factura.setDetalleFactura(dFactura);
                }
            }
            if(factura != null){
                lineas = SearchLinesToPrint(factura.getSecuencia(), conn);
                factura.setInvoiceLinesToPrint(lineas);                
                lista.add(factura);
            }                      
        } catch (SQLException ex) {
            Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;
    }
    
    public List<String> SearchLinesToPrint(int secuencia, Connection conn){
        List<String> lineas = new ArrayList<String>();
        try
        {
            String sql = "select TextoLinea LineasPorImprimir Where SecuenciaFactura = " + secuencia + " Order By NumeroLinea asc";
            
            Statement stmt = conn.createStatement();            
            ResultSet rs = stmt.executeQuery(sql);                        

            while (rs.next()) {   
                lineas.add(rs.getString("TextoLinea"));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        return lineas;
    }
    
    public void AgregarResultado(
            int Secuencia,
            Estado estado, 
            String fechaAutorizacion, 
            String numeroConsecutivo, 
            String claveComprobante
    ) {
        Connection conn = null;
        String sql = "Update Facturas Set " 
                + "Estado = ?, "
                + "FechaAutorizacion = ?, "
                + "NumeroConsecutivo = ?, "
                + "ClaveComprobante = ? "
                + "Where Secuencia = ?";

        try {

            conn = this.Connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, estado.toInt());
            pstmt.setString(2, fechaAutorizacion);
            pstmt.setString(3, numeroConsecutivo);
            pstmt.setString(4, claveComprobante);
            pstmt.setInt(5, Secuencia);
            
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void GuardarBitacoraRechazos(int secuencia, String trama, String mensajeRespuesta){
        Connection conn = null;
        String sql = "INSERT INTO BitacoraEnviosRechazados(Secuencia,Trama,Respuesta) VALUES(?,?,?)";
        try{
            conn = this.Connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, secuencia);
            pstmt.setString(2, trama);
            pstmt.setString(3, mensajeRespuesta);
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }
    
    public void CambiarEstado(int secuencia, Estado estado, int reintentos){
        Connection conn = null;
        String sql = "Update Facturas Set " 
                + "Estado = ?, "
                + "Reintentos = ? "
                + "Where Secuencia = ?";        
        
        try
        {
            conn = this.Connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, estado.toInt());
            pstmt.setInt(2, reintentos);
            pstmt.setInt(3, secuencia);
            
            pstmt.executeUpdate();            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
    
    public void InsertInvoice(Factura factura){
        Connection conn = null;
        String sql1 = "Insert Into Facturas (Estado,";
        String sql2 = "Values (0,";
        //String sql3 = "select max(Secuencia) Maximo from Facturas;";
        String sql3 = "select last_insert_rowid() Consecutivo;";
        
        try{            
            conn = this.Connect();
            
            //Se arma la trama encabezado de la base de datos:            
            sql1 += "IdOrden,";
            sql2 += "'" + factura.getIdOrden() + "',";
            
            sql1 += "TotalVenta,";
            sql2 += factura.getTotalVenta() + ",";
            
            if(factura.getTotalDescuentos().compareTo(BigDecimal.ZERO) > 0){
                sql1 += "TotalDescuento,";
                sql2 += factura.getTotalDescuentos() + ",";       
            }
            
            sql1 += "TotalVentaNeta,";
            sql2 += factura.getTotalVentaNeta() + ",";
            
            if(factura.getTotalImpuesto().compareTo(BigDecimal.ZERO) > 0){
                sql1 += "TotalImpuesto,";
                sql2 += factura.getTotalImpuesto() + ",";       
            }
            
            sql1 += "TotalComprobante,";
            sql2 += factura.getTotalComprante() + ",";
            
            sql1 += "CodCondicionVenta,";
            sql2 += "'" + factura.getCondicionVenta() + "',";
            
            if(!factura.getCodigMedioPago1().equals("")){
                sql1 += "CodMedioPago1,";
                sql2 += "'" + factura.getCodigMedioPago1() + "',";       
            }
            
            if(!factura.getCodigMedioPago2().equals("")){
                sql1 += "CodMedioPago2,";
                sql2 += "'" + factura.getCodigMedioPago2() + "',";      
            }
            
            if(!factura.getCodigMedioPago3().equals("")){
                sql1 += "CodMedioPago3,";
                sql2 += "'" + factura.getCodigMedioPago3() + "',";      
            }

            if(!factura.getCodigMedioPago4().equals("")){
                sql1 += "CodMedioPago4,";
                sql2 += "'" + factura.getCodigMedioPago4() + "',";      
            }
            
            sql1 += "Reintentos)";
            sql2 += "0)";
            
            PreparedStatement pstmt = conn.prepareStatement(sql1 + sql2);
            pstmt.executeUpdate();
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql3);

            int consecutivo = 0;
            
            while (rs.next()) {
                consecutivo = rs.getInt("Consecutivo");
                System.out.println(consecutivo);
            }
            
            //Se arma la trama detalle de la base de datos:            
            for(int i = 0; i < factura.getDetalleFactura().size(); i++){
                sql1 = "Insert Into DetalleFactura (SecuenciaFactura, Linea, Descripcion, Cantidad, UnidadMedida, PrecioUnitario, Monto, SubTotal, MontoTotalLinea";
                sql2 = "Values (?, ?, ?, ?, ?, ?, ?, ?, ?";       
                
                if(factura.getDetalleFactura().get(i).getMontoDescuento().compareTo(BigDecimal.ZERO) > 0){
                    sql1 += ", MontoDescuento, NaturalezaDescuento)";
                    sql2 += ", " + factura.getDetalleFactura().get(i).getMontoDescuento() + ", '" + factura.getDetalleFactura().get(i).getNaturalezaDescuento() + "');";
                }else{
                    sql1 += ")";
                    sql2 += ");";
                }
                
                pstmt = conn.prepareStatement(sql1 + sql2);
                
                pstmt.setInt(1, consecutivo);
                pstmt.setInt(2, factura.getDetalleFactura().get(i).getLinea());
                pstmt.setString(3, factura.getDetalleFactura().get(i).getDescripcion());
                pstmt.setInt(4, factura.getDetalleFactura().get(i).getCantidad());
                pstmt.setString(5, factura.getDetalleFactura().get(i).getDescripcion());
                pstmt.setBigDecimal(6, factura.getDetalleFactura().get(i).getPrecioUnitario());
                pstmt.setBigDecimal(7, factura.getDetalleFactura().get(i).getMonto());
                pstmt.setBigDecimal(8, factura.getDetalleFactura().get(i).getSubTotal());
                pstmt.setBigDecimal(9, factura.getDetalleFactura().get(i).getMontoTotalLinea());     
                pstmt.executeUpdate(); 
            }                             
            
            //Se inserta la línea por imprimir.
            int count = 1;
            for(int i = 0; i < factura.getInvoiceLinesToPrint().size(); i++){                
                sql1 = "Insert Into LineasPorImprimir(SecuenciaFactura, TextoLinea, NumeroLinea) Values (?, ?, ?)";
                pstmt = conn.prepareStatement(sql1);
                pstmt.setInt(1, consecutivo);
                pstmt.setString(2, factura.getInvoiceLinesToPrint().get(i));
                pstmt.setInt(3, count);
                pstmt.executeUpdate();  
                count++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
