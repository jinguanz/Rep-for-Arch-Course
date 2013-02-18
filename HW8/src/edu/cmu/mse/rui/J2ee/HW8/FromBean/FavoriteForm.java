package edu.cmu.mse.rui.J2ee.HW8.FromBean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class FavoriteForm {
	private String URL;
	private String comments;
	private String favoriteID;
	
	public FavoriteForm(HttpServletRequest request) {
		URL = request.getParameter("URL");
		comments=request.getParameter("comments");
		favoriteID=request.getParameter("id");
	}
	
	

	public String getFavoriteID() {
		return this.favoriteID;
	}



	public void setFavoriteID(String favoriteID) {
		this.favoriteID = favoriteID;
	}



	public String getURL() {
		return URL;
	}



	public void setURL(String uRL) {
		URL = uRL;
	}



	public String getComments() {
		return comments;
	}



	public void setComments(String comments) {
		this.comments = comments;
	}



	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (URL == null || URL.length() == 0) {
			errors.add("URL is required");
		}

        //if (URL.matches(".*[<>\"].*")) errors.add("Item may not contain angle brackets or quotes");

		return errors;
	}
}
