package edu.cmu.mse.aes.project2.ClientRequestHandler;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.actions.annotation.Process;
import org.jboss.soa.esb.message.Message;

import edu.cmu.mse.project2.data.ClientPurchaseModelRequest;
import edu.cmu.mse.project2.data.ClientPurchaseModelResponse;
import edu.cmu.mse.project2.data.ModelRequest;
import edu.cmu.mse.project2.data.ClientGetListOfModelsPerBrandRequest;
import edu.cmu.mse.project2.data.ClientGetListOfModelsPerBrandResponse;

public class ClientListOfModelsPerBrandRequestListenerAction extends
		AbstractActionLifecycle {
	
	public ClientListOfModelsPerBrandRequestListenerAction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	@Process
	public Message purchaseModels(Message message) {
		ClientPurchaseModelResponse purchaseModelsReponse = null;
		if(message instanceof ClientPurchaseModelRequest)
		{
			//TODO : Purchase model.
			//TODO : Process response from ModelRequestResponse.
			//
			purchaseModelsReponse = new ClientPurchaseModelResponse();
		}
		//TODO : Not return, but push to the queue.
		return purchaseModelsReponse;
	}

}
