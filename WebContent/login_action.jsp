<%@ include file="inc.jsp"%>
<%
//get parameters
String username = request.getParameter("username");
String password = request.getParameter("password");

//check null
if(username == null || password == null) {
	response.sendRedirect("login.jsp");
}

//validate
boolean isValid = false;
String sql = "SELECT * FROM user WHERE username='" + username + "' and password='" + password + "'";
try {
	Class.forName(driver).newInstance();
	Connection conn = DriverManager.getConnection(url, user, pwd);
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	if(rs.next()) {
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
	session.setAttribute("username", username);
	response.sendRedirect("welcome.jsp");
} else {
	response.sendRedirect("login.jsp");
}
%>