package edu.cmu.mse.aes.project1.bussiness;

import java.util.ArrayList;

import edu.cmu.mse.aes.project1.data.Bike;

public interface IDataFilter {
	
	public ArrayList<Bike> FilterData(String rawData); 

}
