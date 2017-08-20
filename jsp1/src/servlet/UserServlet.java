package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.DBConnector;


public class UserServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobbies = req.getParameterValues("hobby");
		String hobby = "";
		for(String h:hobbies) {
			hobby += h + ",";
		}
		hobby = hobby.substring(0, hobby.length()-1);
		String result = "입력하신 ID : " + id + "<br>";
		result = name + " 님 회원가입에 실패하셨습니다.";
		result += "입력하신 취미 : " + hobby + "<br>"; 
		
		Connection con;
		try {
			con = DBConnector.getCon();
			String sql = "insert into user(id,password,name,hobby)";
			sql += " values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ps.setString(3, name);
			ps.setString(4, hobby);
			int row = ps.executeUpdate();
			if(row==1) {
				result = name + " 님 회원가입에 성공하셨습니다.";
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		doProcess(resp, result);
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

	}
	
	public void doProcess(HttpServletResponse resp, String writeStr) throws IOException{
		resp.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(writeStr);
	}
}
