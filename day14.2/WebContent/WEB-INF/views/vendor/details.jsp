<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%--importing spring supplied JSP tag lib --%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>${requestScope.mesg}</h4>
	<h5>User Details : ${sessionScope.user_dtls}</h5>
	<a href="<spring:url value='/user/logout'/>">Log Me out</a>
</body>
</html>