<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>complete the registration</title>


  </head>
    
   <body>
	Complete the registration
	<br>
	<s:form action="Login.action">
		<s:textfield name ="firstName" label="First Name" />
		<s:textfield name ="lastName" label="Last Name" />
		<s:textfield name ="retypedPassword" label="Passowrd" />	
		<s:submit value="register" method="completeRegister"/>
	</s:form>
</body>
   
   
  </body>
</html>
