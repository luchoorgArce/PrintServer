/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor1;

import Entidades.DatosEmpresa;
import Entidades.Factura;
import Entidades.DetalleFactura;
import java.sql.Connection;
import java.sql.DriverManager;
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
        String sql = "Select Matriz, PuntoVenta, RazonSocial, TipoIdentificacion, NumIdentificacion, NombreComercial, Provincia, Canton, Distrito, Direccion, CorreoElectronico, Password From DatosEmpresa";
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
    
    //0:Creada.
    //1:Procesada.
    //2:Se envío, sin respuesta.
    //4:Impresa.
    public List<Factura> BuscarFacturas(int estado) {

        List<Factura> lista = new ArrayList<Factura>();
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
        sql = sql + "t2. TotalImpuesto, t2.MontoTotalLinea, ";
        sql = sql + "t1.NombreCliente, t1.CorreoElectronicoCliente ";
        sql = sql + "from Facturas t1 ";
        sql = sql + "inner join DetalleFactura t2 On t1.Secuencia = t2.Secuencia ";
        sql = sql + "Where t1.Estado = " + estado + " ";
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
                dFactura.setTotalImpuesto(rs.getBigDecimal("TotalImpuesto"));
                dFactura.setUnidadMedida(rs.getString("UnidadMedida"));

                if (consecutivo != rs.getInt("Secuencia")) {
                    
                    if (!primerRegistro) {
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
                    factura.setDetalleFactura(dFactura);
                } else {
                    factura.setDetalleFactura(dFactura);
                }
            }
            lista.add(factura);
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
}
