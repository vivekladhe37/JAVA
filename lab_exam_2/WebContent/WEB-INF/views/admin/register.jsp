<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4 align="center" style="font-size: 50px; color: red">
		${sessionScope.msg1}</h4>


	<sp:form method="post" modelAttribute="student">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Enter Name</td>
				<td><sp:input path="name" /></td>
			</tr>
			<tr>
				<td>Enter Address</td>
				<td><sp:input path="address" /></td>
			</tr>
			
			<tr>
				<td>Enter DOB</td>
				<td><sp:input type="date" path="dob" /></td>
			</tr>
			<tr>
				<td>Enter CGPA</td>
				<td><sp:input  path="cgpa" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register Me" /></td>
			</tr>
		</table>
	</sp:form>
</body>
</html>