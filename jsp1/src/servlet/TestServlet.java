package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("두포스트 호출했네요~ " + req.getParameterMap());
		PrintWriter out = resp.getWriter();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Map<String, String[]> m = req.getParameterMap();
		Iterator<String> it = m.keySet().iterator();
		String result = "두겟 호출했네요~";
		while(it.hasNext()) {
			String key = it.next();
			result += key + "." + req.getParameter(key);
		}
		doProcess(resp, result);
	}
	
	public void doProcess(HttpServletResponse resp, String writeStr) throws IOException{
		resp.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(writeStr);
	}
}
