<%@ page import="action.*" %>
<%
//get parameter
String username = request.getParameter("username");
String password = request.getParameter("password");
String password2 = request.getParameter("password2");
String email = request.getParameter("email");

//check null
if(username == null || password == null || password2 == null || email == null) {
	response.sendRedirect("register.jsp");
}

UserBean userBean = new UserBean();

//validate
boolean isExist = userBean.isExist(username);


if(!isExist) {
	userBean.add(username, password, email);
	response.sendRedirect("login.jsp");
} else {
	response.sendRedirect("register.jsp");
}
%>