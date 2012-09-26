package edu.cmu.mse.aes.project1.bussiness;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ACMETransform implements IQueryService{

	private final String xslFileName = "data/ACMEBikeList.xsl";
	private final String sourceFileName = "data/integratedXMLFile.xml";
	private final String HtmlFile = "data/source.htm";
	private static HashMap<String, ArrayList<String>> brandModelMap = new HashMap<String, ArrayList<String>>();

	ACMETransform(){
		super();
	}
	
	ACMETransform(HashMap map) {
		super();
		this.brandModelMap = map;
	}

	public void supportBrands() {
		
		for(String brand:brandModelMap.keySet()){
			System.out.println(brand);
			
		}
	}

	
	public void supportedModels(String brand) {
		ArrayList<String> models=brandModelMap.get(brand);
		int i=1;
		for(String model:models){
			System.out.println(i+"."+model);
			i++;
		}
	}

	
	public void viewCertainModel(String model) {

		File f = new File(HtmlFile);
		File sourceFile = new File(sourceFileName);
		File xslFile = new File(xslFileName);
		// BufferedWriter bw = new BufferedWriter(new FileWriter(f));

		Source xmlSource = new StreamSource(sourceFile);
		Source xsltSource = new StreamSource(xslFile);

		TransformerFactory transFact = TransformerFactory.newInstance();
		Transformer trans;
		try {
			trans = transFact.newTransformer(xsltSource);

			trans.setParameter("modelname", model.toString());

			trans.transform(xmlSource,
					new StreamResult(new FileOutputStream(f)));
			// trans.transform(xmlSource, new StreamResult(bw));
			// String url = "http://www.google.com";
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(HtmlFile));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Processing done!!");

	}

//	public static void main(String[] args) throws Exception {
//		if (args.length != 3) {
//			System.err.println("Usage: java Transform [xmlfile] [xsltfile]");
//			System.exit(1);
//		}
//
//		String brand = "";
//		String model = "";
//
//		final String HtmlFile = "data/source.htm";
//		final String transformedHTML = "data/source.htm";
//		// System.out.println("Enter a brand: ");
//		// Scanner scan = new Scanner(System.in);
//		// brand = scan.next();
//		// System.out.println("You entered the following brand: "+brand);
//
//		// System.out.println("Enter a model: ");
//		// model = scan.next();
//		model = args[2];
//		// System.out.println("You entered the following model: "+model);
//		// scan.close();
//
//		File xmlFile = new File(args[0]);
//		File xsltFile = new File(args[1]);
//
//		File f = new File(HtmlFile);
//		// BufferedWriter bw = new BufferedWriter(new FileWriter(f));
//
//		Source xmlSource = new StreamSource(xmlFile);
//		Source xsltSource = new StreamSource(xsltFile);
//
//		TransformerFactory transFact = TransformerFactory.newInstance();
//		Transformer trans = transFact.newTransformer(xsltSource);
//		trans.setParameter("modelname", model.toString());
//
//		trans.transform(xmlSource, new StreamResult(new FileOutputStream(f)));
//		// trans.transform(xmlSource, new StreamResult(bw));
//		// String url = "http://www.google.com";
//		java.awt.Desktop.getDesktop().browse(
//				java.net.URI.create(transformedHTML));
//
//		System.out.println("Processing done!!");
//	}
}