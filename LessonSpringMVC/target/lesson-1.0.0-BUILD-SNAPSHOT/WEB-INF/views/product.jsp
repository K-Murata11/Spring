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
	名前<form:input path="name" placeholder="名前を入力してください" />
		<form:errors path="name" cssStyle="color:red;" />
		<br>
	価格<form:input path="price" placeholder="0" />
		<form:errors path="price" cssStyle="color:red;" />
		<br>
		<input type="submit" value="送信" />
		<br>
	</form:form>

	<c:if test="${not empty productList}">
		<table border="1">
			<tr>
				<th>名前</th>
				<th>価格</th>
			</tr>
			<c:forEach var="productForm" items="${productList}">
				<tr>
					<td><c:out value="${productForm.name}" /></td>
					<td><c:out value="${productForm.price}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
