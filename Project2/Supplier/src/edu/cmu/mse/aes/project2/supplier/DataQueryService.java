package edu.cmu.mse.aes.project2.supplier;

/*
 * author: Rui Li
 * 
 * This is  a  internal service provide for the supplier model  
 * 
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

import edu.cmu.mse.aes.project1.data.Bike;
import edu.cmu.mse.aes.project1.data.Bikelist;

public class DataQueryService implements IDataQuery {

	private final static String configFileName = "config.txt";
	// for such map the keyi is the brand and the value is a array of the brands
	private static HashMap<String, ArrayList<String>> brandModelMap = new HashMap<String, ArrayList<String>>();
	private final String sourceFileName = "integratedXMLFile.xml";

	// for such map the key is the model, and the value is the Bike
	private final HashMap<String, Bike> modelToInfoMap = new HashMap<String, Bike>();

	DataQueryService() {
		// super();
		getBrandsandModelsFromXML();
		initModelInfoFromXML();

	}

	@Override
	public ArrayList<String> getBrands() {
		ArrayList<String> brands = new ArrayList<String>();
		for (String eachBrand : brandModelMap.keySet()) {
			brands.add(eachBrand);
		}

		return brands;
	}

	@Override
	public ArrayList<String> getModels(String brand) {
		// TODO Auto-generated method stub
		if (brandModelMap.containsKey(brand))
			return brandModelMap.get(brand);
		else
			return null;
	}

	@Override
	public Bike getModelInfo(String model) {
		// TODO Auto-generated method stub
		//return null;
		if(modelToInfoMap.containsKey(model)) return modelToInfoMap.get(model);
		else return null;
		
	}

	private void getBrandsandModelsFromXML() {
		File f = new File(configFileName);
		String context;
		if (f.exists()) {
			try {
				BufferedReader input = new BufferedReader(new FileReader(f));
				context = input.readLine();
				setBrandModelMap(buildMapFromString(context));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("what the hell");
		}

	}

	private void setBrandModelMap(
			HashMap<String, ArrayList<String>> buildMapFromString) {
		// TODO Auto-generated method stub
		this.brandModelMap = buildMapFromString;

	}

	private HashMap<String, ArrayList<String>> buildMapFromString(String str) {

		HashMap<String, ArrayList<String>> tmpHashMap = new HashMap<String, ArrayList<String>>();
		// each element in this array, it's brand and models.
		String[] infos = str.split("#");
		for (int i = 1; i < infos.length; i++) {
			ArrayList<String> modelsArr = new ArrayList<String>();
			// each element in the arr, it's either brand or model
			String[] pieces = infos[i].split(",");
			for (int j = 1; j < pieces.length; j++) {
				modelsArr.add(pieces[j]);
			}
			tmpHashMap.put(pieces[0], modelsArr);

		}

		return tmpHashMap;

	}

	private void initModelInfoFromXML() {
		JAXBContext context;
		Bikelist bikeList = null;
		Unmarshaller um;
		try {
			context = JAXBContext.newInstance(Bikelist.class);
			um = context.createUnmarshaller();
			bikeList = (Bikelist) um.unmarshal(new FileReader(sourceFileName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Bike eachBike : bikeList.getBike()) {
			modelToInfoMap.put(eachBike.getModel(), eachBike);
		}

	}

	// read all the bikes from the xml file first and then search in the Map
	private Bike viewCertainModel(String model) {
		if (modelToInfoMap.containsKey(model))
			return modelToInfoMap.get(model);
		else
			return null;

	}

	public static void main(String args[]) {
		DataQueryService dqs = new DataQueryService();
		ArrayList<String> brands = dqs.getBrands();
		for (String eachBrand : brands) {
			System.out.print(eachBrand + "");
		}
		System.out.println();
		ArrayList<String> models=dqs.getModels(brands.get(4));
		for (String eachmodel : models) {
			System.out.println(eachmodel + "");
		}
		
		Bike b=dqs.getModelInfo(models.get(1));
		System.out.println(b.getBrand()+","+b.getForkmaterial()+""+b.getModel());

	}
}
