package edu.cmu.mse.rui.J2EE.HW9.StructsAction;
/*
 * 08600 2012 Fall
 * HW9
 * 12/10/2012
 * @author: ruili@andrew.cmu.edu
 * 
 *  This homework used Both Hibernate(3.0) and Struts(2.0) Framework. 
 *  
 *
 */
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.cmu.mse.rui.J2EE.HW8.DAO.FavoriteDAO;
import edu.cmu.mse.rui.J2EE.HW8.DataBean.Favorite;

public class FavoriteMgt extends ActionSupport implements ServletRequestAware {
	private javax.servlet.http.HttpServletRequest request;

	private String favoriteListOwner;
	private String inputURL;
	private String inputcomments;
	private int favoriteID;
	private ArrayList<Favorite> allFavorite = new ArrayList<Favorite>();
	private ArrayList<Favorite> allFavoriteForOwner = new ArrayList<Favorite>();
	private ArrayList<String> error = new ArrayList<String>();
	
	public int getFavoriteID() {
		return favoriteID;
	}

	public void setFavoriteID(int favoriteID) {
		this.favoriteID = favoriteID;
	}

	public javax.servlet.http.HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(javax.servlet.http.HttpServletRequest request) {
		this.request = request;
	}

	public String getFavoriteListOwner() {
		return favoriteListOwner;
	}

	public void setFavoriteListOwner(String favoriteListOwner) {
		this.favoriteListOwner = favoriteListOwner;
	}


	public String getInputURL() {
		return inputURL;
	}

	public void setInputURL(String inputURL) {
		this.inputURL = inputURL;
	}

	public String getInputcomments() {
		return inputcomments;
	}

	public void setInputcomments(String inputcomments) {
		this.inputcomments = inputcomments;
	}

	public ArrayList<Favorite> getAllFavorite() {
		return allFavorite;
	}

	public void setAllFavorite(ArrayList<Favorite> allFavorite) {
		this.allFavorite = allFavorite;
	}

	public ArrayList<Favorite> getAllFavoriteForOwner() {
		return allFavoriteForOwner;
	}

	public void setAllFavoriteForOwner(ArrayList<Favorite> allFavoriteForOwner) {
		this.allFavoriteForOwner = allFavoriteForOwner;
	}

	private FavoriteDAO favoritedao=new FavoriteDAO();
	
	

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public String addOneFavorite() {
		if(getInputcomments()==null ||getInputcomments().equals("")){
			ActionContext.getContext().getSession().remove("error");
			error.add("please input comments for your url");
			ActionContext.getContext().getSession().put("error", error);
			return "Fail to add favorite";
		}
		if(getInputURL()==null ||getInputURL().equals("")){
			ActionContext.getContext().getSession().remove("error");
			error.add("please input your url");
			ActionContext.getContext().getSession().put("error", error);
			return "Fail to add favorite";
		}
		Favorite f=new  Favorite();
		f.setComment(getInputcomments());
		f.setUrl(getInputURL());
		f.setClickCounter(1);
		f.setUserId(Integer.parseInt(ActionContext.getContext().getSession().get("UserID").toString()));
		favoritedao.save(f);
		retreiveFavoriteForOwner();
		return "Add Favorite Success";
	}
	
	public String deleteOneFavoriate(){
		//@TODO check the favoriteID is not empty or null
		favoritedao.delete(getFavoriteID());
		retreiveFavoriteForOwner();
		return "delete Favorite Success";
		
	}
	
	
	public String clickOneFavorite(){
		favoritedao.increaseCounter(getFavoriteID());
		retreiveFavoriteForOwner();
		return "click Favorite Success";
	}

	public String retreiveAllFavorite() {
		allFavorite=(ArrayList<Favorite>) favoritedao.findAll();
		ActionContext.getContext().getSession().put("allFavorite", allFavorite);
		return "retreive  All Favorite  Success";
	}

	public String retreiveFavoriteForOwner() {
		int userID=Integer.parseInt(ActionContext.getContext().getSession().get("UserID").toString());
		allFavoriteForOwner=(ArrayList<Favorite>) favoritedao.findByUserId(userID);
		ActionContext.getContext().getSession().put("allFavoriteForOwner", allFavoriteForOwner);
		return "retreive  All Favorite  Success for current user";

	}

}
