<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome.jsp</title>
</head>
<body>
	<h1>欢迎你,<%=session.getAttribute("username") %></h1>
	<a href="UserServlet.do?method=logout">退出</a>
</body>
</html>