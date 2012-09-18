package edu.cmu.mse.aes.project1.bussiness;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ACMEBicyle {

	/**
	 * @param args
	 */

	private final String url = "http://bikereviews.com/road-bikes/";
	private static HashMap<String,String> brandToURLMap=new HashMap<String,String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ACMEBicyle acmeBicyle = new ACMEBicyle();
	}

	ACMEBicyle() {
		init();
	}

	void init() {
		DataFetcher dataFetcher=new DataFetcher();
		DataFilter dataFileter=new DataFilter();
		String rawData=dataFetcher.doPost(url);
		brandToURLMap=dataFileter.filterDataForInternalUse(rawData,RegualExpression.RegxForFilterLinks);
	}

}
