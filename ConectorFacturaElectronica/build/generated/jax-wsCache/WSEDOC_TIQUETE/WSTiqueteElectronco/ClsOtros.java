
package WSTiqueteElectronco;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ClsOtros complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ClsOtros">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OtrosTexto" type="{}ArrayOfOtros" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClsOtros", propOrder = {
    "otrosTexto"
})
public class ClsOtros {

    @XmlElement(name = "OtrosTexto")
    protected ArrayOfOtros otrosTexto;

    /**
     * Obtiene el valor de la propiedad otrosTexto.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfOtros }
     *     
     */
    public ArrayOfOtros getOtrosTexto() {
        return otrosTexto;
    }

    /**
     * Define el valor de la propiedad otrosTexto.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfOtros }
     *     
     */
    public void setOtrosTexto(ArrayOfOtros value) {
        this.otrosTexto = value;
    }

}
