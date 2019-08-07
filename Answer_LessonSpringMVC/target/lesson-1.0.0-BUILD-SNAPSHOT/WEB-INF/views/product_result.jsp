<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		<c:out value="${message}" />
	</p>
	<p>
		<c:out value="${productForm.name }" />
	</p>
	<table border="1">
		<tr>
			<th>名前
			<th>価格
		<tr>
			<td><c:out value="${productForm.name }" />
			<td>${productForm.price }
	</table>
</body>
</html>