
package WSFacturaElectronica;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfClsDetalleCodigo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClsDetalleCodigo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClsDetalleCodigo" type="{}ClsDetalleCodigo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClsDetalleCodigo", propOrder = {
    "clsDetalleCodigo"
})
public class ArrayOfClsDetalleCodigo {

    @XmlElement(name = "ClsDetalleCodigo", nillable = true)
    protected List<ClsDetalleCodigo> clsDetalleCodigo;

    /**
     * Gets the value of the clsDetalleCodigo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clsDetalleCodigo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClsDetalleCodigo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsDetalleCodigo }
     * 
     * 
     */
    public List<ClsDetalleCodigo> getClsDetalleCodigo() {
        if (clsDetalleCodigo == null) {
            clsDetalleCodigo = new ArrayList<ClsDetalleCodigo>();
        }
        return this.clsDetalleCodigo;
    }

}
