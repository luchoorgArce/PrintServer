/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Factura {

    private int secuencia;
    private String idOrden;
    private BigDecimal totalVenta;
    private BigDecimal totalDescuentos;
    private BigDecimal totalVentaNeta;    
    private BigDecimal totalImpuesto;
    private BigDecimal totalComprante;
    private List<DetalleFactura> detalleFactura;
    private String condicionVenta;
    private String codigMedioPago1;
    private String codigMedioPago2;
    private String codigMedioPago3;
    private String codigMedioPago4;
    private Date fechaAutorizacion;
    private String numeroConsecutivo;
    private String claveComprobante;
    private String nombreCliente;
    private String correoElectronicoCliente;
    private int reintentos;
    
    public Factura(){
        this.detalleFactura = new ArrayList<DetalleFactura>();
    }
    
    public Factura(int secuencia, String idOrden, BigDecimal totalVenta, BigDecimal totalImpuesto, BigDecimal totalComprante, List<DetalleFactura> detalleFactura, String condicionVenta, String codigMedioPago1) {
        this.secuencia = secuencia;
        this.idOrden = idOrden;
        this.totalVenta = totalVenta;
        this.totalImpuesto = totalImpuesto;
        this.totalComprante = totalComprante;
        this.detalleFactura = detalleFactura;
        this.condicionVenta = condicionVenta;
        this.codigMedioPago1 = codigMedioPago1;
    }
    
    public int getSecuencia() {
        return secuencia;
    }

    public List<DetalleFactura> getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(DetalleFactura detalleFactura) {
        this.detalleFactura.add(detalleFactura);
    }
    
    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }
    
    public BigDecimal getTotalVentaNeta() {
        return totalVentaNeta;
    }

    public void setTotalVentaNeta(BigDecimal totalVentaNeta) {
        this.totalVentaNeta = totalVentaNeta;
    }
    
    public BigDecimal getTotalDescuentos() {
        return totalDescuentos;
    }

    public void setTotalDescuentos(BigDecimal totalDescuentos) {
        this.totalDescuentos = totalDescuentos;
    }  

    public BigDecimal getTotalImpuesto() {
        return totalImpuesto;
    }

    public void setTotalImpuesto(BigDecimal totalImpuesto) {
        this.totalImpuesto = totalImpuesto;
    }

    public BigDecimal getTotalComprante() {
        return totalComprante;
    }

    public void setTotalComprante(BigDecimal totalComprante) {
        this.totalComprante = totalComprante;
    }

    public String getCondicionVenta() {
        return condicionVenta;
    }

    public void setCondicionVenta(String condicionVenta) {
        this.condicionVenta = condicionVenta;
    }

    public String getCodigMedioPago1() {
        return codigMedioPago1;
    }

    public void setCodigMedioPago1(String codigMedioPago1) {
        this.codigMedioPago1 = codigMedioPago1;
    }

    public String getCodigMedioPago2() {
        return codigMedioPago2;
    }

    public void setCodigMedioPago2(String codigMedioPago2) {
        this.codigMedioPago2 = codigMedioPago2;
    }

    public String getCodigMedioPago3() {
        return codigMedioPago3;
    }

    public void setCodigMedioPago3(String codigMedioPago3) {
        this.codigMedioPago3 = codigMedioPago3;
    }

    public String getCodigMedioPago4() {
        return codigMedioPago4;
    }

    public void setCodigMedioPago4(String codigMedioPago4) {
        this.codigMedioPago4 = codigMedioPago4;
    }

    public Date getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(Date fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public String getNumeroConsecutivo() {
        return numeroConsecutivo;
    }

    public void setNumeroConsecutivo(String numeroConsecutivo) {
        this.numeroConsecutivo = numeroConsecutivo;
    }

    public String getClaveComprobante() {
        return claveComprobante;
    }

    public void setClaveComprobante(String claveComprobante) {
        this.claveComprobante = claveComprobante;
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the correoElectronicoCliente
     */
    public String getCorreoElectronicoCliente() {
        return correoElectronicoCliente;
    }

    /**
     * @param correoElectronicoCliente the correoElectronicoCliente to set
     */
    public void setCorreoElectronicoCliente(String correoElectronicoCliente) {
        this.correoElectronicoCliente = correoElectronicoCliente;
    }

    /**
     * @return the reintentos
     */
    public int getReintentos() {
        return reintentos;
    }

    /**
     * @param reintentos the reintentos to set
     */
    public void setReintentos(int reintentos) {
        this.reintentos = reintentos;
    }
}
