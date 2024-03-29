package com.HutCart.Admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class adminLogoutServlet
 */
@WebServlet("/adminLogoutServlet")
public class adminLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		HttpSession s=request.getSession();
    		s.invalidate();
    		response.sendRedirect("index.jsp");
    	}

}
