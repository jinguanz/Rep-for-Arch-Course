package edu.cmu.mse.aes.project1.bussiness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.cmu.mse.aes.project1.data.Bike;

public class DataFilter implements IDataFilter {

	@Override
	public String filterData(String rawData, String regx) {
		// TODO Auto-generated method stub
		String target="";
		Pattern pattern = Pattern.compile(regx);

		Matcher matcher = pattern.matcher(rawData);
		try{
		while (matcher.find()) {
			target=matcher.group();
			
		}
		return target;
		}
		catch(Exception e){
			return "";
		}
		
	}

	@Override
	public HashMap<String, String> filterDataForInternalUse(String rawData,
			String regx) {
		// TODO Auto-generated method stub
		HashMap<String, String> repo = new HashMap<String, String>();
		Pattern pattern = Pattern.compile(regx);

		Matcher matcher = pattern.matcher(rawData);

		while (matcher.find()) {
			repo.put(matcher.group(1), matcher.group(1));
		}
		return repo;

	}

}
