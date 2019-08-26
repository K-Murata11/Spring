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
	<c:out value="${message}"></c:out>
	<!-- リストの中身が空でなければ、下記情報を表示する -->
	<c:if test="${not empty searchInfoList}">

		<table border="1">
			<tr>
				<th>乗車駅</th>
				<th>発車時刻</th>
				<th>降車駅</th>
				<th>到着時刻</th>
			</tr>

			<!-- 拡張for文を利用し、userInfoListの中身を一件ずつ参照する。
					  その際、n件目の情報の塊をuserinfoFormと名付ける -->
			<c:forEach var="searchInfoForm" items="${searchInfoList}">

				<tr>
					<td><c:out value="${searchInfoForm.startStation}" /></td>
					<td><c:out value="${searchInfoForm.startHhmi}" /></td>
					<td><c:out value="${searchInfoForm.endStation}" /></td>
					<td><c:out value="${searchInfoForm.endHhmi}" /></td>
				</tr>

			</c:forEach>
			<!-- 拡張for文ここまで -->
			<form:form>
				<tr>
					<td colspan="2"><input type="submit" name="back" value="戻る"></td>
					<td colspan="2"><input type="submit" name="logout" value="ログアウト"></td>
				</tr>
			</form:form>
		</table>
	</c:if>

</body>
</html>