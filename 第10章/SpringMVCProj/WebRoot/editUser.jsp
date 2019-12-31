<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>修改用户</title>
  </head>  
  <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  <body>  
    <form action="<%=basePath%>/modifyUser" method="post">  
        <input type="hidden" name="id" value="${user.id }">  
        用户名：<input type="text" name="name" value="${user.name }"><br/>  
        年&nbsp龄： <input type="text" name="age" value="${user.age }"><br/>  
        <input type="submit" value="修改">  
    </form>  
  </body>  
</html>
