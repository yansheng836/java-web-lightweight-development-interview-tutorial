<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>login</title>
	</head>
	<body>
		Login		
		<s:form method="post" action="demo/login.do" id="userInfo">
		
		    <s:textfield name="userName" label="User Name"/>
			<br>
			<s:password name="userPwd" label="Password"/>
			<br>			
			<s:submit value="Login" />
		</s:form>
		
	</body>
</html>