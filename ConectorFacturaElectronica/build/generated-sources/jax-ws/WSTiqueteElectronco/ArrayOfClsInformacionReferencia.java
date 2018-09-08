
package WSTiqueteElectronco;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfClsInformacionReferencia complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClsInformacionReferencia">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClsInformacionReferencia" type="{}ClsInformacionReferencia" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClsInformacionReferencia", propOrder = {
    "clsInformacionReferencia"
})
public class ArrayOfClsInformacionReferencia {

    @XmlElement(name = "ClsInformacionReferencia", nillable = true)
    protected List<ClsInformacionReferencia> clsInformacionReferencia;

    /**
     * Gets the value of the clsInformacionReferencia property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clsInformacionReferencia property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClsInformacionReferencia().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsInformacionReferencia }
     * 
     * 
     */
    public List<ClsInformacionReferencia> getClsInformacionReferencia() {
        if (clsInformacionReferencia == null) {
            clsInformacionReferencia = new ArrayList<ClsInformacionReferencia>();
        }
        return this.clsInformacionReferencia;
    }

}
