<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%HttpSession s = request.getSession();
 String o_id = (String)s.getAttribute("o_id");
 if(o_id==null){
	 response.sendRedirect("index.jsp");
 }
%>
<form action="changeAdminPasswordServlet">
Enter old password :
<input type="password" name="oldpassword" placeholder="old password">
Enter new password :
<input type="password" name="newpassword" placeholder="new password">
RE-Enter new password :
<input type="password" name="renewpassword" placeholder="new password">
<input type="submit">

</form>
</body>
</html>