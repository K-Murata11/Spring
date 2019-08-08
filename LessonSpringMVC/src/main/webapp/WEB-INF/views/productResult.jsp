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
	<table border="1">
		<tr>
			<th>名前</th>
			<th>価格</th>
		</tr>
		<tr>
			<td><c:out value="${productForm.name}" /></td>
			<td>${productForm.price}</td>
		</tr>
	</table>
</body>
</html>
