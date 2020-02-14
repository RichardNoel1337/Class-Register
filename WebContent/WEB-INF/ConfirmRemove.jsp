<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Removal</title>
</head>
<body>

<h1 align="center">Would you like to remove the following course?:</h1>

<form action="addRemoveServlet">

<center>

			<h1>${param.courseList}</h1>
<br />
<br />
<br />

<input name="courseAction" type="submit" value="YES" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input name="courseAction" type="submit" value="NO">

</center>
</form>

</body>
</html>