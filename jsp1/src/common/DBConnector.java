package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	public static Connection con;
	
	public static Connection getCon() throws ClassNotFoundException, SQLException{
		if(con==null) {
			String url = "jdbc:mysql://localhost:3306/jsp_study";
			String id = "root";
			String pwd = "0000";
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pwd);
		}
		return con;
	}
	
	public static void closeCon() throws SQLException{
		if(con!=null) {
			con.close();
			con = null;
		}
	}
}
