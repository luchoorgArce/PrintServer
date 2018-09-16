/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FacturaElectronica.GuruSoft;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Hugo
 */
public class ControladorBase {
    public String ConvertirFecha(XMLGregorianCalendar fecha){
        return String.format("%s-%02d-%02d %02d:%02d:%02d:%s", 
                fecha.getYear(), fecha.getMonth(), fecha.getDay(), fecha.getHour(), fecha.getMinute(), fecha.getSecond(), fecha.getMillisecond());
    }
}
