package com.HutCart.Admin;

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
 * Servlet implementation class newAdminServlet
 */
@WebServlet("/newAdminServlet")
public class newAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String fname=request.getParameter("fname");
    		String lname=request.getParameter("lname");
    		String o_id=request.getParameter("o_id");
    		String password=request.getParameter("password");
    		String o_mob=request.getParameter("o_mob");
    		String email=request.getParameter("email");
    		
    		PrintWriter out=response.getWriter();
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hutcart","root","root");
    			PreparedStatement ps=con.prepareStatement("insert into owner values(?,?,?,?,?,?)");
    			ps.setString(1, fname);
    			ps.setString(2, lname);
    			ps.setString(3, o_id);
    			ps.setString(4, password);
    			ps.setString(5, o_mob);
    			ps.setString(6, email);
    			int x=ps.executeUpdate();
    			if(x==1) {
    				out.println("<h1>successful</h1>");
    			}else {
    				out.println("<h1>Some Probelm occured</h1>");
    			}
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}

}
