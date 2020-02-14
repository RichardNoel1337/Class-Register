<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="beanPod.LoginBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Courses</title>
</head>
<body>

<%@ taglib uri="/WEB-INF/tlds/MyCourseTag.tld"
	prefix="MCT"%>
	
<h1 align="center">My Courses:</h1>

<form action="RedirectServlet" align="center">
<select align="center" style="width:100px; height:auto" name="courseList" multiple>


<MCT:MyCourseTag currentStudent="${currentStudent.studentID}" currentCourses="${currentCourses}" commandCode="1"/>
 


<br>
<input type="submit" name="action" value="Register"/>         
<input type="submit" name="action" value="Drop"/>
<input type="submit" name="action" value="Exit"/>
</form>
</body>
</html>