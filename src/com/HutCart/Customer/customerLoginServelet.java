package com.HutCart.Customer;

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
@WebServlet("/customerLoginServlet")

public class customerLoginServelet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c_id=request.getParameter("c_id");
		String pass=request.getParameter("password");
		PrintWriter out= response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hutcart","root","root");
			PreparedStatement ps=con.prepareStatement("select * from customer where username=? and password=?");
			ps.setString(1, c_id);
			ps.setString(2, pass);
			ResultSet rs=null;
			rs=ps.executeQuery();
			if(rs==null) {
				out.println("user id or password incorrect");
				out.println("<a href=login.jsp>Go Back</a>");
			}
			HttpSession s=request.getSession();
			s.setAttribute("customer",c_id);
			response.sendRedirect("index.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
