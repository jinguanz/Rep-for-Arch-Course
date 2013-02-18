package edu.cmu.mse.rui.J2ee.HW8.FromBean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class LogOutForm {
	private String userFirstName;
	private String userLastName;
	private String password;
	private String button;
	private String emailAdd;

	public LogOutForm(HttpServletRequest request) {
		userFirstName = request.getParameter("userFirstName");
		userLastName = request.getParameter("userLastName");
		password = request.getParameter("password");
		emailAdd=request.getParameter("emailAdd");
		button = request.getParameter("button");
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setButton(String button) {
		this.button = button;
	}

	public String getPassword() {
		return password;
	}

	public String getButton() {
		return button;
	}

	public boolean isPresent() {
		return button != null;
	}

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (emailAdd == null || emailAdd.length() == 0)
			errors.add("User FirstName is required");
		if (password == null || password.length() == 0)
			errors.add("Password is required");
		if (button == null)
			errors.add("Button is required");

		if (errors.size() > 0)
			return errors;

		if (!button.equals("Login") && !button.equals("Register")&& !button.equals("Complete Register"))
			errors.add("Invalid button");
		if (emailAdd.matches(".*[<>\"].*"))
			errors.add("User Name may not contain angle brackets or quotes");

		return errors;
	}
}
