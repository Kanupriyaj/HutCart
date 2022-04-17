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
 * Servlet implementation class changeAdminPasswordServlet
 */
@WebServlet("/changeAdminPasswordServlet")
public class changeAdminPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String old=request.getParameter("oldpassword");
    		String new1=request.getParameter("newpassword");
    	
    		HttpSession s=request.getSession();
    		String o_id=(String) s.getAttribute("o_id");
    		PrintWriter out=response.getWriter();
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hutcart", "root", "root");
    			PreparedStatement ps=con.prepareStatement("select * from owner where o_id=?");
    			ps.setString(1, o_id);
    			ResultSet rs=ps.executeQuery();
    			String pass=null;
    			while(rs.next()) {
    				pass=rs.getString(4);
    			}
    			System.out.println(old+" "+pass);
    			System.out.println(old.equals(pass));
    			if(pass.equals(old)) {
    				ps=con.prepareStatement("update owner set password=? where o_id=?");
    				ps.setString(1, new1);
    				ps.setString(2, o_id);
    				int x=ps.executeUpdate();
    				if(x==1) {
    					out.println("<h1>successful</h1>");
    				}else {
    					out.println("<h1>Unsuccessful</h1>");
    				}
    			}else {
    				out.println("<h1>wrong old password");
    			}
    		}catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    		}
    		
}

