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
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.cmu.mse.rui.J2EE.HW8.DAO.UserDAO;
import edu.cmu.mse.rui.J2EE.HW8.DataBean.Favorite;
import edu.cmu.mse.rui.J2EE.HW8.DataBean.User;

public class Login extends ActionSupport implements ServletRequestAware {

	private UserDAO userdao = new UserDAO();

	private String emailAddress;
	private String password;
	private String firstName;
	private String lastName;
	private String retypedPassword;

	private ArrayList<String> error = new ArrayList<String>();

	public String getRetypedPassword() {
		return retypedPassword;
	}

	public void setRetypedPassword(String retypedPassword) {
		this.retypedPassword = retypedPassword;
	}

	private javax.servlet.http.HttpServletRequest request;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String login() throws Exception {
		if (getEmailAddress() == null || getPassword() == null) {

			ActionContext.getContext().getSession().remove("error");
			error.add("please input user name or password");
			ActionContext.getContext().getSession().put("error", error);
			return "login failure";
		} else {
			if (userdao.findByEmailAdd(getEmailAddress()) == null) {
				ActionContext.getContext().getSession().remove("error");
				error.add("user does not exist");
				ActionContext.getContext().getSession().put("error", error);
				return "login failure";
			} else {
				User user = (User) userdao.findByEmailAdd(getEmailAddress());
				if (user.getPassword().equals(getPassword())) {

					ActionContext.getContext().getSession()
							.put("LastName", user.getLastName());
					ActionContext.getContext().getSession()
							.put("FirstName", user.getFirstName());
					ActionContext.getContext().getSession()
							.put("UserID", user.getUserId());
					FavoriteMgt mgt = new FavoriteMgt();
					mgt.retreiveFavoriteForOwner();
		
					// mgt.retreiveAllFavorite();
					return "login success";
				} else {
					ActionContext.getContext().getSession().remove("error");
					error.add("email and password does not match");
					ActionContext.getContext().getSession().put("error", error);
					return "login failure";

				}
			}
		}

	}

	public String logout() {
		ActionContext.getContext().getSession().clear();
		return "logoutSuccess";
	}

	public String register() {
		if (getEmailAddress() == null || getPassword() == null) {

			ActionContext.getContext().getSession().remove("error");
			error.add("please input user name or password");
			ActionContext.getContext().getSession().put("error", error);
			return "login failure";
		} else if (userdao.findByEmailAdd(getEmailAddress()) != null) {
			ActionContext.getContext().getSession().remove("error");
			error.add("email address already exist in the system");
			ActionContext.getContext().getSession().put("error", error);
			return "login failure";
		}
		ActionContext.getContext().getSession()
				.put("emailAddress", getEmailAddress());
		ActionContext.getContext().getSession().put("password", getPassword());
		return "ToRegister";

	}

	public String completeRegister() {
		User user = new User();
		user.setEmailAdd(ActionContext.getContext().getSession()
				.get("emailAddress").toString());
		user.setFirstName(getFirstName());
		user.setLastName(getLastName());
		System.out.println(ActionContext.getContext().getSession()
				.get("password"));
		System.out.println(getRetypedPassword());
		if (ActionContext.getContext().getSession().get("password")
				.equals(getRetypedPassword())) {
			user.setPassword(getRetypedPassword());
			userdao.save(user);
			ActionContext.getContext().getSession()
					.put("LastName", user.getLastName());
			ActionContext.getContext().getSession()
					.put("FirstName", user.getFirstName());
			int userid;
			user = (User) userdao.findByEmailAdd(user.getEmailAdd());
			userid = user.getUserId();
			ActionContext.getContext().getSession().put("UserID", userid);
			FavoriteMgt mgt = new FavoriteMgt();
			mgt.retreiveFavoriteForOwner();

			return "complateRegister";
		} else {
			ActionContext.getContext().getSession().remove("error");
			error.add("password is not the same as login page");
			ActionContext.getContext().getSession().put("error", error);
			return "fail to register";
		}
	}

	public String changePassword() {

		User user = userdao.findById(Integer.valueOf(ActionContext.getContext()
				.getSession().get("UserID").toString()));

		if (user.getPassword().equals(getPassword())) {
			userdao.changePassword(getRetypedPassword(), user.getUserId());
			return "change password success";
		} else {
			ActionContext.getContext().getSession().remove("error");
			error.add("the original password does not match");
			ActionContext.getContext().getSession().put("error", error);
			return "change password fail";
		}

	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

}
