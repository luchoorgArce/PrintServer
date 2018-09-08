/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vmora
 */
public class ControladorImpresion implements Runnable {
    
    private Thread t;
    
    ControladorImpresion(){
        System.out.println("Creating ControladorImpresion");
    }
    
    public void run() { 
        while(true)
        {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControladorFacturaElectronica.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Hello from a thread ControladorImpresion!"); 
        }
    }
    
    public void start (){
        System.out.println("Starting ControladorFacturaElectronica");
        if (t == null)
        {
            t = new Thread (this);
            t.start ();
        }
    }
}
