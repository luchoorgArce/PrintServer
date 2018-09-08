
package WSTiqueteElectronco;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para RespuestaEDOC complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RespuestaEDOC">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CodigoError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaAutorizacion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="NumeroConsecutivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClaveComprobante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MensajeRespuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespuestaEDOC", propOrder = {
    "codigoError",
    "fechaAutorizacion",
    "numeroConsecutivo",
    "claveComprobante",
    "estado",
    "mensajeRespuesta"
})
public class RespuestaEDOC {

    @XmlElement(name = "CodigoError")
    protected String codigoError;
    @XmlElement(name = "FechaAutorizacion", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaAutorizacion;
    @XmlElement(name = "NumeroConsecutivo")
    protected String numeroConsecutivo;
    @XmlElement(name = "ClaveComprobante")
    protected String claveComprobante;
    @XmlElement(name = "Estado")
    protected String estado;
    @XmlElement(name = "MensajeRespuesta")
    protected String mensajeRespuesta;

    /**
     * Obtiene el valor de la propiedad codigoError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoError() {
        return codigoError;
    }

    /**
     * Define el valor de la propiedad codigoError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoError(String value) {
        this.codigoError = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaAutorizacion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    /**
     * Define el valor de la propiedad fechaAutorizacion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaAutorizacion(XMLGregorianCalendar value) {
        this.fechaAutorizacion = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroConsecutivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroConsecutivo() {
        return numeroConsecutivo;
    }

    /**
     * Define el valor de la propiedad numeroConsecutivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroConsecutivo(String value) {
        this.numeroConsecutivo = value;
    }

    /**
     * Obtiene el valor de la propiedad claveComprobante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveComprobante() {
        return claveComprobante;
    }

    /**
     * Define el valor de la propiedad claveComprobante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveComprobante(String value) {
        this.claveComprobante = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad mensajeRespuesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    /**
     * Define el valor de la propiedad mensajeRespuesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensajeRespuesta(String value) {
        this.mensajeRespuesta = value;
    }

}
