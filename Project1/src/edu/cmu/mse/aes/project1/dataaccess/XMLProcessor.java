package edu.cmu.mse.aes.project1.dataaccess;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import edu.cmu.mse.aes.project1.data.Bike;
import edu.cmu.mse.aes.project1.data.Bikelist;

public class XMLProcessor implements IXMLProcessor
{
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
			fos = new FileOutputStream("/Project1/data/"+bikeList.getBike().get(0).getBrand()+".xml");
			
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
}