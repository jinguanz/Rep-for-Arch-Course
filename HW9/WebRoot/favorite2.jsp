<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"
	import="java.util.List, com.opensymphony.xwork2.ActionContext,edu.cmu.mse.rui.J2EE.HW8.DataBean.Favorite"%>
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

<title>My favorite web site list page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>

<body>
	<a href="modify.jsp">Modify Password</a>
	<s:form action="Login.action">
		<s:submit value="logout" method="logout" />
	</s:form>
	<s:form action="Favorite.action">
		<s:submit value="see all favorites" method="retreiveAllFavorite" />
	</s:form>
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
	<h2>Favorite Web site Register</h2>
	Favorite page for ${sessionScope.LastName}, ${sessionScope.FirstName}
	<br>
	<table>
		<s:form action="Favorite.action">
			<s:textfield name="inputURL" label="URL" />
			<s:textfield name="inputcomments" label="comments" />
			<s:submit value="add" method="addOneFavorite" />
		</s:form>
	</table>

	<%
		List<Favorite> favoriteBean = (List<Favorite>) ActionContext
				.getContext().getSession().get("allFavoriteForOwner");
	%>

	<%
		if (favoriteBean != null) {
	%>
	<p style="font-size: x-large">
		The list now has
		<%=favoriteBean.size()%>
		items.
	</p>

	<%
		}
	%>
	<table>
		<%
			if (favoriteBean != null) {
				for (int i = 0; i < favoriteBean.size(); i++) {
					Favorite item = favoriteBean.get(i);
		%>
		<tr>
			<td><s:form action="Favorite.action">
					<input type="hidden" name="favoriteID"
						value="<%=item.getFavoriteId()%>" />
					<s:submit value="X" method="deleteOneFavoriate" />
				</s:form></td>
			<td valign="baseline" style="font-size: x-large">&nbsp; <%=i + 1%>.
				&nbsp;</td>
			<td valign="baseline"><span style="font-size: x-large"> <a
					href="."><%=item.getUrl()%></a> </span></td>


			<td><s:form action="Favorite.action">
					<input type="hidden" name="favoriteID"
						value="<%=item.getFavoriteId()%>" />
					<s:submit value="click me" method="clickOneFavorite" />
				</s:form></td>



			<td valign="baseline"><span style="font-size: x-large"> <%="Commnets: " + item.getComment()%>
			</span></td>
			<td valign="baseline"><span style="font-size: x-large"> <%="Click Count: " + item.getClickCounter()%>
			</span></td>
		</tr>
		<%
			}
			}
		%>
	</table>



</body>