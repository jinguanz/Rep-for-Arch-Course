package edu.cmu.mse.aes.project1.bussiness;

/*
 * author: Rui Li
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import edu.cmu.mse.aes.project1.data.Bike;
import edu.cmu.mse.aes.project1.data.Componentinfo;
import edu.cmu.mse.aes.project1.dataaccess.XMLIntegrator;
import edu.cmu.mse.aes.project1.dataaccess.XMLProcessor;

public class ACMEBicyle {



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
		DataFilter dataFilter = new DataFilter();
		String rawData = dataFetcher.doPost(url);
		brandToURLMap = dataFilter.filterDataForInternalUse(rawData,
				RegualExpression.RegxForFilterLinks);
		int count=0;
		for (String eachBrand : brandToURLMap.keySet()) {
			++count;
			HashMap<String, String> currentBrand2010linkMap = new HashMap<String, String>();
			if(eachBrand.contains("raleigh")||eachBrand.contains("giant")||eachBrand.contains("felt")||eachBrand.contains("specialized")||eachBrand.contains("cannondale")||eachBrand.contains("gary-fisher")){
				currentBrand2010linkMap = dataFilter
						.filterDataForInternalUse(
								dataFetcher.doPost(url + eachBrand),
								RegualExpression.regx2ForDumppages);
				
			}
			else currentBrand2010linkMap = dataFilter
					.filterDataForInternalUse(
							dataFetcher.doPost(url + eachBrand),
							RegualExpression.regx2);
			
			ArrayList<Bike> bikesforoneBrand = new ArrayList<Bike>();

			for (String currentBrand2010link : currentBrand2010linkMap.keySet()) {

				HashMap<String, String> currentBrand2010withModellinkMap = new HashMap<String, String>();
				currentBrand2010withModellinkMap = dataFilter
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

					Componentinfo c=new Componentinfo();
				c.setBrakeset(dataFilter.extract(certainModelPageSource, RegualExpression.regxForBrakes));
				c.setHandlebars(dataFilter.extract(certainModelPageSource, RegualExpression.regxForHanlebar));
				c.setHeadset(dataFilter.extract(certainModelPageSource, RegualExpression.regxForHeadSet));
				c.setSaddle(dataFilter.extract(certainModelPageSource, RegualExpression.regxForSaddle));
				c.setSeatpost(dataFilter.extract(certainModelPageSource, RegualExpression.regxForSeatPost));
				c.setStem(dataFilter.extract(certainModelPageSource, RegualExpression.regxForStem));
			
				//b.setComponentinfo(c);
					b.setRating(dataFilter
							.extract(dataFilter
							.filterData(certainModelPageSource,
									RegualExpression.regxForrating),RegualExpression.regxCleanRating)+" out of 5");
					b.setForkmaterial(dataFilter
							.filterData(certainModelPageSource,
									RegualExpression.regxForFrameMaterial));
					b.setFramesize(dataFilter
							.extract(certainModelPageSource,
									RegualExpression.regxForFrameSize));
					b.setModel(dataFilter
							.extract(dataFilter
							.filterData(certainModelPageSource,
									RegualExpression.regxForModel),RegualExpression.regxCleanModel));
					b.setPrice(dataFilter
							.filterData(certainModelPageSource,
									RegualExpression.regxForPrice));
					b.setForkmaterial(dataFilter
							.extract(certainModelPageSource,RegualExpression.regxForFork));
					b.printinfo();
					bikesforoneBrand.add(b);
				}

			}
			// when all the models of such brand been retrieved, call xml
			// processor to save one xml file
			
			System.out.println("for this brand, we have "+ bikesforoneBrand.size()+" bikes:"+eachBrand+"no "+count);
			 XMLProcessor xmlprocessor= new XMLProcessor();
			 xmlprocessor.saveIntoXML(bikesforoneBrand);
			 
			 //when all the small xml created for all the brands, integrate the xml into a big one.
//			 XMLIntegrator xmlIntegrator=new XMLIntegrator();
//			xmlIntegrator.integrateXMLs("hello");
		}

	}

}
