/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor1;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

/**
 *
 * @author Usuario
 */
public class ControladorFacturaElectronica implements Runnable {
    
    private Thread t;
    
    ControladorFacturaElectronica(){
        System.out.println("Creating ControladorFacturaElectronica");
    }
    
    public void run() { 
        while(true)
        {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControladorFacturaElectronica.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Hello from a thread ControladorFacturaElectronica!"); 
        }
    }
    
    //Se revisa si hay facturas electrónicas pendientes de enviar a Lavu:
   private void EnviarFacturas(){
       
   }
    
    public void start (){
        System.out.println("Starting ControladorFacturaElectronica");
        if (t == null)
        {
            t = new Thread (this);
            t.start ();
        }
    }

    public static void enviarFactura(java.lang.String clave, java.lang.String entorno, WSFacturaElectronica.ClsFactura factura, javax.xml.ws.Holder<java.lang.String> mensaje, javax.xml.ws.Holder<WSFacturaElectronica.RespuestaEDOC> enviarFacturaResult) {
        WSFacturaElectronica.WSEDOCFACTURAS service = new WSFacturaElectronica.WSEDOCFACTURAS();
        WSFacturaElectronica.IWSEDOCFACTURAS port = service.getBasicHttpBindingIWSEDOCFACTURAS();
        
        BindingProvider bindingProvider = (BindingProvider) port;
        Binding binding = bindingProvider.getBinding();
        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new LogMessageHandler());
        binding.setHandlerChain(handlerChain);
        
        port.enviarFactura(clave, entorno, factura, mensaje, enviarFacturaResult);
        
        int gg = 4;
        
    }
}
