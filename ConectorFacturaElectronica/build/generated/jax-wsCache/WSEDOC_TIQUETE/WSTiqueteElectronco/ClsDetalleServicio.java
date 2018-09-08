
package WSTiqueteElectronco;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ClsDetalleServicio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ClsDetalleServicio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Codigos" type="{}ArrayOfClsDetalleCodigo" minOccurs="0"/>
 *         &lt;element name="Cantidad" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="UnidadMedida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnidadMedidaComercial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DetalleDescripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PrecioUnitario" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MontoTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MontoDescuento" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="NaturalezaDescuento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MontoTotalLinea" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Impuestos" type="{}ArrayOfClsDetalleImpuesto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClsDetalleServicio", propOrder = {
    "codigos",
    "cantidad",
    "unidadMedida",
    "unidadMedidaComercial",
    "detalleDescripcion",
    "precioUnitario",
    "montoTotal",
    "montoDescuento",
    "naturalezaDescuento",
    "subTotal",
    "montoTotalLinea",
    "impuestos"
})
public class ClsDetalleServicio {

    @XmlElement(name = "Codigos")
    protected ArrayOfClsDetalleCodigo codigos;
    @XmlElement(name = "Cantidad", required = true)
    protected BigDecimal cantidad;
    @XmlElement(name = "UnidadMedida")
    protected String unidadMedida;
    @XmlElement(name = "UnidadMedidaComercial")
    protected String unidadMedidaComercial;
    @XmlElement(name = "DetalleDescripcion")
    protected String detalleDescripcion;
    @XmlElement(name = "PrecioUnitario", required = true)
    protected BigDecimal precioUnitario;
    @XmlElement(name = "MontoTotal", required = true)
    protected BigDecimal montoTotal;
    @XmlElement(name = "MontoDescuento", required = true)
    protected BigDecimal montoDescuento;
    @XmlElement(name = "NaturalezaDescuento")
    protected String naturalezaDescuento;
    @XmlElement(name = "SubTotal", required = true)
    protected BigDecimal subTotal;
    @XmlElement(name = "MontoTotalLinea", required = true)
    protected BigDecimal montoTotalLinea;
    @XmlElement(name = "Impuestos")
    protected ArrayOfClsDetalleImpuesto impuestos;

    /**
     * Obtiene el valor de la propiedad codigos.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClsDetalleCodigo }
     *     
     */
    public ArrayOfClsDetalleCodigo getCodigos() {
        return codigos;
    }

    /**
     * Define el valor de la propiedad codigos.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClsDetalleCodigo }
     *     
     */
    public void setCodigos(ArrayOfClsDetalleCodigo value) {
        this.codigos = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCantidad(BigDecimal value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad unidadMedida.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnidadMedida() {
        return unidadMedida;
    }

    /**
     * Define el valor de la propiedad unidadMedida.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnidadMedida(String value) {
        this.unidadMedida = value;
    }

    /**
     * Obtiene el valor de la propiedad unidadMedidaComercial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnidadMedidaComercial() {
        return unidadMedidaComercial;
    }

    /**
     * Define el valor de la propiedad unidadMedidaComercial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnidadMedidaComercial(String value) {
        this.unidadMedidaComercial = value;
    }

    /**
     * Obtiene el valor de la propiedad detalleDescripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetalleDescripcion() {
        return detalleDescripcion;
    }

    /**
     * Define el valor de la propiedad detalleDescripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetalleDescripcion(String value) {
        this.detalleDescripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad precioUnitario.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Define el valor de la propiedad precioUnitario.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrecioUnitario(BigDecimal value) {
        this.precioUnitario = value;
    }

    /**
     * Obtiene el valor de la propiedad montoTotal.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    /**
     * Define el valor de la propiedad montoTotal.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoTotal(BigDecimal value) {
        this.montoTotal = value;
    }

    /**
     * Obtiene el valor de la propiedad montoDescuento.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoDescuento() {
        return montoDescuento;
    }

    /**
     * Define el valor de la propiedad montoDescuento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoDescuento(BigDecimal value) {
        this.montoDescuento = value;
    }

    /**
     * Obtiene el valor de la propiedad naturalezaDescuento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaturalezaDescuento() {
        return naturalezaDescuento;
    }

    /**
     * Define el valor de la propiedad naturalezaDescuento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaturalezaDescuento(String value) {
        this.naturalezaDescuento = value;
    }

    /**
     * Obtiene el valor de la propiedad subTotal.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubTotal() {
        return subTotal;
    }

    /**
     * Define el valor de la propiedad subTotal.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubTotal(BigDecimal value) {
        this.subTotal = value;
    }

    /**
     * Obtiene el valor de la propiedad montoTotalLinea.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoTotalLinea() {
        return montoTotalLinea;
    }

    /**
     * Define el valor de la propiedad montoTotalLinea.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoTotalLinea(BigDecimal value) {
        this.montoTotalLinea = value;
    }

    /**
     * Obtiene el valor de la propiedad impuestos.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClsDetalleImpuesto }
     *     
     */
    public ArrayOfClsDetalleImpuesto getImpuestos() {
        return impuestos;
    }

    /**
     * Define el valor de la propiedad impuestos.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClsDetalleImpuesto }
     *     
     */
    public void setImpuestos(ArrayOfClsDetalleImpuesto value) {
        this.impuestos = value;
    }

}
