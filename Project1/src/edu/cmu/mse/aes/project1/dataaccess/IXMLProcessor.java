package edu.cmu.mse.aes.project1.dataaccess;

import java.util.ArrayList;

import edu.cmu.mse.aes.project1.data.Bike;

/*
 * @author: Rui Li
 */
public interface IXMLProcessor {
	
	//receive the arrayList from the dataFilter, and save such thing into XML
	public boolean saveIntoXML(ArrayList<Bike> bikes);

}
