<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:useBean id="mybean" scope="session" class="JavaBeanPackage.NameHandler"/>
	<jsp:setProperty name="mybean" property="userName" value = "*"/>
    <%
	    if(request.getParameter("username")!=null)
		{
			response.sendRedirect("responseuser.jsp");
		}
	%>
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>Hello,User</title>
	</head>
	<body>
		<h1>Hello,my name is 张三.What's your name?</h1>
		<form method = "get" action = "responseuser.jsp">
			<input type = "text" name = "username" size = "25"><br>
			<input type = "submit" value = "提交">
			<input type = "reset" value = "重置">
		</form>
	</body>
</html>