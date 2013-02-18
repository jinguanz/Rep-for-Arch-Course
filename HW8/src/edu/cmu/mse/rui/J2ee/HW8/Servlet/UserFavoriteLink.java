package edu.cmu.mse.rui.J2ee.HW8.Servlet;
/*
 * 08600 Java and J2EE
 * 2012 Fall
 * HW8
 * @author: ruili@andrew.cmu.edu 
 *
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cmu.mse.rui.J2ee.HW8.DAO.FavoriteDAO;
import edu.cmu.mse.rui.J2ee.HW8.DAO.UserDAO;
import edu.cmu.mse.rui.J2ee.HW8.DataBean.Favorite;
import edu.cmu.mse.rui.J2ee.HW8.DataBean.User;
import edu.cmu.mse.rui.J2ee.HW8.FromBean.FavoriteForm;
import edu.cmu.mse.rui.J2ee.HW8.FromBean.LoginForm;

public class UserFavoriteLink extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private FavoriteDAO favoriteDao;
	private UserDAO userDAO;

	// init the DAO
	public void init() throws ServletException {
		favoriteDao = new FavoriteDAO();
		userDAO = new UserDAO();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			login(request, response);
		} else {
			manageFavoriteList(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> errors = new ArrayList<String>();

		LoginForm form = new LoginForm(request);

		if (!form.isPresent()) {
			outputLoginPage(response, form, null);
			return;
		}
		// System.out.println(form.getPassword());
		// System.out.println(form.getSecondPassword());

		errors.addAll(form.getValidationErrors());
		if (errors.size() != 0) {
			outputLoginPage(response, form, errors);
			return;
		}

		try {
			HttpSession session = request.getSession();
			User user = null;

			if (form.getButton().equals("Complete Register")) {

				if (!session.getAttribute("password")
						.equals(form.getPassword())) {
					throw new Exception(
							"the second password is not the same as the first one");
				}
				user = new User();
				user.setFirstName(form.getUserFirstName());
				user.setLastName(form.getUserLastName());
				user.setPassword(form.getPassword());
				user.setEmailAdd(form.getEmailAdd());
				userDAO.save(user);
			} else if (form.getButton().equals("Register")) {
				String inputEmailAddress = form.getEmailAdd();
				String inputpassword = form.getPassword();
				session.setAttribute("password", inputpassword);
				// System.out.println("outputCompleteRegisterPage with"+
				// inputEmailAddress+","+inputpassword);
				if (userDAO.findByEmailAdd(inputEmailAddress).size() > 0) {
					throw new Exception("the email address has been registered");
				} else
					outputCompleteRegisterPage(response, form, errors,
							inputEmailAddress, inputpassword);

				return;
			} else {
				if (userDAO.findByEmailAdd(form.getEmailAdd()).size() > 0) {
					user = (User) userDAO.findByEmailAdd(form.getEmailAdd())
							.get(0);
					if (user == null) {
						errors.add("No such user");
						outputLoginPage(response, form, errors);
						return;
					}

					if (!form.getPassword().equals(user.getPassword())) {
						errors.add("Incorrect password");
						outputLoginPage(response, form, errors);
						return;
					}
				}
				else{
					throw new Exception("user does not exist");
				}
			}

			session.setAttribute("user", user);
			manageFavoriteList(request, response);
		} catch (Exception e) {
			errors.add(e.getMessage());
			outputLoginPage(response, form, errors);
		}
	}

	private void manageFavoriteList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Look at the what parameter to see what we're doing to the list
		String what = request.getParameter("what");

		if (what == null) {
			// No change to list requested
			outputFavoriteList(request, response);
			return;
		}
		if (what.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			login(request, response);

			return;

		}

		if (what.equals("Add Favorite")) {
			processAdd(request, response, true);
			return;
		}

		if (what.equals("likeit")) {
			processincreaseCount(request, response, true);
			return;
		}

		outputFavoriteList(request, response, "No such operation: " + what);
	}

	private void processincreaseCount(HttpServletRequest request,
			HttpServletResponse response, boolean b) throws ServletException,
			IOException {

		List<String> errors = new ArrayList<String>();

		FavoriteForm form = new FavoriteForm(request);

		// errors.addAll(form.getValidationErrors());
		if (errors.size() > 0) {
			outputFavoriteList(request, response, errors);
			return;
		}

		try {
			int id = Integer.parseInt(form.getFavoriteID());

			favoriteDao.increaseCounter(id);
			outputFavoriteList(request, response, "count Added");
		} catch (Exception e) {
			errors.add(e.getMessage());
			outputFavoriteList(request, response, errors);
		}

	}

	private void processAdd(HttpServletRequest request,
			HttpServletResponse response, boolean addToTop)
			throws ServletException, IOException {
		List<String> errors = new ArrayList<String>();

		FavoriteForm form = new FavoriteForm(request);

		errors.addAll(form.getValidationErrors());
		if (errors.size() > 0) {
			outputFavoriteList(request, response, errors);
			return;
		}

		try {
			Favorite bean = new Favorite();
			bean.setClickCounter(0);
			bean.setComment(form.getComments());
			bean.setUrl(form.getURL());

			HttpSession session = request.getSession();
			// session.getAttribute("user");
			User currentUser = (User) session.getAttribute("user");

			bean.setUserId((currentUser.getUserId()));
			favoriteDao.save(bean);
			outputFavoriteList(request, response, "Favorite saved");

		} catch (Exception e) {
			errors.add(e.getMessage());
			outputFavoriteList(request, response, errors);
		}
	}

	// Methods that generate & output HTML

	private void generateHead(PrintWriter out) {
		out.println("  <head>");
		out.println("    <meta http-equiv=\"cache-control\" content=\"no-cache\">");
		out.println("    <meta http-equiv=\"pragma\" content=\"no-cache\">");
		out.println("    <meta http-equiv=\"expires\" content=\"0\">");
		out.println("    <title>To Do List Login</title>");
		out.println("  </head>");
	}

	private void outputLoginPage(HttpServletResponse response, LoginForm form,
			List<String> errors) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");

		generateHead(out);

		out.println("<body>");
		out.println("<h2>Login Page</h2>");

		if (errors != null && errors.size() > 0) {
			for (String error : errors) {
				out.println("<p style=\"font-size: large; color: red\">");
				out.println(error);
				out.println("</p>");
			}
		}

		// Generate an HTML <form> to get data from the user
		out.println("<form method=\"POST\">");
		// out.print("			 <input type=\"hidden\" size=\"40\" name=\"opt\"/>");
		out.println("    <table/>");
		out.println("        <tr>");
		out.println("            <td style=\"font-size: x-large\">Email address:</td>");
		out.println("            <td>");
		out.println("                <input type=\"text\" name=\"emailAdd\"");
		if (form != null && form.getEmailAdd() != null) {
			out.println("                    value=\"" + form.getEmailAdd()
					+ "\"");
		}
		out.println("                />");
		out.println("            <td>");
		out.println("        </tr>");
		out.println("        <tr>");
		out.println("            <td style=\"font-size: x-large\">Password:</td>");
		out.println("            <td><input type=\"password\" name=\"password\" /></td>");
		out.println("        </tr>");
		out.println("        <tr>");
		out.println("            <td colspan=\"2\" align=\"center\">");
		out.println("                <input type=\"submit\" name=\"button\" value=\"Login\" />");
		out.println("                <input type=\"submit\" name=\"button\" value=\"Register\" />");
		out.println("            </td>");
		out.println("        </tr>");
		out.println("    </table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	private void outputCompleteRegisterPage(HttpServletResponse response,
			LoginForm form, List<String> errors, String inputedEmailAdd,
			String inputedPassword) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");

		generateHead(out);

		out.println("<body>");
		out.println("<h2>Complete Registration papge</h2>");

		if (errors != null && errors.size() > 0) {
			for (String error : errors) {
				out.println("<p style=\"font-size: large; color: red\">");
				out.println(error);
				out.println("</p>");
			}
		}

		// Generate an HTML <form> to get data from the user
		out.println("<form method=\"POST\">");
		out.println("                <input type=\"hidden\" name=\"emailAdd\" value=\""
				+ inputedEmailAdd + "\" ");
		// out.println("                <input type=\"hidden\" name=\"password\" value=\""
		// + inputedPassword + "\" ");
		// form.setPassword(inputedPassword);
		out.println("    <table>");
		out.println("        <tr>");
		out.println("            <td style=\"font-size: x-large\">First Name:</td>");
		out.println("            <td>");
		out.println("                <input type=\"text\" name=\"userFirstName\"");
		if (form != null && form.getUserFirstName() != null) {
			out.println("                    value=\""
					+ form.getUserFirstName() + "\"");
		}
		out.println("                />");
		out.println("            </td>");
		out.println("        </tr>");
		// input last name
		out.println("        <tr>");
		out.println("            <td style=\"font-size: x-large\">Last Name:</td>");
		out.println("            <td>");
		out.println("                <input type=\"text\" name=\"userLastName\"");
		if (form != null && form.getUserFirstName() != null) {
			out.println("                    value=\""
					+ form.getUserFirstName() + "\"");
		}
		out.println("                />");
		out.println("            </td>");
		out.println("        </tr>");
		// password comfirm

		out.println("        <tr>");
		out.println("            <td style=\"font-size: x-large\">Password:</td>");
		out.println("            <td><input type=\"password\" name=\"password\" /></td>");
		out.println("        </tr>");

		out.println("        <tr>");
		out.println("            <td colspan=\"2\" align=\"center\">");
		out.println("                <input type=\"submit\" name=\"button\" value=\"Complete Register\" />");
		out.println("            </td>");
		out.println("        </tr>");
		out.println("    </table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	private void outputFavoriteList(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// Just call the version that takes a List passing an empty List
		List<String> list = new ArrayList<String>();
		outputFavoriteList(request, response, list);
	}

	private void outputFavoriteList(HttpServletRequest request,
			HttpServletResponse response, String message) throws IOException {
		// Just put the message into a List and call the version that takes a
		// List
		List<String> list = new ArrayList<String>();
		list.add(message);
		outputFavoriteList(request, response, list);
	}

	@SuppressWarnings("unchecked")
	private void outputFavoriteList(HttpServletRequest request,
			HttpServletResponse response, List<String> messages)
			throws IOException {
		// Get the list of items to display at the end
		List<Favorite> beans = null;
		User currentUser = null;
		try {
			HttpSession session = request.getSession();
			currentUser = (User) session.getAttribute("user");
			Integer userId = currentUser.getUserId();
			beans = favoriteDao.queryUserFavorites(userId);

		} catch (Exception e) {
			// If there's an access error, add the message to our list of
			// messages
			messages.add(e.getMessage());

		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");

		generateHead(out);

		out.println("<body>");
		out.println("<h2>Web App HW8</h2>");
		out.println("<h3>  Favorites for " + currentUser.getFirstName() + " "
				+ currentUser.getLastName() + "</h3>");

		out.println("<form name=\"AddFavoriteFrom\" method=\"POST\">");
		out.println("<input type=\"submit\" name=\"what\" value=\"logout\"/>");
		out.println("    <table>");
		out.println("        <tr><td colspan=\"3\"><hr/></td></tr>");
		out.println("        <tr>");
		out.println("            <td style=\"font-size: large\">URL:</td>");
		out.println("            <td colspan=\"2\"><input type=\"text\" size=\"40\" name=\"URL\"/></td>");
		out.println("        </tr>");
		out.println("        <tr>");
		out.println("            <td style=\"font-size: large\">comments:</td>");
		out.println("            <td colspan=\"2\"><input type=\"text\" size=\"40\" name=\"comments\"/></td>");
		out.println("        </tr>");
		out.println("        <tr>");
		out.println("            <td/>");
		out.println("            <td><input type=\"submit\" name=\"what\" value=\"Add Favorite\"/></td>");
		// out.println("            <td><input type=\"submit\" name=\"what\" value=\"Add to Bottom\"/></td>");
		out.println("        </tr>");
		out.println("        <tr><td colspan=\"3\"><hr/></td></tr>");
		out.println("    </table>");
		out.println("</form>");

		for (String message : messages) {
			out.println("<p style=\"font-size: large; color: red\">");
			out.println(message);
			out.println("</p>");
		}

		out.println("<p style=\"font-size: x-large\">The list now has "
				+ beans.size() + " items.</p>");
		out.println("<table>");
		for (int i = 0; i < beans.size(); i++) {

			out.println("    <tr>");
			out.println("        <td>");
			out.println("            <form method=\"POST\">");
			out.println("                <input type=\"hidden\" name=\"id\" value=\""
					+ beans.get(i).getFavoriteId() + "\" />");
			out.println("                <input type=\"submit\" name=\"what\" value=\"likeit\" />");
			out.println("            </form>");
			out.println("        </td>");
			out.println("        <td valign=\"top\">&nbsp;" + (i + 1)
					+ ".&nbsp;</td>");
			out.println("        <td valign=\"top\" >" + beans.get(i).getUrl()
					+ "</td>");
			out.println("        <td valign=\"top\" >"
					+ beans.get(i).getComment() + "</td>");
			out.println("        <td valign=\"top\" >"
					+ beans.get(i).getClickCounter() + " clicks" + "</td>");
			out.println("    </tr>");
		}
		out.println("</table>");

		out.println("</body>");
		out.println("</html>");
	}
}
