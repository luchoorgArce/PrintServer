/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresoras.Epson;

import Entidades.Factura;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author vmora
 */
public class ControladorImpresion { //TODO: Use interfaces
       
    public void printInvoice(Factura invoice) {
        try { 
            Socket sock = new Socket("192.168.1.200", 9100); 
            PrintWriter oStream = new PrintWriter(sock.getOutputStream()); 
            
            for(String line: invoice.getInvoiceLinesToPrint()) {
                oStream.println(line);
            }
      
            oStream.close(); 
            sock.close(); 
        } catch (UnknownHostException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
    }    
}
