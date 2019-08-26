<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${message}</h2>
	<form:form modelAttribute="loginForm">
		<form:input path="userId" /> &nbsp;
		<form:errors path="userId" cssStyle="color:red" />
		<br>
		<form:password path="password" /> &nbsp;
		<form:errors path="password" cssStyle="color:red" />
		<br>
		<input type="submit">
	</form:form>
</body>
</html>