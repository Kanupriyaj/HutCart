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
String o_id=(String)s.getAttribute("o_id");
if(o_id==null){
	response.sendRedirect("index.jsp");
}
%>
<center><h1>Register a new admin</h1></center>
<hr>
<form action="newAdminServlet">
Enter first name:
<input type="text" name="fname" placeholder="first name"><br>

Enter last name:
<input type="text" name="lname" placeholder="last name"><br>
Enter user id :
<input type="text" name="o_id" placeholder="enter id"><br>
Enter password :
<input type="password" name="password" placeholder="enter password"><br>

Re-enter password:
<input type="password" name="repassword" placeholder="re enter  password"><br>

Enter mobile number :
<input type="text" size="10" name="o_mob" placeholder="mobile number"><br>

Enter E-mail:
<input type="text" name="email" placeholder="E-mail"><br>
<input type="submit">
</form>
</body>
</html>