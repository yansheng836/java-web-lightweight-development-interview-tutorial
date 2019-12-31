<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <jsp:useBean id="mybean" scope="session" class="JavaBeanPackage.NameHandler"/>
	<jsp:setProperty name="mybean" property="userName" value ='<%=request.getParameter("username")%>'/>
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<title>hello</title>
</head>		
<body>
    <h1>Hello,<jsp:getProperty name = "mybean" property = "userName" /></h1>	
</body>
</html>
