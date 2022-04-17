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
String b_id=(String)s.getAttribute("b_id");
if(b_id==null){
	response.sendRedirect("index.jsp");
}
%>
<h1 style="align:center">Add Items</h1>
<form action="addItemServlet">
Product ID:
<input type="text" name="p_id" placeholder="Product ID">
<br>
Product Name:
<input type="text" name="p_name" placeholder="Product Name">
<br>
Price:
<input type="text" name="price" placeholder="Price">
<br>
Quantity:
<input type="text" name="quantity" placeholder="quantity">
<br>
Category:
<input type="text" name="category" placeholder="Category">
<br>
<input type="Submit" name="Add Product">
</form>
</body>
</html>