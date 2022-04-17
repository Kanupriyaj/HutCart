package com.HutCart.Customer;

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

/**
 * Servlet implementation class customerSignupServlet
 */
@WebServlet("/customerSignupServlet")
public class customerSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String c_id=request.getParameter("c_id");
		String pass=request.getParameter("password");
		String mob=request.getParameter("mob");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hutcart","root","root");
			PreparedStatement ps=con.prepareStatement("insert into customer values (?,?,?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3,c_id);
			ps.setString(4, pass);
			ps.setString(5, mob);
			ps.setString(6, email);
			ps.setString(7, address);
			int x=ps.executeUpdate();
			if(x==1) {
				out.println("Successfull");
				out.println("<a href=customerLogin.jsp>Login</a>");
			}
			else {
				out.println("Some Error Occur");
			
		}
	}
		catch(Exception e) {
			e.printStackTrace();

		}

}
}

