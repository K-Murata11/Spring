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

	<c:out value="${massage}"></c:out>

	<table>
		<form:form modelAttribute="userInfoForm">
			<tr>
				<td>名前</td>
				<td><form:input path="name" placeholder="名前を入力してください" /> <form:errors
						path="name" cssStyle="color:red;" /></td>
			</tr>
			<tr>
				<td>年齢</td>
				<td><form:input path="age" /> <form:errors path="age"
						cssStyle="color:red;" /></td>
			</tr>
			<tr>
				<td>性別</td>
				<td><form:radiobuttons path="gender" items="${genders}" /></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><form:input path="email" />
					<form:errors path="email" cssStyle="color:red;" /></td>
			</tr>
			<tr>
				<td>出身地</td>
				<td><form:select path="birthplace" items="${birthpraces}"
						multiple="false" /></td>
			</tr>
			<tr>
				<td>好きな言語</td>
				<td><form:checkboxes path="favoriteLangs" items="${langs}" /></td>
			</tr>
			<tr>
				<td>備考</td>
				<td><form:textarea path="texts" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="送信" /></td>
			</tr>
		</form:form>


		<!-- リストの中身が空でなければ、下記情報を表示する -->
		<c:if test="${not empty userInfoList}">

			<table border="1">
				<tr>
					<th>名前</th>
					<th>年齢</th>
					<th>性別</th>
					<th>出身地</th>
					<th>言語</th>
					<th>備考</th>
				</tr>

				<!-- 拡張for文を利用し、userInfoListの中身を一件ずつ参照する。
					  その際、n件目の情報の塊をuserinfoFormと名付ける -->
				<c:forEach var="userInfoForm" items="${userInfoList}">

					<tr>
						<!-- userIngoFormの中から各情報を取り出す
							  （恐らくFormに対応した変数名？　もしくは入力のpath？） -->
						<td><c:out value="${userInfoForm.name}" /></td>
						<td><c:out value="${userInfoForm.age}" /></td>
						<td><c:out value="${userInfoForm.gender}" /></td>
						<td><c:out value="${userInfoForm.email}" /></td>
						<td><c:out value="${userInfoForm.birthplace}" /></td>
						<td><c:out value="${userInfoForm.favoriteLangs}" /></td>
						<td><c:out value="${userInfoForm.texts}" /></td>
					</tr>

				</c:forEach>
				<!-- 拡張for文ここまで -->

			</table>
		</c:if>
	</table>
</body>
</html>