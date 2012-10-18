<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="commonstyle.css">
</head>
<body>
<%
session.invalidate();
%>
<table WIDTH="70%" border="0" align="center">
	<tr>
		<td><center><b>You have Successfully logged out</b></center></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>

</table>
<br>
<center><a href="Login.html">Go back to Login page</a></center>
</body>
</html>
