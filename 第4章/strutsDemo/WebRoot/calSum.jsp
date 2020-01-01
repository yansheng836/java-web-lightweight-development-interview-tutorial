<%@ page language="java" pageEncoding="GBK" %>
  <%@ taglib prefix="s" uri="/struts-tags"%>
  
  <html>
      <head>
          <title>输入操作数</title>
      </head>
  
      <body>
           求和
          <br/>
          <s:form action="mystruts/calSum" >                
              <s:textfield name="num1" label="数1"/>
              <s:textfield name="num2"  label="数2" />        
              <s:submit value="求和" />            
          </s:form>
      </body>
  </html>
