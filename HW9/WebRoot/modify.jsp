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
	change your password
	<br>
	<s:form action="Login.action">
		<s:textfield name="password" label="old password" />
		<s:textfield name="retypedPassword" label="new password" />
		<s:submit value="change password" method="changePassword" />
	</s:form>
</body>


</body>
</html>
