
package WSTiqueteElectronco;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DatosFacturadorManual complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DatosFacturadorManual">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FacturadorManual" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatosFacturadorManual", propOrder = {
    "facturadorManual"
})
public class DatosFacturadorManual {

    @XmlElement(name = "FacturadorManual")
    protected boolean facturadorManual;

    /**
     * Obtiene el valor de la propiedad facturadorManual.
     * 
     */
    public boolean isFacturadorManual() {
        return facturadorManual;
    }

    /**
     * Define el valor de la propiedad facturadorManual.
     * 
     */
    public void setFacturadorManual(boolean value) {
        this.facturadorManual = value;
    }

}
