import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 
 * 08-600 
 * Homework #7
 * Rui Li <ruili@andrew.cmu.edu> 
 * Nov 4, 2012 
 */

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DecimalFormat df = new DecimalFormat("#,###.00");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculatorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String xinString = request.getParameter("x");
		String yinString = request.getParameter("y");
		String opinString = request.getParameter("opt");

		out.print("<html>");
		out.print("<head>");
		out.print("<title>Servlet Calculator</title>");
		out.print("<script type=\"text/javascript\">");
		out.print("function form_submit(type){");
		out.print("alert(\"add be executed\");");
		out.print("document.aForm.opt.value=type;");
		out.print("document.aForm.submit();");
		out.print("}");

		out.print("function calc_add(){");
		out.print("document.aForm.opt.value='add';");
		out.print("}");

		out.print("function calc_sub(){");
		out.print("document.aForm.opt.value='sub';");
		out.print("}");

		out.print("function calc_muti(){");
		out.print("document.aForm.opt.value='muti';");
		out.print("}");

		out.print("function calc_div(){");
		out.print("document.aForm.opt.value='div';");
		out.print("}");

		out.print("</script>");

		out.print("</head>");
		out.print("<body>");
		out.print("		<form name=\"aForm\" action=calculator method=\"GET\" >");
		out.print("			x: <input type=\"text\" size=\"40\" name=\"x\"> </br>");
		out.print("			 y: <input type=\"text\" size=\"40\" name=\"y\"> </br>");
		out.print("			 <input type=\"hidden\" size=\"40\" name=\"opt\"/>");

		out.print(" <input type=\"submit\" value=\"+\"  onclick=\"calc_add();\"/>");
		out.print(" <input type=\"submit\" value=\"-\"  onclick=\"calc_sub();\"/>");
		out.print(" <input type=\"submit\" value=\"*\"  onclick=\"calc_muti();\"/>");
		out.print(" <input type=\"submit\" value=\"\\\"  onclick=\"calc_div();\"/>");
		out.print("		</form>");
		if (xinString != null & yinString != null & opinString != null) {
			if (!checkDataFormat(xinString)) {
				out.print("wrong imput for x: it's not a number");
			}

			if (!checkDataFormat(yinString)) {
				out.print("wrong imput for y: it's not a number");
			} else {
				if (opinString.equals("div") & checkValueZero(yinString)) {
					out.print("wrong imput for y: no number can divide 0");
				}
				else if (checkDataFormat(xinString)){
					String xinFormat=df.format(Double.parseDouble(xinString));
					String yinFormat=df.format(Double.parseDouble(yinString));
					String resultinFormat=df.format(calc(xinString,yinString,opinString));
					
					out.print("answer is  "+xinFormat+" "+convertOpToSymbol(opinString)+" "+yinFormat+"="+resultinFormat);
					
				}

			}
//			if (checkDataFormat(xinString) & checkDataFormat(yinString)
//					& !(opinString.equals("div") & checkValueZero(yinString))) {
//				String xinFormat=df.format(Double.parseDouble(xinString));
//				String yinFormat=df.format(Double.parseDouble(yinString));
//				String resultinFormat=df.format(calc(xinString,yinString,opinString));
//				
//				out.print("answer is  "+xinFormat+" "+convertOpToSymbol(opinString)+" "+yinFormat+"="+resultinFormat);
//			}
		}

		out.print("</body> ");
		out.print("<html> ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	private boolean checkDataFormat(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean checkValueZero(String str) {
		if (Double.parseDouble(str) == 0.0) {
			return true;
		} else
			return false;
	}

	private double calc(String str1, String str2, String op) {
		double result = 0.0;
		double x = Double.parseDouble(str1);
		double y = Double.parseDouble(str2);
		if (op.equals("add")) {
			result = x + y;
		}
		if (op.equals("sub")) {
			result = x - y;
		}
		if (op.equals("muti")) {
			result = x * y;
		}
		if (op.equals("div")) {
			result = x / y;
		}
		return result;

	}

	private String convertOpToSymbol(String op) {
		String symbol = "";
		if (op.equals("add")) {
			symbol = "+";
		}
		if (op.equals("sub")) {
			symbol = "-";
		}
		if (op.equals("muti")) {
			symbol = "*";
		}
		if (op.equals("div")) {
			symbol = "/";
		}
		return symbol;
	}

}
