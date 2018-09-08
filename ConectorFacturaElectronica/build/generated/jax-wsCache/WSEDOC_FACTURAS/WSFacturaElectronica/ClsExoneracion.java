
package WSFacturaElectronica;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para ClsExoneracion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ClsExoneracion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NombreInstitucion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaEmision" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="MontoImpuesto" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PorcentajeCompra" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClsExoneracion", propOrder = {
    "tipoDocumento",
    "numDocumento",
    "nombreInstitucion",
    "fechaEmision",
    "montoImpuesto",
    "porcentajeCompra"
})
public class ClsExoneracion {

    @XmlElement(name = "TipoDocumento")
    protected String tipoDocumento;
    @XmlElement(name = "NumDocumento")
    protected String numDocumento;
    @XmlElement(name = "NombreInstitucion")
    protected String nombreInstitucion;
    @XmlElement(name = "FechaEmision", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEmision;
    @XmlElement(name = "MontoImpuesto", required = true)
    protected BigDecimal montoImpuesto;
    @XmlElement(name = "PorcentajeCompra")
    protected int porcentajeCompra;

    /**
     * Obtiene el valor de la propiedad tipoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Define el valor de la propiedad tipoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDocumento(String value) {
        this.tipoDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad numDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumDocumento() {
        return numDocumento;
    }

    /**
     * Define el valor de la propiedad numDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumDocumento(String value) {
        this.numDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreInstitucion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    /**
     * Define el valor de la propiedad nombreInstitucion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreInstitucion(String value) {
        this.nombreInstitucion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaEmision.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Define el valor de la propiedad fechaEmision.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEmision(XMLGregorianCalendar value) {
        this.fechaEmision = value;
    }

    /**
     * Obtiene el valor de la propiedad montoImpuesto.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoImpuesto() {
        return montoImpuesto;
    }

    /**
     * Define el valor de la propiedad montoImpuesto.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoImpuesto(BigDecimal value) {
        this.montoImpuesto = value;
    }

    /**
     * Obtiene el valor de la propiedad porcentajeCompra.
     * 
     */
    public int getPorcentajeCompra() {
        return porcentajeCompra;
    }

    /**
     * Define el valor de la propiedad porcentajeCompra.
     * 
     */
    public void setPorcentajeCompra(int value) {
        this.porcentajeCompra = value;
    }

}
