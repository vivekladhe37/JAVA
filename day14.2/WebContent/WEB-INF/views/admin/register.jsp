<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sp:form method="post" modelAttribute="vendor">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Enter User Name</td>
				<td><sp:input path="name" /></td>
			</tr>
			<tr>
				<td>Enter User Email</td>
				<td><sp:input path="email" /></td>
			</tr>
			<tr>
				<td>Enter City</td>
				<td><sp:input path="city" /></td>
			</tr>
			<tr>
				<td>Enter Cell No</td>
				<td><sp:input path="cellNo" /></td>
			</tr>
			<tr>
				<td>Choose Role</td>
				<td><sp:radiobutton path="role" value="vendor" />Vendor</td>
				<td><sp:radiobutton path="role" value="admin" />Admin</td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><sp:password path="password" /></td>
			</tr>
			<tr>
				<td>Enter Reg Amount</td>
				<td><sp:input type="number" path="regAmount" /></td>
			</tr>
			<tr>
				<td>Enter Reg Date</td>
				<td><sp:input type="date" path="regDate" /></td>
			</tr>
			

			<tr>
				<td><input type="submit" value="Register Me" /></td>
			</tr>
		</table>
	</sp:form>

</body>
</html>