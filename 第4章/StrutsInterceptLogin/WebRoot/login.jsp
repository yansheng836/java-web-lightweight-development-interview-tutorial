<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <html>
    <head>
         <title>登录界面</title>         
   </head>
   <body>
                                    用户登录
             <br>
             <s:form action="/login" method="post">
                 <s:textfield name="username" label="用户名"/>
                 <s:textfield name="password" label="密码"/>
                 <s:submit value="登录"/>
             </s:form>
     </body>
 </html>