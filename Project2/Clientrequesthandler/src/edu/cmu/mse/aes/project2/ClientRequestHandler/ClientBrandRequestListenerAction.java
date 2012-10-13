package edu.cmu.mse.aes.project2.ClientRequestHandler;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.actions.annotation.Process;
import org.jboss.soa.esb.message.Message;

import edu.cmu.mse.project2.data.BrandRequest;
import edu.cmu.mse.project2.data.ClientGetListOfBrandsRequest;
import edu.cmu.mse.project2.data.ClientGetListOfBrandsResponse;

public class ClientBrandRequestListenerAction extends AbstractActionLifecycle {

	public ClientBrandRequestListenerAction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	@Process
	public Message getListOfBrands(Message message) {
		ClientGetListOfBrandsResponse brandReponse = null;
		if(message instanceof ClientGetListOfBrandsRequest)
		{
			//Will create a message of instance BrandRequest(by Rui), process it, and return response to the client.
			//Process response from BrandRequestResponse.
			//
			brandReponse = new ClientGetListOfBrandsResponse();
		}
		//TODO : Not return, but push to the queue.
		return brandReponse;
	}

}
