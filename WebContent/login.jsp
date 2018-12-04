<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
	<base href="<%=basePath%>">
<title>Insert title here</title>
</head>
<body>
	This is my JSP page. <br>
	<form action="login_action.jsp" name="form1" method="post">
		<table width="200" border="1">
			<tr><td colspan="2">登录窗口</td></tr>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username" size="10"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" size="10"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="submit" value="登录">
					<a href="register.jsp">注册新用户</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>