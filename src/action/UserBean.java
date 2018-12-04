package action;

import server.DBAccess;

public class UserBean {
	public boolean valid(String username, String password) {
		boolean isValid = false;
		DBAccess db = new DBAccess();
		
		if(db.createConn()) {
			String sql = "SELECT * FROM user WHERE username='" + username + "' and password='" + password + "'";
			db.query(sql);
			if(db.next()) {
				isValid = true;
			}
			db.closeRs();
			db.closeStmt();
			db.closeConn();
		}
		return isValid;
	}
	
	public boolean isExist(String username) {
		boolean isExist = false;
		DBAccess db = new DBAccess();
		
		if(db.createConn()) {
			String sql = "SELECT * FROM user WHERE username='" + username + "'";
			db.query(sql);
			if(db.next()) {
				isExist = true;
			}
			db.closeRs();
			db.closeStmt();
			db.closeConn();
		}
		return isExist;
	}
	
	public void add(String username, String password, String email) {
		DBAccess db = new DBAccess();
		if(db.createConn()) {
			String sql = "INSERT INTO user(username, password, email) VALUES('" + username +"', '" + password + "', '" + email + "')";
			db.update(sql);
			db.closeStmt();
			db.closeConn();
		}
	}
}	
