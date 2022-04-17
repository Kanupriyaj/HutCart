<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Login</h2>
<form action="customerSignupServlet"> 
Enter first name:
<input type="text" name="fname" placeholder="first name" ><br>
Enter last name:
<input type="text" name="lname" placeholder="last name" ><br>
Enter your id:
<input type="text" name="c_id" placeholder="enter id" ><br>
Enter password:
<input type="password" name="password" placeholder="password" ><br>
Enter mobile number:
<input type="text" name="mob" placeholder="mobile no." ><br>
Enter Email id:
<input type="text" name="email" placeholder="emial" ><br>
Enter Address:
<input type="text" name="address" placeholder="address" ><br>
<input type="submit">
</form>
</body>
</html>