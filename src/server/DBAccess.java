package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBAccess {
	//���ݿ�����
	private String driver = "com.mysql.jdbc.Driver";
	//����URL
	private String url = "jdbc:mysql://localhost:3306/demo";
	//�û���
	private String user = "root";
	//����
	private String pwd = "root";
	//���ݿ����Ӷ���
	private Connection conn = null;
	//���ݿ���������
	private Statement stmt = null;
	//���ݽ��������
	private ResultSet rs = null;
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public Statement getStmt() {
		return stmt;
	}
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
	
	public boolean createConn() {
		boolean b = false;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, user, pwd);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public boolean update(String sql) {
		boolean b = false;
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public void query(String sql) {
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean next() {
		boolean b = false;
		try {
			if(rs.next()) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public String getValue(String field) {
		String value = null;
		try {
			if(rs != null) {
				value = rs.getString(field);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public void closeRs() {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeStmt() {
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeConn() {
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
