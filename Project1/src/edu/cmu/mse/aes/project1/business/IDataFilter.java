package edu.cmu.mse.aes.project1.business;

import java.util.ArrayList;
import java.util.HashMap;

import edu.cmu.mse.aes.project1.data.Bike;

/*
 * author： Rui LI
 */
public interface IDataFilter {
	
	//this function will be used by xml processor
	public ArrayList<Bike> filterData(String rawData,String regx); 
	
	//this function will be used by DataFilter to keep filter data with can be used as the middle result
	public HashMap<String,String>  filterDataForInternalUse(String rawData,String regx); 

}
