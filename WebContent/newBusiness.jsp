<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Business Registration Form</h2>
<form action="businessRegServlet">
Enter owner first name:
<input type="text" name="fname" placeholder="first name"><br>

Enter owner last name:
<input type="text" name="lname" placeholder="last name"><br>
Enter business name :
<input type="text" name="businame" placeholder="business name"><br>
Enter business category:
<input type="text" name="busicategory" placeholder="category"><br>
Enter user id :
<input type="text" name="b_id" placeholder="enter id"><br>
Enter password :
<input type="password" name="password" placeholder="enter password"><br>

Re-enter password:
<input type="password" name="repassword" placeholder="re enter  password"><br>

Enter mobile number :
<input type="text" size="10" name="b_mob" placeholder="mobile number"><br>

Enter E-mail:
<input type="text" name="email" placeholder="E-mail"><br>
<input type="submit">
</form>
</body>
</html>