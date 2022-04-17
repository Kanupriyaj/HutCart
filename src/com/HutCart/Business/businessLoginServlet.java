package com.HutCart.Business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class businessLoginServlet
 */
@WebServlet("/businessLoginServlet")
public class businessLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		String pass=request.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hutcart","root","root");
			PreparedStatement ps=con.prepareStatement("select * from admin where username=? and password=?");
			ps.setString(1, userid);
			ps.setString(2, pass);
			ResultSet rs=null;
			rs=ps.executeQuery();
			if(rs==null) {
				response.sendRedirect("index.jsp");
			}
			HttpSession s=request.getSession();
			s.setAttribute("userid",userid);
			response.sendRedirect("dashboard.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
