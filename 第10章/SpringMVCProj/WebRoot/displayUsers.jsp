<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>  
  <head>  
    <title>用户列表</title>      
  </head>  
  <body>  
        <a href=/SpringMVCProj/addUser.jsp>添加用户</a>
        <table border="1">  
            <tbody>  
                <tr>  
                    <th>名字</th>  
                    <th>年龄</th>  
                    <th>操作</th>  
                </tr>  
                    <c:forEach items="${users}" var="u">  
                        <tr>  
                            <td>${u.name }</td>  
                            <td>${u.age }</td>  
                            <td>  
                                <a href="/SpringMVCProj/getUser/${u.id}">更新</a>  
                                <a href="/SpringMVCProj/deleteUser/${u.id}">删除</a>  
                            </td>  
                        </tr>  
                    </c:forEach>  
            </tbody>  
        </table>  
  </body>  
</html>  