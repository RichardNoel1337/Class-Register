<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Your Course</title>
</head>
<body>
<%@ taglib uri="/WEB-INF/tlds/MyCourseTag.tld"
	prefix="MCT"%>
	<h1 align="center">Which of the following courses would you like to add?:</h1>
	<br>
	<br>
	<br>
	<form action="addRemoveServlet" align="center" >
			<select align="center" style="width:100px" name="courseAdded">
			
<MCT:MyCourseTag currentStudent="${currentStudent.studentID}" currentCourses="${availableCourses}" commandCode="2"/>

		<br>
		<br>
		<br>
		<br>
		<input name="courseAction" type="submit" value="ENROLL" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input name="courseAction" type="submit" value="EXIT" />
	</form>



</body>
</html>