<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		<c:out value="${message}" />

	</p>

	<c:if test="${not empty productList}">
		<table border="1">
			<tr>
				<th>名前</th>
				<th>価格</th>
			</tr>
			<c:forEach var="productForm" items="${productList}">
				<tr>
					<td><c:out value="${productForm.name}"></c:out></td>
					<td><c:out value="${productForm.price}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
		<br>
	</c:if>

	<form:form modelAttribute="productForm">
	名前<form:input path="name" placeholder="名前を入力してください" />
		<form:errors path="name" cssStyle="color:red"></form:errors>
		<br />
	価格<form:input path="price" placeholder="0" />
		<form:errors path="price" cssStyle="color:red"></form:errors>
		<br />
		<input type="submit" value="送信">
		<br />
	</form:form>

</body>
</html>