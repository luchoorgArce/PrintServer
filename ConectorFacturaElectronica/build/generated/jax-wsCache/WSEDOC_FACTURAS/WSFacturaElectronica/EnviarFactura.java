
package WSFacturaElectronica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Clave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Entorno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Factura" type="{}ClsFactura" minOccurs="0"/>
 *         &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clave",
    "entorno",
    "factura",
    "mensaje"
})
@XmlRootElement(name = "EnviarFactura")
public class EnviarFactura {

    @XmlElement(name = "Clave")
    protected String clave;
    @XmlElement(name = "Entorno")
    protected String entorno;
    @XmlElement(name = "Factura")
    protected ClsFactura factura;
    protected String mensaje;

    /**
     * Obtiene el valor de la propiedad clave.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClave() {
        return clave;
    }

    /**
     * Define el valor de la propiedad clave.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClave(String value) {
        this.clave = value;
    }

    /**
     * Obtiene el valor de la propiedad entorno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntorno() {
        return entorno;
    }

    /**
     * Define el valor de la propiedad entorno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntorno(String value) {
        this.entorno = value;
    }

    /**
     * Obtiene el valor de la propiedad factura.
     * 
     * @return
     *     possible object is
     *     {@link ClsFactura }
     *     
     */
    public ClsFactura getFactura() {
        return factura;
    }

    /**
     * Define el valor de la propiedad factura.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsFactura }
     *     
     */
    public void setFactura(ClsFactura value) {
        this.factura = value;
    }

    /**
     * Obtiene el valor de la propiedad mensaje.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Define el valor de la propiedad mensaje.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensaje(String value) {
        this.mensaje = value;
    }

}
