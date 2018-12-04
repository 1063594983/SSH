<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="inc.jsp" %>
<%
String sql = "SELECT * FROM user";
try {
	Class.forName(driver).newInstance();
	Connection conn = DriverManager.getConnection(url, user, pwd);
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	ResultSetMetaData rsmd = rs.getMetaData();
	int cols = rsmd.getColumnCount();
	
	while(rs.next()) {
		for(int i = 1; i <= cols; i++) {
			String field = (String)(rsmd.getColumnName(i));
			String value = (String)(rs.getString(i));
			out.print(field + "=" +value + ";");
		}
	}
	
	rs.close();
	stmt.close();
	conn.close();
} catch (Exception e) {
	e.printStackTrace();
	out.println(e);
}
%>