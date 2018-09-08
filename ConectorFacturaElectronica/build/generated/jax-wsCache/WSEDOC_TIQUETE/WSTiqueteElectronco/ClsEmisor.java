
package WSTiqueteElectronco;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ClsEmisor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ClsEmisor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RazonSocial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TipoIdentificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumIdentificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NombreComercial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Provincia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Canton" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Distrito" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Barrio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TelefonoNumero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TelefonoCodPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FaxNumero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FaxCodPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CorreoElectronico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClsEmisor", propOrder = {
    "razonSocial",
    "tipoIdentificacion",
    "numIdentificacion",
    "nombreComercial",
    "provincia",
    "canton",
    "distrito",
    "barrio",
    "direccion",
    "telefonoNumero",
    "telefonoCodPais",
    "faxNumero",
    "faxCodPais",
    "correoElectronico"
})
@XmlSeeAlso({
    ClsReceptor.class
})
public class ClsEmisor {

    @XmlElement(name = "RazonSocial")
    protected String razonSocial;
    @XmlElement(name = "TipoIdentificacion")
    protected String tipoIdentificacion;
    @XmlElement(name = "NumIdentificacion")
    protected String numIdentificacion;
    @XmlElement(name = "NombreComercial")
    protected String nombreComercial;
    @XmlElement(name = "Provincia")
    protected int provincia;
    @XmlElement(name = "Canton")
    protected int canton;
    @XmlElement(name = "Distrito")
    protected int distrito;
    @XmlElement(name = "Barrio")
    protected int barrio;
    @XmlElement(name = "Direccion")
    protected String direccion;
    @XmlElement(name = "TelefonoNumero")
    protected String telefonoNumero;
    @XmlElement(name = "TelefonoCodPais")
    protected String telefonoCodPais;
    @XmlElement(name = "FaxNumero")
    protected String faxNumero;
    @XmlElement(name = "FaxCodPais")
    protected String faxCodPais;
    @XmlElement(name = "CorreoElectronico")
    protected String correoElectronico;

    /**
     * Obtiene el valor de la propiedad razonSocial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Define el valor de la propiedad razonSocial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazonSocial(String value) {
        this.razonSocial = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoIdentificacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    /**
     * Define el valor de la propiedad tipoIdentificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoIdentificacion(String value) {
        this.tipoIdentificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad numIdentificacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    /**
     * Define el valor de la propiedad numIdentificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumIdentificacion(String value) {
        this.numIdentificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreComercial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreComercial() {
        return nombreComercial;
    }

    /**
     * Define el valor de la propiedad nombreComercial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreComercial(String value) {
        this.nombreComercial = value;
    }

    /**
     * Obtiene el valor de la propiedad provincia.
     * 
     */
    public int getProvincia() {
        return provincia;
    }

    /**
     * Define el valor de la propiedad provincia.
     * 
     */
    public void setProvincia(int value) {
        this.provincia = value;
    }

    /**
     * Obtiene el valor de la propiedad canton.
     * 
     */
    public int getCanton() {
        return canton;
    }

    /**
     * Define el valor de la propiedad canton.
     * 
     */
    public void setCanton(int value) {
        this.canton = value;
    }

    /**
     * Obtiene el valor de la propiedad distrito.
     * 
     */
    public int getDistrito() {
        return distrito;
    }

    /**
     * Define el valor de la propiedad distrito.
     * 
     */
    public void setDistrito(int value) {
        this.distrito = value;
    }

    /**
     * Obtiene el valor de la propiedad barrio.
     * 
     */
    public int getBarrio() {
        return barrio;
    }

    /**
     * Define el valor de la propiedad barrio.
     * 
     */
    public void setBarrio(int value) {
        this.barrio = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Define el valor de la propiedad direccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Obtiene el valor de la propiedad telefonoNumero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefonoNumero() {
        return telefonoNumero;
    }

    /**
     * Define el valor de la propiedad telefonoNumero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefonoNumero(String value) {
        this.telefonoNumero = value;
    }

    /**
     * Obtiene el valor de la propiedad telefonoCodPais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefonoCodPais() {
        return telefonoCodPais;
    }

    /**
     * Define el valor de la propiedad telefonoCodPais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefonoCodPais(String value) {
        this.telefonoCodPais = value;
    }

    /**
     * Obtiene el valor de la propiedad faxNumero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaxNumero() {
        return faxNumero;
    }

    /**
     * Define el valor de la propiedad faxNumero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaxNumero(String value) {
        this.faxNumero = value;
    }

    /**
     * Obtiene el valor de la propiedad faxCodPais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaxCodPais() {
        return faxCodPais;
    }

    /**
     * Define el valor de la propiedad faxCodPais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaxCodPais(String value) {
        this.faxCodPais = value;
    }

    /**
     * Obtiene el valor de la propiedad correoElectronico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Define el valor de la propiedad correoElectronico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorreoElectronico(String value) {
        this.correoElectronico = value;
    }

}
