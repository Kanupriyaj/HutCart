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

<form action="changeBusinessPasswordServlet">
insert old password:
<input type="password" placeholder="old password" name="oldpassword">
<br>
insert new password:
<input type="password" placeholder="newpassword" name="newpassword1">
<br>
confirm new password:
<input type="password" placeholder="Confirm password" name="newpassword2">
<input type="submit" placeholder="change password">
</form>
</body>
</html>