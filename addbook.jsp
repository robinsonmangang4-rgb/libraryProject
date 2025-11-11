<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>

<% response.setHeader("Cache-control","no-cache,no-store,must-revalidate");
		if (session.getAttribute("username")==null) {
			response.sendRedirect("index.html");
		}
	%>
<center>
	<h1>Enter Book Details.</h1>
	
   <form action="AddBook">
 		<input tpye="text" name="bookname" placeholder="bookname" required><p>
	    <input tpye="text" name="author" placeholder="author" required><p>
	    <input tpye="text" name="bookprice" placeholder="bookprice" required><p>
	    <input tpye="text" name="rentprice" placeholder="rentprice" required><p>

	    <input type="submit">
    </form>
</center>



</body>
</html>