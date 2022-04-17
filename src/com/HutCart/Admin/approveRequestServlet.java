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
 * Servlet implementation class approveRequestServlet
 */
@WebServlet("/approveRequestServlet")
public class approveRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public approveRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String bname=request.getParameter("bname");
		String category=request.getParameter("category");
		String b_id=request.getParameter("b_id");
		String pass=request.getParameter("pass");
		String mob=request.getParameter("mob");
		String email=request.getParameter("email");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hutcart","root","root");
			PreparedStatement ps=con.prepareStatement("insert into business values(?,?,?,?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3,bname);
			ps.setString(4, category);
			ps.setString(5, b_id);
			ps.setString(6,pass);
			ps.setString(7, mob);
			ps.setString(8, email);
			int x=ps.executeUpdate();
			if(x==0) {
				out.println("<h1>Not able to aprrove error 1</h1>");
			}
			ps=con.prepareStatement("delete from request where b_id=?");
			ps.setString(1, b_id);
			x=ps.executeUpdate();
			if(x==1) {
				response.sendRedirect("admin.jsp");
			}else {
				out.println("<h1>error 3</h1>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
