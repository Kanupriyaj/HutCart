<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Pending Requests</h1>
</center>
<table>
<tr>
<th>first name</th> 
<th>last name</th>
<th>Business name</th>
<th>Category</th>
<th>Business id</th>
<th>Mobile</th>
<th>email</th>
<th>Approve</th>
</tr>
<%
HttpSession s=request.getSession();
String o_id=(String)s.getAttribute("o_id");
if(o_id==null){
	response.sendRedirect("index.jsp");
}
try{
	Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hutcart","root","root");
	PreparedStatement ps=con.prepareStatement("select * from request");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
	%>
	<tr>
	<td><%=rs.getString(1) %></td>
	<td><%=rs.getString(2) %></td>
	<td><%=rs.getString(3) %></td>
	<td><%=rs.getString(4) %></td>
	<td><%=rs.getString(5) %></td>
	<td><%=rs.getString(7) %></td>
	<td><%=rs.getString(8) %></td>
	<td><a href="approveRequestServlet?fname=<%=rs.getString(1)%>&lname=<%=rs.getString(2)%>&bname=<%=rs.getString(3)%>&category=<%=rs.getString(4)%>&b_id=<%=rs.getString(5)%>&pass=<%=rs.getString(6)%>&mob=<%=rs.getString(7)%>&email=<%=rs.getString(8)%>" >Approve</a></td>
	</tr>
	<%	
	}
	
}catch(Exception e){
	e.printStackTrace();
}
%>
</table>
</body>
</html>