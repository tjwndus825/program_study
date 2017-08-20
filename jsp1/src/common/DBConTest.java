package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConTest {

	public static void main(String[] args) {
		Connection con;
		Statement st;
		try {
			con = DBConnector.getCon();
			System.out.println("연결 성공");
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from user");
			while(rs.next()) {
				String user_no = rs.getString("user_no");
				String id1 = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				System.out.println("번호:" + user_no + "  아이디:" + id1 + "  비밀번호:" + password + "  이름:" + name);
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
