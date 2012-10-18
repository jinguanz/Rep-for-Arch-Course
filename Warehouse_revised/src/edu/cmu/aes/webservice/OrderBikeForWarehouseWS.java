package edu.cmu.aes.webservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.Oneway;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;

import org.jboss.soa.esb.message.Message;
import org.jboss.soa.esb.message.Body;
import org.jboss.soa.esb.actions.ActionUtils;

/**
 * @author
 */
@WebService(name = "WarehouseWS", targetNamespace="http://Warehouse_revised/OrderBikeForWarehouseWS")
// @SOAPBinding(style = SOAPBinding.Style.RPC)
public class OrderBikeForWarehouseWS {

    @WebMethod
    public String placeOrder(String message) {
        System.out.println("Web Service Parameter - message=" + message);
        return "Order for bikes placed to refill the inventory. - " + message;
    }
    
}
