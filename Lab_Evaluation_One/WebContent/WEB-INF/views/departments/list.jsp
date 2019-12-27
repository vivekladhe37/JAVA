<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: gray;">

	<h4 align="center" style="font-size: 50px; color: blue">
		${sessionScope.mesg}</h4>

	<h3 align="center" style="font-size: 50px;">Department List</h3>
	<form method="post">
		<table align="center"
			style="background-color: cyan; margin: auto; width: 50%; height: 50%; font-size: 30px;"
			border="1">
			<c:forEach var="d" items="${sessionScope.departmemt_list}">
				<tr>

					<td>${d.id}</td>
					<td>${d.deptName}</td>
					<td>${d.location}</td>
					<td>${d.strength}</td>
					<td><a
						href="<spring:url value='/admin/register?did=${d.id}'></spring:url>">HIRE
							EMP</a></td>

				</tr>


			</c:forEach>
		</table>



	</form>
</body>

</html>