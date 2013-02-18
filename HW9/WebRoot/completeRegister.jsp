<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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

<title>complete register</title>


</head>

<body>
	complete registration
	<br>
	<s:form action="Login.action">
		<s:textfield name="firstName" label="First Name" />
		<s:textfield name="LastName" label="Last Name" />
		<s:textfield name="retypedPassword" label="password" />
		<s:submit value="complete regesiter" method="completeRegister" />
	</s:form>
</body>


</body>
</html>
