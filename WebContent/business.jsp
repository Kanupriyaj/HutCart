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
<a href="itemmenu.jsp">Item Menu</a>

</body>
</html>