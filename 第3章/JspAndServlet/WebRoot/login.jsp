	<%@ page language="java" pageEncoding="GB18030"%>
	<html>
	<head>
	<title>Logon</title>
	</head>
	<body>
	<form name="form1" action="./servlet/Validator" method="POST">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" id="username" /></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;码：</td>
				<td><input type="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td colospan="2" align="center">
	<input type="submit" name="logon" value="登录" />&nbsp;&nbsp;
				<input type="reset" name="reset" value="重置" />
				</td>
			</tr>
		</table>
	</form>
	</body>
	</html>
