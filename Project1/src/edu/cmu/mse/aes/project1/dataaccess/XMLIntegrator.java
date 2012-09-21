package edu.cmu.mse.aes.project1.dataaccess;
import edu.cmu.mse.aes.project1.data.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XMLIntegrator implements IXMLIntegrator
{
	public final File pathToXMLFiles = new File("/Project1/data");
	public final File pathToIntegratedXML = new File("/Project1/data/IntegratedXML.xml");
	@Override
	public void integrateXMLs(String xmlFileName) 
	{
		List<Bikelist> listOfBikeList = new ArrayList<Bikelist>();
		
		try
		{
				for (final File fileEntry : pathToXMLFiles.listFiles())
				{
				    
				    	JAXBContext context = JAXBContext.newInstance("edu.cmu.mse.aes.project1.data");
				    	Bikelist b = (Bikelist) context.createUnmarshaller().unmarshal(fileEntry);
				    
				    	listOfBikeList.add(b);
				    	
				}
				
				List<Bike> finalBikeList = new Bikelist().getBike();
				
				//Merging bikelists from all the XML files
				for(Bikelist bikelist:listOfBikeList)
				{
					for(Bike bike:bikelist.getBike())
					{
						finalBikeList.add(bike);
					}
				}
				//have to merge this list with list from the Integrated XML file.
				JAXBContext context = JAXBContext.newInstance("edu.cmu.mse.aes.project1.data");
		    	Bikelist bikeListFromIntegratedXMLFile = (Bikelist) context.createUnmarshaller().unmarshal(pathToIntegratedXML);
		    	
		    	for(Bike bike:bikeListFromIntegratedXMLFile.getBike())
		    	{
		    		finalBikeList.add(bike);
		    	}
		    	
		    	FileOutputStream fos = null;
				try 
				{
					JAXBContext jaxbContext = JAXBContext.newInstance("edu.cmu.mse.aes.project1.data");
					Marshaller marshaller = jaxbContext.createMarshaller();
					fos = new FileOutputStream(pathToIntegratedXML);
				//	System.out.println("Test");
					
					marshaller.marshal(finalBikeList, fos);
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
		    
				
				
		} 
		catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
