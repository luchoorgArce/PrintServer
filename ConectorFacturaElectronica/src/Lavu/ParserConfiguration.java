/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lavu;

import java.util.HashMap;
import java.util.Map;

public class ParserConfiguration {
    private Map<String, String> paymentMethods = new HashMap<String, String>();
    //private Map<String, String> payMethods = new HashMap<String, String>(); //TODO: Implemente the part with all the others strings
    private String laguague = "English"; // Spanish is second option - get it from config file
    
    public ParserConfiguration() {
        buildPayMethods();
    }
    
    private void buildPayMethods() {
        if (laguague.equals("English")) {
            paymentMethods.put("efectivo", "01"); //TODO: Put English version
            paymentMethods.put("tarjeta", "02");
        }
        else if (laguague.equals("Spanish")) {
            paymentMethods.put("efectivo", "01");
            paymentMethods.put("tarjeta", "02");
        }    
    }
    
    public Map<String, String> getPaymentMethods() {
        if (paymentMethods.isEmpty()) {
            buildPayMethods();
        }
        
        return paymentMethods;
    }
}
