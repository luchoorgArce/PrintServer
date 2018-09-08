
package WSFacturaElectronica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ClsReceptor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ClsReceptor">
 *   &lt;complexContent>
 *     &lt;extension base="{}ClsEmisor">
 *       &lt;sequence>
 *         &lt;element name="IdentificacionExtranjero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClsReceptor", propOrder = {
    "identificacionExtranjero"
})
public class ClsReceptor
    extends ClsEmisor
{

    @XmlElement(name = "IdentificacionExtranjero")
    protected String identificacionExtranjero;

    /**
     * Obtiene el valor de la propiedad identificacionExtranjero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificacionExtranjero() {
        return identificacionExtranjero;
    }

    /**
     * Define el valor de la propiedad identificacionExtranjero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificacionExtranjero(String value) {
        this.identificacionExtranjero = value;
    }

}
