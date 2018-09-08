
package WSFacturaElectronica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ClsFactura complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ClsFactura">
 *   &lt;complexContent>
 *     &lt;extension base="{}ClsDatosComun">
 *       &lt;sequence>
 *         &lt;element name="DetalleServicio" type="{}ArrayOfClsDetalleServicio" minOccurs="0"/>
 *         &lt;element name="InformacionReferencia" type="{}ArrayOfClsInformacionReferencia" minOccurs="0"/>
 *         &lt;element name="Otros" type="{}ClsOtros" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClsFactura", propOrder = {
    "detalleServicio",
    "informacionReferencia",
    "otros"
})
public class ClsFactura
    extends ClsDatosComun
{

    @XmlElement(name = "DetalleServicio")
    protected ArrayOfClsDetalleServicio detalleServicio;
    @XmlElement(name = "InformacionReferencia")
    protected ArrayOfClsInformacionReferencia informacionReferencia;
    @XmlElement(name = "Otros")
    protected ClsOtros otros;

    /**
     * Obtiene el valor de la propiedad detalleServicio.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClsDetalleServicio }
     *     
     */
    public ArrayOfClsDetalleServicio getDetalleServicio() {
        return detalleServicio;
    }

    /**
     * Define el valor de la propiedad detalleServicio.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClsDetalleServicio }
     *     
     */
    public void setDetalleServicio(ArrayOfClsDetalleServicio value) {
        this.detalleServicio = value;
    }

    /**
     * Obtiene el valor de la propiedad informacionReferencia.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClsInformacionReferencia }
     *     
     */
    public ArrayOfClsInformacionReferencia getInformacionReferencia() {
        return informacionReferencia;
    }

    /**
     * Define el valor de la propiedad informacionReferencia.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClsInformacionReferencia }
     *     
     */
    public void setInformacionReferencia(ArrayOfClsInformacionReferencia value) {
        this.informacionReferencia = value;
    }

    /**
     * Obtiene el valor de la propiedad otros.
     * 
     * @return
     *     possible object is
     *     {@link ClsOtros }
     *     
     */
    public ClsOtros getOtros() {
        return otros;
    }

    /**
     * Define el valor de la propiedad otros.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsOtros }
     *     
     */
    public void setOtros(ClsOtros value) {
        this.otros = value;
    }

}
