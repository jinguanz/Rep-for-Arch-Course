package com.enernoc.openadr.testutil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.enernoc.openadr.core.connector.framework.IMQProducerClient;
import com.enernoc.openadr.core.connector.rabbitmq.RabbitMQClientFactory;
import com.enernoc.openadr.core.message.ADRMessage;
import com.enernoc.openadr.datamodel.EiCreatedEvent;
import com.enernoc.openadr.datamodel.EiResponse;
import com.enernoc.openadr.datamodel.OadrCreatedEvent;

public class MessagePub {

	private final static String RabbitConfig = "Rabbitmq.xml";
	private final static String producerBeanName = "rabbitProducerConfig";
	private String dbURL;
	private static final String defaultDBURL="";
	//private static ArrayList<String> requestIDs;
	private static HashMap<String, ArrayList<String>> requestIDToPartyIDsMap = new HashMap<String, ArrayList<String>>();

	
	public String getDbURL() {
		return dbURL;
	}

	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}

	static void main(String[] args) {
		
		MessagePub msgPub = new MessagePub();
		if(args.length>1){
			msgPub.setDbURL(args[0]);
		}
		else {
			msgPub.setDbURL(defaultDBURL);
		}
		msgPub.querypartyIDs();
		RabbitMQClientFactory rabbitMQClientFactory = new RabbitMQClientFactory(
				RabbitConfig);
		IMQProducerClient producer = null;
		try {
			producer = rabbitMQClientFactory.newProducer(producerBeanName);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String requestid : requestIDToPartyIDsMap.keySet()) {
			for (String venid : requestIDToPartyIDsMap.get(requestid)) {
				try {
					producer.pushMessage(msgPub.makeData(requestid, venid));
				} catch (Exception e) {

				}
			}

		}
	}

	private void querypartyIDs() {
		String sql = "select REQUESTID,PARTYID from REQUEST";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection conn = java.sql.DriverManager.getConnection(
					dbURL, "argo", "argo");

			java.sql.Statement stmt = conn.createStatement();

			java.sql.ResultSet rs = stmt.executeQuery(sql);

			// 5. 显示结果集里面的数据
			while (rs.next()) {
				System.out.println(rs.getString(1));
				//requestIDs.add(rs.getString(1));
				if (requestIDToPartyIDsMap.keySet().contains(rs.getString(1))) {
					ArrayList<String> tmparr = new ArrayList<String>();
					tmparr.add(rs.getString(2));
				} else {
					requestIDToPartyIDsMap.get(rs.getString(1)).add(
							rs.getString(2));
				}

			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// assume the second persitence need requestid and venid(partyid??) to
	// update reponse table
	private  ADRMessage makeData(String requestID, String venId) {
		ADRMessage message = new ADRMessage();
		EiResponse eiResponse = new EiResponse();
		eiResponse.setResponseDescription("Response From VEN");
		EiCreatedEvent eiCreatedEvent = new EiCreatedEvent();
		eiCreatedEvent.setEiResponse(eiResponse);

		eiCreatedEvent.setVenID(venId);
		OadrCreatedEvent createdEvent = new OadrCreatedEvent(eiCreatedEvent);
		createdEvent.getEiCreatedEvent().getEiResponse()
				.setRequestID(requestID);
		message.setPayload(createdEvent);

		return message;
	}

}
