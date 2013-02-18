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
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.cmu.mse.rui.J2EE.HW8.DAO.FavoriteDAO;

public class FavoriteClick extends ActionSupport implements ServletRequestAware {
	private javax.servlet.http.HttpServletRequest request;

	private int favoriteID;

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

	private FavoriteDAO favoritedao = new FavoriteDAO();

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public String clickOneFavorite() {

		System.out.println(getFavoriteID());
		favoritedao.increaseCounter(getFavoriteID());
		FavoriteMgt mgt = new FavoriteMgt();
		mgt.retreiveAllFavorite();
		return "click success in view all";
	}

}
