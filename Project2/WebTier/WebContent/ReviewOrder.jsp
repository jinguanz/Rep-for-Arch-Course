<%-- 
    Document   : ReviewOrder
    Created on : 16 Oct, 2012, 11:32:14 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<h3>Review Order</h3>
	<%
        String cardNo = request.getParameter("cardno");
		String expirationMonth = request.getParameter("month");
        String expirationYear = request.getParameter("year");
        String cvv = request.getParameter("cvv");
        %>
	<form name="form1" action="OrderPlaced.jsp" method="Post">
		<table>
			<tr>
				<td>Card No.</td>
				<td><%=cardNo %></td>
			</tr>
			<tr>
				<td>Card Expiration(mm-yy)</td>
				<td><%=expirationMonth%>-<%=expirationYear%></td>
			</tr>

			<tr>
				<td>CVV No.</td>
				<td><%=cvv%></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Confirm">
				</td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>