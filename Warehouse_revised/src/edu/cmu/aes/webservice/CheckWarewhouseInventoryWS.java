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
@WebService(name = "WarehouseCheckInventoryWS", targetNamespace="http://Warehouse_revised/WarehouseCheckInventoryWS")
// @SOAPBinding(style = SOAPBinding.Style.RPC)
public class CheckWarewhouseInventoryWS {


    @WebMethod
    public String checkInWarehouse(String message) {
        System.out.println("Web Service Parameter - message=" + message);
        
        int i = (int) ((Math.random()) % 2);
        
        if(i == 0)
        	return "Bikes Available for brand.";
        
        else
        	return "Bikes not available for brand.";
    }
    
}
