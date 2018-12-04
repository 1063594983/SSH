<%@ include file="inc.jsp" %>
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

//validate
boolean isValid = false;
String sql = "SELECT * FROM user WHERE username = '" + username + "'";
try {
	Class.forName(driver).newInstance();
	Connection conn = DriverManager.getConnection(url, user, pwd);
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	if(!rs.next()) {
		sql = "INSERT INTO user(username, password, email) values('" + username + "','" + password + "','" + email + "')";
		stmt.execute(sql);
		isValid = true;
	}
	
	rs.close();
	stmt.close();
	conn.close();
} catch (Exception e) {
	e.printStackTrace();
	out.println(e);
} finally {
	
}

if(isValid) {
	response.sendRedirect("login.jsp");
} else {
	response.sendRedirect("register.jsp");
}
%>