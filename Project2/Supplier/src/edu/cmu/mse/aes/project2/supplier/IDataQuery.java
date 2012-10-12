package edu.cmu.mse.aes.project2.supplier;

import java.util.ArrayList;

import edu.cmu.mse.aes.project1.data.Bike;

/*
 * author: Rui Li
 * 
 * provide the brands and models,models detail  information 
 */

public interface IDataQuery {
	
	public ArrayList<String> getBrands();
	public ArrayList<String> getModels();
	public Bike getModelInfo(String model);

}
