package edu.cmu.mse.aes.project1.dataaccess;

import java.util.ArrayList;

import edu.cmu.mse.aes.project1.data.Bike;

public interface IXMLProcessor {
	
	public boolean saveIntoXML(ArrayList<Bike> bikes);

}
