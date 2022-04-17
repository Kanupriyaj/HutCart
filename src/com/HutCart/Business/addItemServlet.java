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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addItemServlet
 */
@WebServlet("/addItemServlet")
public class addItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		String b_id=(String)s.getAttribute("b_id");
		if(b_id==null){
			response.sendRedirect("index.jsp");
		}
		String p_id=request.getParameter("p_id");
		String p_name=request.getParameter("p_name");
		String price=request.getParameter("price");
		String quantity=request.getParameter("quantity");
		String category=request.getParameter("category");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hutcart", "root", "root");
			PreparedStatement ps=con.prepareStatement("insert into products value(?,?,?,?,?,?)");
			ps.setString(1, p_id);
			ps.setString(2, p_name);
			ps.setString(3, price);
			ps.setString(4, quantity);
			ps.setString(5, category);
			ps.setString(6, b_id);
			int x=ps.executeUpdate();
			if(x==1) {
				out.println("<h1>Item Inserted Successfully</h1>");
				response.sendRedirect("itemenu.jsp");
			}else {
				out.println("<h1>Some Error Occurred</h1>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
