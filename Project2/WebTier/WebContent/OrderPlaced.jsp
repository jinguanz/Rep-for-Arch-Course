<%@ page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<h2>Welcome to Bikes.com</h2>
	<a href="Home.jsp">Home</a>&nbsp;
	<a href="Logout.jsp">LogOut</a>
	<%
        
        int orderId = 0;
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100000);
        
        
        %>
	<h4 style="FONT-FAMILY: 'Adobe Arabic';">Order has been placed successfully!</h4>
	<h4 style="FONT-FAMILY: 'Adobe Arabic';">
		Order id is
		<%=randomInt%>
	</h4>
</body>
</html>
