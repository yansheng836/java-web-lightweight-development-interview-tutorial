<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.mysql.jdbc.Driver" %>

<body>
    <%
	     if(request.getParameter("username") == null)
	     {
	 %>
		<form method="post" action="login.jsp" name="userInfo" id="userInfo">
		<table>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username" id="username" /></td>
			</tr>
			<tr>
				<td>Password </td>
				<td><input type="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td colospan="2" align="center">
	<input type="submit" name="logon" value="Login" />&nbsp;&nbsp;
			<input type="reset" name="reset" value="Reset" />
				</td>
			</tr>
		</table>
		</form>
	<%
	    }
	    else
	    {
	        String username = request.getParameter("username").toString();
	        String pwd = "";
	        if(request.getParameter("password") != null)
	        {
	            pwd = request.getParameter("password").toString();
	        }        
	        //connect to DB
	        Class.forName("com.mysql.jdbc.Driver");		
			Connection connection = null;
			connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/book", "root", "123456");
	        String sql = "select username from users where UserName = ?and Pwd = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, pwd);
				ResultSet rs=pst.executeQuery();
			//can login
			if(rs.next())
			{
	%>
	        Welcome,<%=rs.getString("username") %>
	<%		
			}
			else
			{
	%>
	<form method="post" action="login.jsp" name="userInfo" id="userInfo">
		<table>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username" id="username" /></td>
			</tr>
			<tr>
				<td>Password </td>
				<td><input type="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td colospan="2" align="center">
	<input type="submit" name="logon" value="Login" />&nbsp;&nbsp;
				<input type="reset" name="reset" value="Reset" />
				</td>
			</tr>
		</table>
		</form>
	<%		
			}
	    }   
	%>
</body>
</html>
