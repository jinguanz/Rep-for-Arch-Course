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

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;


import edu.cmu.mse.aes.project1.data.Bike;

public class DataQueryService implements IDataQuery {

	private final static String configFileName = "data/config.txt";
	private static final java.lang.String HtmlFile = null;
	private static HashMap<String, ArrayList<String>> brandModelMap = new HashMap<String, ArrayList<String>>();
	private final String sourceFileName = "data/integratedXMLFile.xml";
	private final  HashMap<String,Bike> modelToInfoMap=new HashMap<String,Bike>();

	@Override
	public ArrayList<String> getBrands() {

		return null;
	}

	@Override
	public ArrayList<String> getModels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bike getModelInfo(String model) {
		// TODO Auto-generated method stub
		return null;
	}

	private void bulidMap() {
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

//need implementation 
	private void viewCertainModel(String model) {
//
//		File f = new File(HtmlFile);
//		File sourceFile = new File(sourceFileName);
//		String xslFileName = null;
//		File xslFile = new File(xslFileName);
//		// BufferedWriter bw = new BufferedWriter(new FileWriter(f));
//
//		Source xmlSource = new StreamSource(sourceFile);
//		Source xsltSource = new StreamSource(xslFile);
//
//		TransformerFactory transFact = TransformerFactory.newInstance();
//		Transformer trans;
//		try {
//			trans = transFact.newTransformer(xsltSource);
//
//			trans.setParameter("modelname", model.toString());
//
//			trans.transform(xmlSource,
//					new StreamResult(new FileOutputStream(f)));
//			// trans.transform(xmlSource, new StreamResult(bw));
//			// String url = "http://www.google.com";
//			java.awt.Desktop.getDesktop().browse(java.net.URI.create(HtmlFile));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Processing done!!");
//
	}
}
