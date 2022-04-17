<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%HttpSession s=request.getSession();
String userid=(String)s.getAttribute("userid");
if(userid==null)
	response.sendRedirect("index.jsp");
%>
<a href="listoforders.jsp">list of orders</a>
<br>
<a href="changepassword.jsp">Change Password</a>
<br>
<a href="itemmenu.jsp">Item Menu</a>
</body>
</html>