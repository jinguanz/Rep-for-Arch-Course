<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logged in</title>
</head>
<body>
<%
	String username=request.getParameter("uname");
	String password=request.getParameter("pwd");
	
	if(null==username || username.length()==0)
	{
%>
                <h4>Incorrect username or password...Try again...</h4>
		<a href="Login.html">login</a>
<%
	}
               else if (username.equals("admin")&&password.equals("admin"))
                {
                   %>
                   <jsp:include page="Home.jsp"/>
                   <%
               }
	if(request.isUserInRole("admin")){
		%>
        <jsp:include page="AllOrders.jsp"/>
        <%
	}


%>
</body>
</html>