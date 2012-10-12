package edu.cmu.mse.aes.project2.supplier;

import java.util.ArrayList;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Message;

import edu.cmu.mse.project2.data.BrandRequest;
import edu.cmu.mse.project2.data.BrandRequestResponse;

/*
 * @author: Rui li
 * 
 * this is a listener which  will handle the brand request message from ESB. 
 * use the data query service, and send the brandrequestResponse back. 
 * 
 */
public class BrandRequestListenerAction extends AbstractActionLifecycle {
	private DataQueryService dqs = new DataQueryService();
	private ArrayList<String> brands = new ArrayList();

	protected ConfigTree _config;

	public BrandRequestListenerAction(ConfigTree config) {
		_config = config;
	}

	public Message returnAllBrands(Message message) throws Exception {

		// System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		// System.out.println("Body: " + message.getBody().get()) ;
		// System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		// return message;
		BrandRequestResponse brr = new BrandRequestResponse();
		if (message instanceof BrandRequest) {
			if (brands.size() == 0) {
				brands = dqs.getBrands();
			}
			brr.setBrandsArr(brands);

		}
		// TODO: not return , should send a message to ESB queue
		return brr;

	}

}
