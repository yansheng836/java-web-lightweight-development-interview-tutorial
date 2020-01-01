<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
  <html>
      <body>
          <s:fielderror/>
          <form action="registerAction" validate="true" method="post">                
                                 登录用户：<input type="text" name="username"><br>
                                 登录密码：<input type="text" name="password"><br>
                                 确认密码：<input type="text" name="confirm"><br>
                                 邮件地址：<input type="text" name="email"><br>
		            手机号码：<input type="text" name="handphone"><br>
		    <input type="submit" value="提交">
          </form>
      </body>
  </html>
