<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>Product Result</title>
</head>
<body>
	<p>
		<c:out value="${message}" />
	</p>
	<form:form modelAttribute="productForm">
	名前<form:input path="name" /><br>
	価格<form:input path="price" /><br>
	<input type="submit" value="送信" /><br>
	</form:form>
</body>
</html>
