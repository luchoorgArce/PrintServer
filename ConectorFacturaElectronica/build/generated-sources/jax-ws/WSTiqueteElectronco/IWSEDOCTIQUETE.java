
package WSTiqueteElectronco;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IWSEDOC_TIQUETE", targetNamespace = "")
@HandlerChain(file = "IWSEDOCTIQUETE_handler.xml")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IWSEDOCTIQUETE {


    /**
     * 
     * @param enviarTiqueteResult
     * @param clave
     * @param tiquete
     * @param mensaje
     * @param entorno
     */
    @WebMethod(operationName = "EnviarTiquete", action = "urn:IWSEDOC_TIQUETE/EnviarTiquete")
    @RequestWrapper(localName = "EnviarTiquete", targetNamespace = "", className = "WSTiqueteElectronco.EnviarTiquete")
    @ResponseWrapper(localName = "EnviarTiqueteResponse", targetNamespace = "", className = "WSTiqueteElectronco.EnviarTiqueteResponse")
    public void enviarTiquete(
        @WebParam(name = "Clave", targetNamespace = "")
        String clave,
        @WebParam(name = "Entorno", targetNamespace = "")
        String entorno,
        @WebParam(name = "Tiquete", targetNamespace = "")
        ClsTiquete tiquete,
        @WebParam(name = "mensaje", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<String> mensaje,
        @WebParam(name = "EnviarTiqueteResult", targetNamespace = "", mode = WebParam.Mode.OUT)
        Holder<RespuestaEDOC> enviarTiqueteResult);

}
