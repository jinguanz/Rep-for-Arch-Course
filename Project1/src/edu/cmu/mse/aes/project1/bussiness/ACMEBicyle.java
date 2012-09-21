package edu.cmu.mse.aes.project1.bussiness;

/*
 * author: Rui Li
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import edu.cmu.mse.aes.project1.data.Bike;
import edu.cmu.mse.aes.project1.dataaccess.XMLProcessor;

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
		int count=0;
		for (String eachBrand : brandToURLMap.keySet()) {
			++count;
			HashMap<String, String> currentBrand2010linkMap = new HashMap<String, String>();
			if(eachBrand.contains("raleigh")||eachBrand.contains("specialized")||eachBrand.contains("cannondale")||eachBrand.contains("gary-fisher")){
				currentBrand2010linkMap = dataFileter
						.filterDataForInternalUse(
								dataFetcher.doPost(url + eachBrand),
								RegualExpression.regx2ForDumppages);
				
			}
			else currentBrand2010linkMap = dataFileter
					.filterDataForInternalUse(
							dataFetcher.doPost(url + eachBrand),
							RegualExpression.regx2);
			
			ArrayList<Bike> bikesforoneBrand = new ArrayList<Bike>();

			for (String currentBrand2010link : currentBrand2010linkMap.keySet()) {

				HashMap<String, String> currentBrand2010withModellinkMap = new HashMap<String, String>();
				currentBrand2010withModellinkMap = dataFileter
						.filterDataForInternalUse(
								dataFetcher.doPost(url + currentBrand2010link),
								RegualExpression.regx3);
				///System.out.println("currentBrandin2010" + currentBrand2010link);

				for (String currentBrand2012withSpecificModel : currentBrand2010withModellinkMap
						.keySet()) {
					//System.out.println("currentBrand 2011 with SpecificModel"
					//		+ currentBrand2012withSpecificModel);

					String certainModelPageSource = dataFetcher
							.doPost(url+currentBrand2012withSpecificModel);
					Bike b = new Bike();
					b.setBrand(eachBrand);
					b.setComponentinfo(dataFileter
							.filterData(certainModelPageSource,
									RegualExpression.regxForComponent));
					b.setRating(dataFileter
							.filterData(certainModelPageSource,
									RegualExpression.regxForrating));
					b.setForkmaterial(dataFileter
							.filterData(certainModelPageSource,
									RegualExpression.regxForFrameMaterial));
					b.setFramesize(dataFileter
							.filterData(certainModelPageSource,
									RegualExpression.regxForFrameSize));
					b.setModel(dataFileter
							.filterData(certainModelPageSource,
									RegualExpression.regxForModel));
					b.setPrice(dataFileter
							.filterData(certainModelPageSource,
									RegualExpression.regxForPrice));
					bikesforoneBrand.add(b);
				}

			}
			// when all the models of such brand been retrieved, call xml
			// processor to save one xml file
			// TBD
			System.out.println("for this brand, we have"+ bikesforoneBrand.size()+" bikes:"+eachBrand+"no "+count);
			 XMLProcessor xmlprocessor= new XMLProcessor();
			 xmlprocessor.saveIntoXML(bikesforoneBrand);
		}

	}

}
