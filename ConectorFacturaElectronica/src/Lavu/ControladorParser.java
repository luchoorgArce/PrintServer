/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lavu;

import interfaces.IParser;
import java.util.HashSet;
import java.util.Set;
import Entidades.DetalleFactura;
import Entidades.Factura;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luis.arce
 */
public class ControladorParser implements IParser {
    // Move all these to a Properties/Configuration class
    private final static String ORDERIDLINEA = "Order #:";
    private final static String TOTALLINEA = "Total:"; //TODO: Esto debe reaccionar a la configuracion de lenguge de LAVU
    private final static String SUBTOTALLINEA = "Subtotal:"; //TODO: Esto debe reaccionar a la configuracion de lenguge de LAVU
    private final static String DISCOUNTLINE = "off";
    private final static String TAXESLINE = "IVA";
    
    
    
    private ParserConfiguration pConfiguration = new ParserConfiguration();
    private final static String FACTURADIVISIONES = "------";
    private final static int HEADERSECTION = 0;
    private final static int DETAILSSECTION = 1;
    private final static int TOTALSSECTION = 2;
    private final static int COMPANYINFOSECTION = 3;
      
    @Override 
    public void procesarFactura(String rawFactura, String[] lineasFactura){
        String orderId = getOrderId(lineasFactura);
        
        
        
        /* TODO: First Try is get information from the API */
        
        
        // Get information from the invoice
        Factura newInvoice = getFacturaInformation(lineasFactura, orderId);
        
        System.out.println(orderId + "|");
        System.out.println("Factura Procesada correctamente");
    }
    
    private Factura getFacturaInformation(String[] lineasFactura, String orderID){
        Factura nuevaFactura = new Factura(); //TODO: Set Default values of BigDecimals to Cero
        int currentSecction = HEADERSECTION;
        int lineasConteo = 0;
        
        for(int index = 0; index < lineasFactura.length; index++) {
            if (esLineaValida(lineasFactura[index])) {
                if (isInvoiceDivision(lineasFactura[index])) {
                    currentSecction += 1;
                    continue;
                }
                
                if (currentSecction == TOTALSSECTION) {
                    processTotalSection(nuevaFactura, lineasFactura[index]);
                }
                else if(currentSecction == DETAILSSECTION) {
                    processInvoiceDetailSection(nuevaFactura, lineasFactura[index]);
                }
            }
        }
        
        return nuevaFactura;
    }
    
    private void processInvoiceDetailSection(Factura invoice, String line) {
        int lineCount = 0;
        
        if (isFirstCharNumber(line)) {
            lineCount += 1;
            DetalleFactura dFactura = construirDetalleFactura(line, lineCount);                       
            dFactura.setLinea(lineCount);
            invoice.setDetalleFactura(dFactura);
        }
        else {
            DetalleFactura dFActura = invoice.getDetalleFactura().get(lineCount - 1);
            BigDecimal additionalAmount = new BigDecimal(getInvoiceDetailAdditionalAmount(line));
            if (additionalAmount.compareTo(BigDecimal.ZERO) > 0) {   
                dFActura.setMonto(dFActura.getMonto().add(additionalAmount));
                dFActura.setSubTotal(dFActura.getMonto());
                dFActura.setMontoTotalLinea(dFActura.getSubTotal());
                dFActura.setPrecioUnitario(dFActura.getMonto().divide(BigDecimal.valueOf(dFActura.getCantidad())));
            }
            else {          
                 // It is a line discount
                 dFActura.setMontoDescuento(additionalAmount);
                 dFActura.setNaturalezaDescuento(getLineaContenido(line, 3));
                 dFActura.setSubTotal(dFActura.getMonto().add(additionalAmount));
                 dFActura.setMontoTotalLinea(dFActura.getSubTotal());
            }                        
        }
    }
    
    private void processTotalSection(Factura invoice, String line) {
        String paymentMethod = "";
        
        if (line.contains(SUBTOTALLINEA)) {
            BigDecimal subTotal = new BigDecimal(getNumberBackward(line));
            invoice.setTotalVenta(subTotal); 
        }
        else if (line.contains(TOTALLINEA) && !line.contains(SUBTOTALLINEA)) {
            BigDecimal total = new BigDecimal(getNumberBackward(line));
            invoice.setTotalComprante(total);
        }
        else if(line.contains(DISCOUNTLINE)) {
            BigDecimal discountTotal = new BigDecimal(getNumberBackward(line));
            invoice.setTotalDescuentos(discountTotal);
            invoice.setTotalVentaNeta(invoice.getTotalVenta().subtract(invoice.getTotalDescuentos()));
        }
        else if(line.contains(TAXESLINE)) {
             BigDecimal taxes = new BigDecimal(getNumberBackward(line));
             invoice.setTotalImpuesto(taxes);
        }
        else if(!(paymentMethod = getPaymentMethod(line)).equals("")){
            invoice.setPaymentMethod(paymentMethod);
        }
    }
     
    private String getPaymentMethod(String line) {
        String result = "";
        
        Map<String, String> paymentMethods = pConfiguration.getPaymentMethods();
        for (Map.Entry<String, String> entry : paymentMethods.entrySet())
        {
            if (line.contains(entry.getKey())) {
                result = entry.getValue();
                break;
            }
        }
        
        return result;
    }
    
    private String getInvoiceDetailAdditionalAmount(String line) {
        String result = getNumberBackward(line);
        
        if (result.equals("")) {
            result = "0.0";
        }
              
        return result;
    }
    
    private String getNumberBackward (String line) {
        String[] chars = line.split("");
        String total = "";
        
        for(int index = chars.length - 1; index >= 0; index--) {
            if((Character.isDigit(chars[index].charAt(0))) ||
               (chars[index].equals("-")) ||
               (chars[index].equals(".")) ||
               (chars[index].equals(","))) {
                total = chars[index] + total;
            }
            else {
                break;
            }
        }
        
        return total;
    }
    
    private String getNumber(String number) {
        String[] chars = number.split("");
        String result = "";
        
        for(int index = 0; index < chars.length; index++) {
            // Check if Character is part of a Number
            if((Character.isDigit(chars[index].charAt(0))) ||
               (chars[index].equals(".")) ||
               (chars[index].equals(","))) {
                result += chars[index];
            }
            else {
                break;
            }
        }
        
        return result;
    }
    
    private void buildInvoiceDefault(Factura invoice) {
        invoice.setTotalVenta(new BigDecimal("0.0")); ;
        invoice.setTotalComprante(new BigDecimal("0.0"));
        invoice.setTotalImpuesto(new BigDecimal("0.0"));
        invoice.setTotalVentaNeta(new BigDecimal("0.0"));            
        invoice.setTotalDescuentos(new BigDecimal("0.0"));
    }
    
    
    private DetalleFactura construirDetalleFactura(String line, int lineCount) {
        String[] lineChars = line.split("");
        DetalleFactura newFLine = new DetalleFactura();
        int lineQuantity = -1;
        BigDecimal lineAmount = new BigDecimal("-1.0");
        String lineDescription = "";
        
        newFLine.setLinea(lineCount);
        
        for(int index = 0; index < lineChars.length; index++) {
            if(Character.isDigit(lineChars[index].charAt(0))) {
                if (lineQuantity == -1) { // Check if Quantity has not set yeld
                    String numberString = getNumber(line.substring(index, line.length()));
                    lineQuantity = Integer.parseInt(numberString);
                }
                else {
                    String numberString = getNumber(line.substring(index, line.length()));
                    lineAmount = new BigDecimal(numberString);
                    break;
                }
            }
            else if ((Character.isAlphabetic(lineChars[index].charAt(0))) && lineDescription.equals("")) {
                lineDescription = getLineaContenido(line.substring(index, line.length()), 3);
            }
        }
        
        newFLine.setCantidad(lineQuantity);
        newFLine.setMonto(lineAmount);
        newFLine.setSubTotal(lineAmount);
        newFLine.setMontoTotalLinea(lineAmount);
        newFLine.setDescripcion(lineDescription);
          
        return newFLine;
    }
    
    private String getOrderId(String[] lineasFactura) {
        String orderId = "";
        
        for(int index = 0; index < lineasFactura.length; index++) {
            if (esLineaValida(lineasFactura[index]) &&
                lineasFactura[index].indexOf(ORDERIDLINEA) >= 0) {
                int indexOrderId = lineasFactura[index].indexOf(ORDERIDLINEA) + ORDERIDLINEA.length() + 1;
                orderId = getOrderIdDeLinea(lineasFactura[index], indexOrderId);
                break;
            }
        }
               
        return orderId;
    }
    
    private String getOrderIdDeLinea(String linea, int indexOrderId) {
        String orderId = "";
        String[] lineaChars = linea.split("");
        
        for(int index = indexOrderId; index < lineaChars.length; index++) {
            if(!lineaChars[index].equals(" ")) {
                orderId += lineaChars[index];
            }
            else {
                break;
            }
        }
        
        return orderId;
    }
    
    private String getLineaContenido(String linea, int emptySpaceBeforeBreak) {
        String result = "";
        String resultBuffer = "";
        boolean firstCharFound = false;
        int emptySpacesCount = 0; 
        
        String[] lineaChars = linea.split("");
        
        for(int index = 0; index < lineaChars.length; index++) {
            firstCharFound = !lineaChars[index].equals(" ") || firstCharFound;
            emptySpacesCount = firstCharFound && lineaChars[index].equals(" ") ? emptySpacesCount + 1 : 0;
            
            if (firstCharFound) {
                if(emptySpacesCount > emptySpaceBeforeBreak) {
                    result = resultBuffer.substring(0, resultBuffer.length() - emptySpaceBeforeBreak);
                    break;
                }
                else {
                    resultBuffer += lineaChars[index];
                }                
            }
        }
        
        return result;
    }
    
    private boolean esLineaValida(String linea) {
        return linea != null && linea != "";
    }
    
    private boolean isInvoiceDivision(String linea) {
        return linea.indexOf(FACTURADIVISIONES) >= 0;
    }
    
    private boolean isFirstCharNumber(String linea) {
        boolean result = false;
        String[] lineaChars = linea.split("");
        
        for(int index = 0; index < lineaChars.length; index++) {
            if(!lineaChars[index].equals(" ")) {
                result = Character.isDigit(lineaChars[index].charAt(0));
                break;
            }
        }
        
        return result;
    }
    
    private boolean lineaContieneTotal(String linea) {
        return (linea.indexOf(TOTALLINEA) >= 0) && (linea.indexOf(SUBTOTALLINEA) < 0);
    }
    
    
}
