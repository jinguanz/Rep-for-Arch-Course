<%@ page language="java"
	import="java.util.*,com.opensymphony.xwork2.ActionContext"
	pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>


</head>

<body>
	Login page for HW9
	<br>
	<%
		List<String> errors = (List<String>) ActionContext.getContext()
				.getSession().get("error");
	%>
	<%
		if (errors != null) {
	%>
	<p style="font-size: x-large">
		error:
		<%=errors.get(0)%>
	</p>

	<%
		}
	%>
	<s:form action="Login.action">
		<s:textfield name="emailAddress" label="Email Address" />
		<s:textfield name="password" label="password" />
		<s:submit value="login" method="login" />
		<s:submit value="register" method="register" />
	</s:form>

	<s:form action="Favorite.action">
		<s:submit value="see all favorites" method="retreiveAllFavorite" />
	</s:form>
</body>


</body>
</html>
