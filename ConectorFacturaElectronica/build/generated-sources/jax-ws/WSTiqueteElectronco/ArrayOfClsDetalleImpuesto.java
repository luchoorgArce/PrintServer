
package WSTiqueteElectronco;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfClsDetalleImpuesto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClsDetalleImpuesto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClsDetalleImpuesto" type="{}ClsDetalleImpuesto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClsDetalleImpuesto", propOrder = {
    "clsDetalleImpuesto"
})
public class ArrayOfClsDetalleImpuesto {

    @XmlElement(name = "ClsDetalleImpuesto", nillable = true)
    protected List<ClsDetalleImpuesto> clsDetalleImpuesto;

    /**
     * Gets the value of the clsDetalleImpuesto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clsDetalleImpuesto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClsDetalleImpuesto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsDetalleImpuesto }
     * 
     * 
     */
    public List<ClsDetalleImpuesto> getClsDetalleImpuesto() {
        if (clsDetalleImpuesto == null) {
            clsDetalleImpuesto = new ArrayList<ClsDetalleImpuesto>();
        }
        return this.clsDetalleImpuesto;
    }

}
