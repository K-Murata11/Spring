<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSSレイアウトが不要な場合は8行目をコメントアウトしてください -->
<link rel="stylesheet" href='<c:url value="/css/search.css"/>'>
<title>更新画面</title>

<style type="text/css">
<!--

/* タイトル */
h1 {
	padding: 0.4em 0.5em; /*文字の上下 左右の余白*/
	color: #494949; /*文字色*/
	background: #f4f4f4; /*背景色*/
	border-left: solid 5px #7db4e6; /*左線*/
	border-bottom: solid 3px #d7d7d7; /*下線*/
}
/* テーブル */
th {
	width: 40%;
}

td {
/* 	width: 20%; */
	height: 60px;
}

table {
	width: 40%;
	height: 80px;
}
/* 変更・戻るボタン */
/* .submit { */
/* 	position: relative; */
/* 	display: inline-block; */
/* 	padding: 0.25em 0.5em; */
/* 	text-decoration: none; */
/* 	color: #FFF; */
/* 	background: #03A9F4; /*色*/ */
/* 	border: solid 1px #0f9ada; /*線色*/ */
/* 	border-radius: 4px; */
/* 	box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2); */
/* 	text-shadow: 0 1px 0 rgba(0, 0, 0, 0.2); */
/* } */
/* .submit:active { */
/* 	border: solid 1px #03A9F4; */
/* 	box-shadow: none; */
/* 	text-shadow: none; */
/* } */
-->

</style>

<!---------- ユーザ情報更新 確認アラート ------------>
<script type="text/javascript">
	function updateDisp() {
		if (window.confirm('変更します。よろしいですか?')) {
			window.alert('ユーザ情報を変更しました');
			return true;
		} else {
			window.alert('キャンセルしました');
			return false;
		}
	}
</script>

</head>
<body>
	<div align="center">
		<h1>ユーザ更新画面</h1>
		<b><c:out value="${message}"></c:out></b>

		<!---------- userIdをパラメータとしてUpdateControllerへ ----------->

		<form:form modelAttribute="updateForm">
			<input type="hidden" name="userId" value="${userId}">
			<%-- <input type="hidden" name="admin" value="${admin}"> --%>
			<table>
				<tr>
					<th align="left" class="acount" height="60px"><img src="./image/smallHuman.png">アカウント</th>
					<th align="left" style="color: #ff0000">※全て必須項目です</th>
				</tr>
				<tr>
				</tr>
				<tr>
					<td align="left"><img src="./image/userName.png">ユーザ名</td>
					<td><form:input size="50" path="user_name" placeholder="山田 太郎" />
					<form:errors path="user_name" cssStyle="color:red"></form:errors></td>
				</tr>
				<tr>
					<td align="left"><img src="./image/pass.png">パスワード</td>
					<td><form:input size="50" path="user_pass" placeholder="6文字以上" />
						<form:errors path="user_pass" cssStyle="color:red"></form:errors>
					</td>
				</tr>
				<tr>
					<td align="left"><img src="./image/mail.png">	E-mail</td>
					<td><form:input size="50" path="user_mail"
							placeholder="t.yamda@good-works.co.jp" />
							<form:errors path="user_mail" cssStyle="color:red"></form:errors>
							</td>
				</tr>
			</table>
           <!----------------- シンプルなテーブル --------------------->
             <!-- <table> -->
			<!-- ユーザ名<br> -->
			<%-- 			<form:input  path="user_name" /> --%>
			<!-- 			<br><br> -->
			<!-- パスワード<br> -->
			<%-- 			<form:input path="user_pass" /> --%>
			<!-- 			<br><br> -->
			<!-- E-mail<br> -->
			<%-- 			<form:input path="user_mail" /> --%>
			<!-- 			<br> -->
			<!-- 			<br> -->
			<!-- 			<br> -->
             <!--</table> -->
			<input type="submit" value="保存" onclick="return updateDisp();">
		</form:form>

		<!----------actionタグによりSearchControllreのGETへ--------------->
		<form action="http://localhost:8080/lesson/search">
			<input type="submit" value="戻る">
		</form>
	</div>
</body>
</html>
