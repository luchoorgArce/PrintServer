/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Usuario
 */
public class DatosEmpresa {

    private int matriz;
    private int puntoVenta;
    private String razonSocial;
    private String tipoIdentificacion;
    private String numIdentificacion;
    private String nombreComercial;
    private int provincia;
    private int canton;
    private int distrito;
    private String direccion;
    private String correoElectronico;
    private String password;
    private String mensajeError;

    public DatosEmpresa() {}   
    
    public DatosEmpresa(String mensajeError) {
        this.mensajeError = mensajeError;
    }        
    
    public DatosEmpresa(int matriz, int puntoVenta, String razonSocial, String tipoIdentificacion, String numIdentificacion, String nombreComercial, int provincia, int canton, int distrito, String direccion, String correoElectronico) {
        this.matriz = matriz;
        this.puntoVenta = puntoVenta;
        this.razonSocial = razonSocial;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numIdentificacion = numIdentificacion;
        this.nombreComercial = nombreComercial;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.mensajeError = "NA";
    }
    
    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
    
    public int getMatriz() {
        return matriz;
    }

    public void setMatriz(int matriz) {
        this.matriz = matriz;
    }

    public int getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(int puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public int getProvincia() {
        return provincia;
    }

    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }

    public int getCanton() {
        return canton;
    }

    public void setCanton(int canton) {
        this.canton = canton;
    }

    public int getDistrito() {
        return distrito;
    }

    public void setDistrito(int distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }        
}
