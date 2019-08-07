<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style type="text/css">
<!-- 
h1{
padding: 0.4em 0.5em;/*文字の上下 左右の余白*/
color: #494949;/*文字色*/
background: #f4f4f4;/*背景色*/
border-left: solid 5px #7db4e6;/*左線*/
border-bottom: solid 3px #d7d7d7;/*下線*/
}
-->
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSSレイアウトが不要な場合は21行目をコメントアウトしてください -->
<link rel="stylesheet" href='<c:url value="/css/search.css"/>'>

 <!---------- ユーザ削除 確認アラート ------------>
<script type="text/javascript">
	function deleteDisp() {
		if (window.confirm('ユーザを削除しますか?')) {
			window.alert('ユーザを削除しました');
			return true;
		} else {
			window.alert('キャンセルされました');
			return false;
		}
	}
</script>

<title>一覧画面</title>
</head>

<body>

	<div align="center">
		
		<h1>ユーザ一覧画面</h1>
		
		<b><c:out value="${message}"></c:out></b>
		
       <!------------------- テキストボックスから検索 -------------------->
		<form:form name="form" modelAttribute="searchForm" >
			<form:input  size="35" path="sqlLike" placeholder="名前を入力してください" name="sqlLike" />
			<input type="submit" value="検索" name="buttun" class="textSubmit">
		</form:form>
		
		 <!------------------- 登録画面へ遷移 -------------------->
		<form action="http://localhost:8080/lesson/useradd">
			<input type="submit" class="submit" value="ユーザ登録画面へ">
		</form>
		 <!------------------- 全ユーザを表示 -------------------->
			<c:if test="${not empty searchList}">
			<c:out value="${count}"></c:out>
				<table class="table01">
					<tr>
						<th>userID</th>
						<th>名前</th>
						<th>E-mail</th>
						<th>password</th>
						<th>管理者権限</th>
						<th>作成日</th>
						<th>更新日</th>
						<th>ユーザ管理</th>
					</tr>
					<c:forEach var="searchForm" items="${searchList}">
			
						<form:form modelAttribute="searchForm">
							<tr>
								<td align="center"><c:out value="${searchForm.user_id}"></c:out>
								<td><c:out value="${searchForm.user_name}"></c:out>
								<td><c:out value="${searchForm.user_mail}"></c:out>
								<td><c:out value="${searchForm.user_pass}"></c:out>
								<td align="center"><c:out value="${searchForm.admin}"></c:out>
								<td><c:out value="${searchForm.create_date}"></c:out>
								<td><c:out value="${searchForm.last_update}"></c:out>
						</form:form>
						<td align="center">
						
							<div align="center" class="divbuttun">
		           
		           <!--  hiddenによりパラメータ送信
		                  SearchControllerのPOSTに遷移 
		                   @RequsetParam("delete")を利用
		                                                 -->
								<br>
								<form:form modelAttribute="searchForm" style="display:inline">
									<input type="hidden" name="delete" value="${searchForm.user_id}">
													  <!-- JavaScriptを利用 -->
									<input type="submit" value="削除" name="delete" class="submit" onclick="return deleteDisp();">
								</form:form>
							

					          <!-----------form actionタグによりUpdateControllerのGETに遷移 ------------->
								<form action="http://localhost:8080/lesson/update" style="display:inline">
								<!-----------hiddenタグを利用し、SQL文に必要な値をパラメータとして送信 ------------->
									<input type="hidden" name="updateId" value="${searchForm.user_id}">
                                <%--<input type="hidden" name="updateadmin" value="${searchForm.admin}"> --%>
								    <input type="hidden" name="updateName" value="${searchForm.user_name}">
								    <input type="hidden" name="updatePass" value="${searchForm.user_pass}">
								    <input type="hidden" name="updateMail" value="${searchForm.user_mail}">
								    <input type="submit" value="更新" class="submit">
								</form>
							</div>
						
						</td>
					
					</c:forEach>
				
				</table>
			
			</c:if>
	</div>

</body>
</html>

