package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;

//create JDBC connection
public class JDBCConnection {

	public Connection getConn() {
		String username = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/web_ban_sach";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
