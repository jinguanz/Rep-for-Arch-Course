package edu.cmu.mse.rui.J2EE.HW8.DataBean;

// default package

/**
 * Favorite entity. @author MyEclipse Persistence Tools
 */

public class Favorite implements java.io.Serializable, Comparable {

	// Fields

	private Integer favoriteId;
	private Integer userId;
	private String url;
	private Integer clickCounter;
	private String comment;

	// Constructors

	/** default constructor */
	public Favorite() {
	}

	/** full constructor */
	public Favorite(Integer userId, String url, Integer clickCounter,
			String comment) {
		this.userId = userId;
		this.url = url;
		this.clickCounter = clickCounter;
		this.comment = comment;
	}

	// Property accessors

	public Integer getFavoriteId() {
		return this.favoriteId;
	}

	public void setFavoriteId(Integer favoriteId) {
		this.favoriteId = favoriteId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getClickCounter() {
		return this.clickCounter;
	}

	public void setClickCounter(Integer clickCounter) {
		this.clickCounter = clickCounter;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Favorite o1 = (Favorite) o;
		if (this.clickCounter > o1.clickCounter)
			return 1;
		else if (this.clickCounter > o1.clickCounter)
			return -1;
		else
			return 0;
	}

}