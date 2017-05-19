<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title></title>
  </head>
  <body>
	 <form action="core_Register.action" method="post">
	 	<table border="1" width="300">
		 	<tr>
			 	<th>用户名：</th>
		 		<th><input name="username"/></th>
		 	</tr>
		 	<tr>
			 	<th>密码：</th>
		 		<th><input type="password" name="password"/></th>
		 	</tr>
		 	<tr>
			 	<th>邮箱：</th>
		 		<th><input name="email"/></th>
		 	</tr>
	 	</table>
	 	<input type="submit" value="注册"/>
	 </form>
  </body>
</html>