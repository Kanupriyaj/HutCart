package com.HutCart.Business;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/businessRegServlet")
public class businessRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String bname=request.getParameter("businame");
		String category=request.getParameter("busicategory");
		String b_id=request.getParameter("b_id");
		String pass=request.getParameter("password");
		String mob=request.getParameter("b_mob");
		String email=request.getParameter("email");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hutcart","root","root");
			PreparedStatement ps=con.prepareStatement("insert into request values(?,?,?,?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, bname);
			ps.setString(4, category);
			ps.setString(5, b_id);
			ps.setString(6, pass);
			ps.setString(7, mob);
			ps.setString(8, email);
			int x=ps.executeUpdate();
			if(x==1) {
				out.println("<h1> request sent..... please wait for admin to approve</h1>");
			}else
				out.println("<h1>Something went wrong</h1>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
