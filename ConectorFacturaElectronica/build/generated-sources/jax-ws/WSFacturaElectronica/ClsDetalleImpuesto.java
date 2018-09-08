
package WSFacturaElectronica;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ClsDetalleImpuesto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ClsDetalleImpuesto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tarifa" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Monto" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Exoneracion" type="{}ClsExoneracion" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClsDetalleImpuesto", propOrder = {
    "codigo",
    "tarifa",
    "monto",
    "exoneracion"
})
public class ClsDetalleImpuesto {

    @XmlElement(name = "Codigo")
    protected String codigo;
    @XmlElement(name = "Tarifa", required = true)
    protected BigDecimal tarifa;
    @XmlElement(name = "Monto", required = true)
    protected BigDecimal monto;
    @XmlElement(name = "Exoneracion")
    protected ClsExoneracion exoneracion;

    /**
     * Obtiene el valor de la propiedad codigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define el valor de la propiedad codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

    /**
     * Obtiene el valor de la propiedad tarifa.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTarifa() {
        return tarifa;
    }

    /**
     * Define el valor de la propiedad tarifa.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTarifa(BigDecimal value) {
        this.tarifa = value;
    }

    /**
     * Obtiene el valor de la propiedad monto.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMonto() {
        return monto;
    }

    /**
     * Define el valor de la propiedad monto.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMonto(BigDecimal value) {
        this.monto = value;
    }

    /**
     * Obtiene el valor de la propiedad exoneracion.
     * 
     * @return
     *     possible object is
     *     {@link ClsExoneracion }
     *     
     */
    public ClsExoneracion getExoneracion() {
        return exoneracion;
    }

    /**
     * Define el valor de la propiedad exoneracion.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsExoneracion }
     *     
     */
    public void setExoneracion(ClsExoneracion value) {
        this.exoneracion = value;
    }

}
