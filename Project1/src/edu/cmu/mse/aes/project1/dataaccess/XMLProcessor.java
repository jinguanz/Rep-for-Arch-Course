package edu.cmu.mse.aes.project1.dataaccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import edu.cmu.mse.aes.project1.data.Bike;
import edu.cmu.mse.aes.project1.data.Bikelist;

public class XMLProcessor implements IXMLProcessor
{
	public static final String BIKE_XML="data/integratedXMLFile.xml";
	public boolean saveIntoXML(ArrayList<Bike> bikes)
	{
		JAXBContext jaxbContext = null;
		Marshaller marshaller = null;
		FileOutputStream fos = null;
		
		Bikelist bikeList = new Bikelist();
		List<Bike> bikeL= bikeList.getBike();
		
		for(Bike bike:bikes)
		{
			bikeL.add(bike);
		}
		 
		try 
		{
			jaxbContext = JAXBContext.newInstance("edu.cmu.mse.aes.project1.data");
			marshaller=jaxbContext.createMarshaller();
			fos = new FileOutputStream("data"+File.separator+bikeList.getBike().get(0).getBrand()+".xml");
			
			marshaller.marshal(bikeList, fos);
		}
		catch (IOException | JAXBException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				fos.close();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return true;
	}
	/**
	 * Convert xml to object
	 * @return
	 */
	
	public List<Bike> xmltoObject(){
		JAXBContext context;
		Bikelist bikeList = null;
		Unmarshaller um;
		try {
			 context = JAXBContext.newInstance(Bikelist.class);
			 um = context.createUnmarshaller();
			 bikeList = (Bikelist) um.unmarshal(new FileReader(BIKE_XML));
		} catch (JAXBException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bikeList.getBike();
		
	}
	public static void main(String args[]){
		//Test the array
		XMLProcessor processor = new XMLProcessor();
		List<Bike> bikeList =processor.xmltoObject();
		System.out.println("size: " + bikeList.size());
		for(int i=0;i<bikeList.size();i++){
			System.out.println(bikeList.get(i).getBrand() + " " + bikeList.get(i).getForkmaterial() + " " +bikeList.get(i).getFramematerial() +" "
					+bikeList.get(i).getFramesize() +" " + bikeList.get(i).getModel() + " " +bikeList.get(i).getPrice() + " " +bikeList.get(i).getRating());
		}
		
	}
}