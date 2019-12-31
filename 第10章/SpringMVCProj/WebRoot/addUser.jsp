<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>添加用户</title>
  </head> 
  <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
  <body>  
    <form action="<%=basePath%>/addUser" method="post">  
        用户名：<input type="text" name="name"><br/>  
        年&nbsp龄：      <input type="text" name="age"><br/>  
           <input type="submit" value="添加用户">  
    </form>  
  </body>  
</html>  
