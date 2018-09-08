
package WSFacturaElectronica;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfClsDetalleServicio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClsDetalleServicio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClsDetalleServicio" type="{}ClsDetalleServicio" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClsDetalleServicio", propOrder = {
    "clsDetalleServicio"
})
public class ArrayOfClsDetalleServicio {

    @XmlElement(name = "ClsDetalleServicio", nillable = true)
    protected List<ClsDetalleServicio> clsDetalleServicio;

    /**
     * Gets the value of the clsDetalleServicio property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clsDetalleServicio property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClsDetalleServicio().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsDetalleServicio }
     * 
     * 
     */
    public List<ClsDetalleServicio> getClsDetalleServicio() {
        if (clsDetalleServicio == null) {
            clsDetalleServicio = new ArrayList<ClsDetalleServicio>();
        }
        return this.clsDetalleServicio;
    }

}
