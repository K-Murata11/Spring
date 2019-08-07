<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>${message}</h2>
<form:form modelAttribute="loginForm">
ID<form:input path="userID"/>&nbsp;
<form:errors path="userID"></form:errors>
<br>
PW<form:password path="password"/>&nbsp;
<form:errors path="password"></form:errors>
<br>
<input type="submit" value="送信">
</form:form>

</body>
</html>