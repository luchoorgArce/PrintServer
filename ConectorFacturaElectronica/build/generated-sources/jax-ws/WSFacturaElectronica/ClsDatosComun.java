
package WSFacturaElectronica;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para ClsDatosComun complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ClsDatosComun">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MatrizEstab" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PuntoVenta" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Secuencial" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FechaEmision" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Emisor" type="{}ClsEmisor" minOccurs="0"/>
 *         &lt;element name="Receptor" type="{}ClsReceptor" minOccurs="0"/>
 *         &lt;element name="CodCondicionVenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PlazoCredito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodMedioPago1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodMedioPago2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodMedioPago3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodMedioPago4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodigoMoneda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TipoCambio" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TotalServGravados" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TotalServExentos" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TotalMercanciasGravadas" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TotalMercanciasExentas" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TotalGravado" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TotalExento" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TotalVenta" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TotalDescuentos" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TotalVentaNeta" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TotalImpuesto" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TotalComprobante" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="SinInternet" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="DatosFacturadorManual" type="{}DatosFacturadorManual" minOccurs="0"/>
 *         &lt;element name="UsuarioTransaccionERP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodigoTransaccionERP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecuencialERP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmailResponsable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Campo1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Campo2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Campo3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Campo4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Campo5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Campo6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Campo7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Campo8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Campo9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Campo10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DirectorioDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NombreDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClaveCertificado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Adjunto" type="{}ArrayOfArchivo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClsDatosComun", propOrder = {
    "matrizEstab",
    "puntoVenta",
    "secuencial",
    "fechaEmision",
    "emisor",
    "receptor",
    "codCondicionVenta",
    "plazoCredito",
    "codMedioPago1",
    "codMedioPago2",
    "codMedioPago3",
    "codMedioPago4",
    "codigoMoneda",
    "tipoCambio",
    "totalServGravados",
    "totalServExentos",
    "totalMercanciasGravadas",
    "totalMercanciasExentas",
    "totalGravado",
    "totalExento",
    "totalVenta",
    "totalDescuentos",
    "totalVentaNeta",
    "totalImpuesto",
    "totalComprobante",
    "sinInternet",
    "datosFacturadorManual",
    "usuarioTransaccionERP",
    "codigoTransaccionERP",
    "secuencialERP",
    "emailResponsable",
    "campo1",
    "campo2",
    "campo3",
    "campo4",
    "campo5",
    "campo6",
    "campo7",
    "campo8",
    "campo9",
    "campo10",
    "directorioDocumento",
    "nombreDocumento",
    "claveCertificado",
    "adjunto"
})
@XmlSeeAlso({
    ClsFactura.class
})
public class ClsDatosComun {

    @XmlElement(name = "MatrizEstab")
    protected int matrizEstab;
    @XmlElement(name = "PuntoVenta")
    protected int puntoVenta;
    @XmlElement(name = "Secuencial")
    protected int secuencial;
    @XmlElement(name = "FechaEmision", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEmision;
    @XmlElement(name = "Emisor")
    protected ClsEmisor emisor;
    @XmlElement(name = "Receptor")
    protected ClsReceptor receptor;
    @XmlElement(name = "CodCondicionVenta")
    protected String codCondicionVenta;
    @XmlElement(name = "PlazoCredito")
    protected String plazoCredito;
    @XmlElement(name = "CodMedioPago1")
    protected String codMedioPago1;
    @XmlElement(name = "CodMedioPago2")
    protected String codMedioPago2;
    @XmlElement(name = "CodMedioPago3")
    protected String codMedioPago3;
    @XmlElement(name = "CodMedioPago4")
    protected String codMedioPago4;
    @XmlElement(name = "CodigoMoneda")
    protected String codigoMoneda;
    @XmlElement(name = "TipoCambio", required = true)
    protected BigDecimal tipoCambio;
    @XmlElement(name = "TotalServGravados", required = true)
    protected BigDecimal totalServGravados;
    @XmlElement(name = "TotalServExentos", required = true)
    protected BigDecimal totalServExentos;
    @XmlElement(name = "TotalMercanciasGravadas", required = true)
    protected BigDecimal totalMercanciasGravadas;
    @XmlElement(name = "TotalMercanciasExentas", required = true)
    protected BigDecimal totalMercanciasExentas;
    @XmlElement(name = "TotalGravado", required = true)
    protected BigDecimal totalGravado;
    @XmlElement(name = "TotalExento", required = true)
    protected BigDecimal totalExento;
    @XmlElement(name = "TotalVenta", required = true)
    protected BigDecimal totalVenta;
    @XmlElement(name = "TotalDescuentos", required = true)
    protected BigDecimal totalDescuentos;
    @XmlElement(name = "TotalVentaNeta", required = true)
    protected BigDecimal totalVentaNeta;
    @XmlElement(name = "TotalImpuesto", required = true)
    protected BigDecimal totalImpuesto;
    @XmlElement(name = "TotalComprobante", required = true)
    protected BigDecimal totalComprobante;
    @XmlElement(name = "SinInternet")
    protected boolean sinInternet;
    @XmlElement(name = "DatosFacturadorManual")
    protected DatosFacturadorManual datosFacturadorManual;
    @XmlElement(name = "UsuarioTransaccionERP")
    protected String usuarioTransaccionERP;
    @XmlElement(name = "CodigoTransaccionERP")
    protected String codigoTransaccionERP;
    @XmlElement(name = "SecuencialERP")
    protected String secuencialERP;
    @XmlElement(name = "EmailResponsable")
    protected String emailResponsable;
    @XmlElement(name = "Campo1")
    protected String campo1;
    @XmlElement(name = "Campo2")
    protected String campo2;
    @XmlElement(name = "Campo3")
    protected String campo3;
    @XmlElement(name = "Campo4")
    protected String campo4;
    @XmlElement(name = "Campo5")
    protected String campo5;
    @XmlElement(name = "Campo6")
    protected String campo6;
    @XmlElement(name = "Campo7")
    protected String campo7;
    @XmlElement(name = "Campo8")
    protected String campo8;
    @XmlElement(name = "Campo9")
    protected String campo9;
    @XmlElement(name = "Campo10")
    protected String campo10;
    @XmlElement(name = "DirectorioDocumento")
    protected String directorioDocumento;
    @XmlElement(name = "NombreDocumento")
    protected String nombreDocumento;
    @XmlElement(name = "ClaveCertificado")
    protected String claveCertificado;
    @XmlElement(name = "Adjunto")
    protected ArrayOfArchivo adjunto;

    /**
     * Obtiene el valor de la propiedad matrizEstab.
     * 
     */
    public int getMatrizEstab() {
        return matrizEstab;
    }

    /**
     * Define el valor de la propiedad matrizEstab.
     * 
     */
    public void setMatrizEstab(int value) {
        this.matrizEstab = value;
    }

    /**
     * Obtiene el valor de la propiedad puntoVenta.
     * 
     */
    public int getPuntoVenta() {
        return puntoVenta;
    }

    /**
     * Define el valor de la propiedad puntoVenta.
     * 
     */
    public void setPuntoVenta(int value) {
        this.puntoVenta = value;
    }

    /**
     * Obtiene el valor de la propiedad secuencial.
     * 
     */
    public int getSecuencial() {
        return secuencial;
    }

    /**
     * Define el valor de la propiedad secuencial.
     * 
     */
    public void setSecuencial(int value) {
        this.secuencial = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaEmision.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Define el valor de la propiedad fechaEmision.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEmision(XMLGregorianCalendar value) {
        this.fechaEmision = value;
    }

    /**
     * Obtiene el valor de la propiedad emisor.
     * 
     * @return
     *     possible object is
     *     {@link ClsEmisor }
     *     
     */
    public ClsEmisor getEmisor() {
        return emisor;
    }

    /**
     * Define el valor de la propiedad emisor.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsEmisor }
     *     
     */
    public void setEmisor(ClsEmisor value) {
        this.emisor = value;
    }

    /**
     * Obtiene el valor de la propiedad receptor.
     * 
     * @return
     *     possible object is
     *     {@link ClsReceptor }
     *     
     */
    public ClsReceptor getReceptor() {
        return receptor;
    }

    /**
     * Define el valor de la propiedad receptor.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsReceptor }
     *     
     */
    public void setReceptor(ClsReceptor value) {
        this.receptor = value;
    }

    /**
     * Obtiene el valor de la propiedad codCondicionVenta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCondicionVenta() {
        return codCondicionVenta;
    }

    /**
     * Define el valor de la propiedad codCondicionVenta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCondicionVenta(String value) {
        this.codCondicionVenta = value;
    }

    /**
     * Obtiene el valor de la propiedad plazoCredito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlazoCredito() {
        return plazoCredito;
    }

    /**
     * Define el valor de la propiedad plazoCredito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlazoCredito(String value) {
        this.plazoCredito = value;
    }

    /**
     * Obtiene el valor de la propiedad codMedioPago1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMedioPago1() {
        return codMedioPago1;
    }

    /**
     * Define el valor de la propiedad codMedioPago1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMedioPago1(String value) {
        this.codMedioPago1 = value;
    }

    /**
     * Obtiene el valor de la propiedad codMedioPago2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMedioPago2() {
        return codMedioPago2;
    }

    /**
     * Define el valor de la propiedad codMedioPago2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMedioPago2(String value) {
        this.codMedioPago2 = value;
    }

    /**
     * Obtiene el valor de la propiedad codMedioPago3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMedioPago3() {
        return codMedioPago3;
    }

    /**
     * Define el valor de la propiedad codMedioPago3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMedioPago3(String value) {
        this.codMedioPago3 = value;
    }

    /**
     * Obtiene el valor de la propiedad codMedioPago4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMedioPago4() {
        return codMedioPago4;
    }

    /**
     * Define el valor de la propiedad codMedioPago4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMedioPago4(String value) {
        this.codMedioPago4 = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoMoneda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoMoneda() {
        return codigoMoneda;
    }

    /**
     * Define el valor de la propiedad codigoMoneda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoMoneda(String value) {
        this.codigoMoneda = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCambio.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    /**
     * Define el valor de la propiedad tipoCambio.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTipoCambio(BigDecimal value) {
        this.tipoCambio = value;
    }

    /**
     * Obtiene el valor de la propiedad totalServGravados.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalServGravados() {
        return totalServGravados;
    }

    /**
     * Define el valor de la propiedad totalServGravados.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalServGravados(BigDecimal value) {
        this.totalServGravados = value;
    }

    /**
     * Obtiene el valor de la propiedad totalServExentos.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalServExentos() {
        return totalServExentos;
    }

    /**
     * Define el valor de la propiedad totalServExentos.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalServExentos(BigDecimal value) {
        this.totalServExentos = value;
    }

    /**
     * Obtiene el valor de la propiedad totalMercanciasGravadas.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalMercanciasGravadas() {
        return totalMercanciasGravadas;
    }

    /**
     * Define el valor de la propiedad totalMercanciasGravadas.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalMercanciasGravadas(BigDecimal value) {
        this.totalMercanciasGravadas = value;
    }

    /**
     * Obtiene el valor de la propiedad totalMercanciasExentas.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalMercanciasExentas() {
        return totalMercanciasExentas;
    }

    /**
     * Define el valor de la propiedad totalMercanciasExentas.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalMercanciasExentas(BigDecimal value) {
        this.totalMercanciasExentas = value;
    }

    /**
     * Obtiene el valor de la propiedad totalGravado.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalGravado() {
        return totalGravado;
    }

    /**
     * Define el valor de la propiedad totalGravado.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalGravado(BigDecimal value) {
        this.totalGravado = value;
    }

    /**
     * Obtiene el valor de la propiedad totalExento.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalExento() {
        return totalExento;
    }

    /**
     * Define el valor de la propiedad totalExento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalExento(BigDecimal value) {
        this.totalExento = value;
    }

    /**
     * Obtiene el valor de la propiedad totalVenta.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    /**
     * Define el valor de la propiedad totalVenta.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalVenta(BigDecimal value) {
        this.totalVenta = value;
    }

    /**
     * Obtiene el valor de la propiedad totalDescuentos.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalDescuentos() {
        return totalDescuentos;
    }

    /**
     * Define el valor de la propiedad totalDescuentos.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalDescuentos(BigDecimal value) {
        this.totalDescuentos = value;
    }

    /**
     * Obtiene el valor de la propiedad totalVentaNeta.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalVentaNeta() {
        return totalVentaNeta;
    }

    /**
     * Define el valor de la propiedad totalVentaNeta.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalVentaNeta(BigDecimal value) {
        this.totalVentaNeta = value;
    }

    /**
     * Obtiene el valor de la propiedad totalImpuesto.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalImpuesto() {
        return totalImpuesto;
    }

    /**
     * Define el valor de la propiedad totalImpuesto.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalImpuesto(BigDecimal value) {
        this.totalImpuesto = value;
    }

    /**
     * Obtiene el valor de la propiedad totalComprobante.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalComprobante() {
        return totalComprobante;
    }

    /**
     * Define el valor de la propiedad totalComprobante.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalComprobante(BigDecimal value) {
        this.totalComprobante = value;
    }

    /**
     * Obtiene el valor de la propiedad sinInternet.
     * 
     */
    public boolean isSinInternet() {
        return sinInternet;
    }

    /**
     * Define el valor de la propiedad sinInternet.
     * 
     */
    public void setSinInternet(boolean value) {
        this.sinInternet = value;
    }

    /**
     * Obtiene el valor de la propiedad datosFacturadorManual.
     * 
     * @return
     *     possible object is
     *     {@link DatosFacturadorManual }
     *     
     */
    public DatosFacturadorManual getDatosFacturadorManual() {
        return datosFacturadorManual;
    }

    /**
     * Define el valor de la propiedad datosFacturadorManual.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosFacturadorManual }
     *     
     */
    public void setDatosFacturadorManual(DatosFacturadorManual value) {
        this.datosFacturadorManual = value;
    }

    /**
     * Obtiene el valor de la propiedad usuarioTransaccionERP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioTransaccionERP() {
        return usuarioTransaccionERP;
    }

    /**
     * Define el valor de la propiedad usuarioTransaccionERP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioTransaccionERP(String value) {
        this.usuarioTransaccionERP = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoTransaccionERP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoTransaccionERP() {
        return codigoTransaccionERP;
    }

    /**
     * Define el valor de la propiedad codigoTransaccionERP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoTransaccionERP(String value) {
        this.codigoTransaccionERP = value;
    }

    /**
     * Obtiene el valor de la propiedad secuencialERP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecuencialERP() {
        return secuencialERP;
    }

    /**
     * Define el valor de la propiedad secuencialERP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecuencialERP(String value) {
        this.secuencialERP = value;
    }

    /**
     * Obtiene el valor de la propiedad emailResponsable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailResponsable() {
        return emailResponsable;
    }

    /**
     * Define el valor de la propiedad emailResponsable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailResponsable(String value) {
        this.emailResponsable = value;
    }

    /**
     * Obtiene el valor de la propiedad campo1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampo1() {
        return campo1;
    }

    /**
     * Define el valor de la propiedad campo1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampo1(String value) {
        this.campo1 = value;
    }

    /**
     * Obtiene el valor de la propiedad campo2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampo2() {
        return campo2;
    }

    /**
     * Define el valor de la propiedad campo2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampo2(String value) {
        this.campo2 = value;
    }

    /**
     * Obtiene el valor de la propiedad campo3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampo3() {
        return campo3;
    }

    /**
     * Define el valor de la propiedad campo3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampo3(String value) {
        this.campo3 = value;
    }

    /**
     * Obtiene el valor de la propiedad campo4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampo4() {
        return campo4;
    }

    /**
     * Define el valor de la propiedad campo4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampo4(String value) {
        this.campo4 = value;
    }

    /**
     * Obtiene el valor de la propiedad campo5.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampo5() {
        return campo5;
    }

    /**
     * Define el valor de la propiedad campo5.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampo5(String value) {
        this.campo5 = value;
    }

    /**
     * Obtiene el valor de la propiedad campo6.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampo6() {
        return campo6;
    }

    /**
     * Define el valor de la propiedad campo6.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampo6(String value) {
        this.campo6 = value;
    }

    /**
     * Obtiene el valor de la propiedad campo7.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampo7() {
        return campo7;
    }

    /**
     * Define el valor de la propiedad campo7.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampo7(String value) {
        this.campo7 = value;
    }

    /**
     * Obtiene el valor de la propiedad campo8.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampo8() {
        return campo8;
    }

    /**
     * Define el valor de la propiedad campo8.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampo8(String value) {
        this.campo8 = value;
    }

    /**
     * Obtiene el valor de la propiedad campo9.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampo9() {
        return campo9;
    }

    /**
     * Define el valor de la propiedad campo9.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampo9(String value) {
        this.campo9 = value;
    }

    /**
     * Obtiene el valor de la propiedad campo10.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampo10() {
        return campo10;
    }

    /**
     * Define el valor de la propiedad campo10.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampo10(String value) {
        this.campo10 = value;
    }

    /**
     * Obtiene el valor de la propiedad directorioDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectorioDocumento() {
        return directorioDocumento;
    }

    /**
     * Define el valor de la propiedad directorioDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectorioDocumento(String value) {
        this.directorioDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreDocumento() {
        return nombreDocumento;
    }

    /**
     * Define el valor de la propiedad nombreDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreDocumento(String value) {
        this.nombreDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad claveCertificado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveCertificado() {
        return claveCertificado;
    }

    /**
     * Define el valor de la propiedad claveCertificado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveCertificado(String value) {
        this.claveCertificado = value;
    }

    /**
     * Obtiene el valor de la propiedad adjunto.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfArchivo }
     *     
     */
    public ArrayOfArchivo getAdjunto() {
        return adjunto;
    }

    /**
     * Define el valor de la propiedad adjunto.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfArchivo }
     *     
     */
    public void setAdjunto(ArrayOfArchivo value) {
        this.adjunto = value;
    }

}
