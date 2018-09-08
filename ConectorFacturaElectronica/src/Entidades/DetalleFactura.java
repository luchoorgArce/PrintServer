/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.math.BigDecimal;

/**
 *
 * @author Usuario
 */
public class DetalleFactura {
    
    private int linea;
    private String descripcion;
    private int cantidad;
    private String unidadMedida; //TODO: Ask Hugo???
    private BigDecimal precioUnitario;
    private BigDecimal monto;
    private BigDecimal montoDescuento;
    private String naturalezaDescuento;
    private BigDecimal subTotal;
    private BigDecimal totalImpuesto; //TODO: Ask Hugo???
    private BigDecimal montoTotalLinea; ///
    
    public DetalleFactura(){};
    
    public DetalleFactura(int linea, String descripcion, int cantidad, String unidadMedida, BigDecimal precioUnitario, BigDecimal monto, BigDecimal montoDescuento, String naturalezaDescuento, BigDecimal subTotal, BigDecimal totalImpuesto, BigDecimal montoTotalLinea) {
        this.linea = linea;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.precioUnitario = precioUnitario;
        this.monto = monto;
        this.montoDescuento = montoDescuento;
        this.naturalezaDescuento = naturalezaDescuento;
        this.subTotal = subTotal;
        this.totalImpuesto = totalImpuesto;
        this.montoTotalLinea = montoTotalLinea;
    }     

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(BigDecimal montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public String getNaturalezaDescuento() {
        return naturalezaDescuento;
    }

    public void setNaturalezaDescuento(String naturalezaDescuento) {
        this.naturalezaDescuento = naturalezaDescuento;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTotalImpuesto() {
        return totalImpuesto;
    }

    public void setTotalImpuesto(BigDecimal totalImpuesto) {
        this.totalImpuesto = totalImpuesto;
    }

    public BigDecimal getMontoTotalLinea() {
        return montoTotalLinea;
    }

    public void setMontoTotalLinea(BigDecimal montoTotalLinea) {
        this.montoTotalLinea = montoTotalLinea;
    }
    
    
    
    
}
