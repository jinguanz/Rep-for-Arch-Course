package edu.cmu.mse.aes.project1.bussiness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import edu.cmu.mse.aes.project1.data.Bike;
import edu.cmu.mse.aes.project1.dataaccess.IXMLProcessor;

public class ACMEBicyle {

	/**
	 * @param args
	 */

	private final String url = "http://bikereviews.com/road-bikes/";
	private static HashMap<String, String> brandToURLMap = new HashMap<String, String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ACMEBicyle acmeBicyle = new ACMEBicyle();
	}

	ACMEBicyle() {
		init();
	}

	void init() {
		DataFetcher dataFetcher = new DataFetcher();
		DataFilter dataFileter = new DataFilter();
		String rawData = dataFetcher.doPost(url);
		brandToURLMap = dataFileter.filterDataForInternalUse(rawData,
				RegualExpression.RegxForFilterLinks);
		// Iterator<String> allbrandsIterator=brandToURLMap.keySet().iterator();
		for (String eachBrand : brandToURLMap.keySet()) {
			HashMap<String, String> currentBrand2010linkMap = new HashMap<String, String>();

			currentBrand2010linkMap = dataFileter
					.filterDataForInternalUse(
							dataFetcher.doPost(url + eachBrand),
							RegualExpression.regx2);
			ArrayList<Bike> bikesforoneBrand=new ArrayList<Bike>();
			
			for (String currentBrand2010link : currentBrand2010linkMap.keySet()) {
				
				HashMap<String, String> currentBrand2010withModellinkMap = new HashMap<String, String>();
				currentBrand2010withModellinkMap = dataFileter
						.filterDataForInternalUse(
								dataFetcher.doPost(url + currentBrand2010link),
								RegualExpression.regx3);
				for (String currentBrand2012withSpecificModel : currentBrand2010withModellinkMap
						.keySet()) {
					String certainModelPageSource = dataFetcher
							.doPost(currentBrand2012withSpecificModel);
					Bike b = new Bike();
					b.setComponentInfo(dataFileter
							.filterDataForInternalUse(certainModelPageSource,
									RegualExpression.regxForComponent).keySet()
							.iterator().next());
					b.setConsumerRating(dataFileter
							.filterDataForInternalUse(certainModelPageSource,
									RegualExpression.regxForrating).keySet()
							.iterator().next());
					b.setForkMaterial(dataFileter
							.filterDataForInternalUse(certainModelPageSource,
									RegualExpression.regxForFrameMaterial)
							.keySet().iterator().next());
					b.setFrameSize(dataFileter
							.filterDataForInternalUse(certainModelPageSource,
									RegualExpression.regxForFrameSize).keySet()
							.iterator().next());
					b.setModel(dataFileter
							.filterDataForInternalUse(certainModelPageSource,
									RegualExpression.regxForModel).keySet()
							.iterator().next());
					b.setPrice(dataFileter
							.filterDataForInternalUse(certainModelPageSource,
									RegualExpression.regxForPrice).keySet()
							.iterator().next());
					bikesforoneBrand.add(b);
				}

			}
			//when all the models of such brand been retrieved, call xml processor to save one xml file
			//TBD
			IXMLProcessor xmlprocessor=null;
			xmlprocessor.saveIntoXML(bikesforoneBrand);
		}

	}

}
