
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrator panel</title>
</head>
<body>
<%HttpSession s=request.getSession();
String o_id=(String)s.getAttribute("o_id");
if(o_id==null){
	response.sendRedirect("index.jsp");
}
%>
<a href="newAdminRegistration.jsp">Add a new admin</a>
<a href="changeAdminPassword.jsp">Change Password</a>
<a href="request.jsp">Show Request</a>
<a href="adminLogoutServlet">Logout</a>

</body>
</html>