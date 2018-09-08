
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
 *         &lt;element name="EnviarFacturaResult" type="{}RespuestaEDOC" minOccurs="0"/>
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
    "enviarFacturaResult",
    "mensaje"
})
@XmlRootElement(name = "EnviarFacturaResponse")
public class EnviarFacturaResponse {

    @XmlElement(name = "EnviarFacturaResult")
    protected RespuestaEDOC enviarFacturaResult;
    protected String mensaje;

    /**
     * Obtiene el valor de la propiedad enviarFacturaResult.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaEDOC }
     *     
     */
    public RespuestaEDOC getEnviarFacturaResult() {
        return enviarFacturaResult;
    }

    /**
     * Define el valor de la propiedad enviarFacturaResult.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaEDOC }
     *     
     */
    public void setEnviarFacturaResult(RespuestaEDOC value) {
        this.enviarFacturaResult = value;
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
