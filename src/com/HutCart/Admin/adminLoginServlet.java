package com.HutCart.Admin;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class adminLoginServlet
 */
@WebServlet("/adminLoginServlet")
public class adminLoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String o_id=request.getParameter("o_id");
		String password=request.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hutcart","root","root");
			PreparedStatement ps=con.prepareStatement("select * from owner where o_id=? and password=?");
			ps.setString(1, o_id);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				HttpSession s=request.getSession();
				s.setAttribute("o_id", o_id);
				s.setAttribute("adminpass",password);
				response.sendRedirect("admin.jsp");
			}else {
				PrintWriter out=response.getWriter();
				out.println("not a user");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
