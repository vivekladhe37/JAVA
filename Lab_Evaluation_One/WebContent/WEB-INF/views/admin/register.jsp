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


	<sp:form method="post" modelAttribute="employee">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Enter Name</td>
				<td><sp:input path="empName" /></td>
			</tr>
			<tr>
				<td>Enter Email</td>
				<td><sp:input path="email" /></td>
			</tr>
			<tr>
				<td>Enter Salary</td>
				<td><sp:input path="salary" /></td>
			</tr>
			<tr>
				<td>Enter DOB</td>
				<td><sp:input type="date" path="dateOfBirth" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register Me" /></td>
			</tr>
		</table>
	</sp:form>
</body>
</html>