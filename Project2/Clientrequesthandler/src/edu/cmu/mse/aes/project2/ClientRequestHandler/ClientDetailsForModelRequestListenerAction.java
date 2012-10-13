package edu.cmu.mse.aes.project2.ClientRequestHandler;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.actions.annotation.Process;
import org.jboss.soa.esb.message.Message;

import edu.cmu.mse.project2.data.ClientGetListOfModelsPerBrandRequest;
import edu.cmu.mse.project2.data.ClientGetListOfModelsPerBrandResponse;
import edu.cmu.mse.project2.data.ClientReadDetailsOfAModelRequest;
import edu.cmu.mse.project2.data.ClientReadDetailsOfAModelResponse;

public class ClientDetailsForModelRequestListenerAction extends
		AbstractActionLifecycle {
	
	public ClientDetailsForModelRequestListenerAction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	@Process
	public Message getListOfModels(Message message) {
		ClientReadDetailsOfAModelResponse detailsOfModelsReponse = null;
		if(message instanceof ClientReadDetailsOfAModelRequest)
		{
			//TODO : Will create a message of instance ModelInfoRequest(by Rui), process it, and return response to the client.
			//TODO : Process response from ModelInfoRequestResponse.
			//
			detailsOfModelsReponse = new ClientReadDetailsOfAModelResponse();
		}
		//TODO : Not return, but push to the queue.
		return detailsOfModelsReponse;
	}

}
