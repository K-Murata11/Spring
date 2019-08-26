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
	<h2>${message}</h2>
	<h2>現在時刻は ${nowDateTime} です</h2>
	<table>
		<form:form modelAttribute="searchForm">
			<tr>
				<td>乗車駅</td>
				<td><form:input path="startStation" /> &nbsp;　<form:errors path="startStation"
						cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>降車駅</td>
				<td><form:input path="endStation" /> &nbsp;　<form:errors path="endStation"
						cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:input type="date" path="yyyymmdd" value="${nowDate}"/> <form:input
						type="time" path="hhmi" value="${nowTime}"/> に <form:select path="startEnd"
						items="${startEnd}" multiple="false" /></td>
			</tr>
			<tr>
				<td><form:errors path="yyyymmdd" cssStyle="color:red" /> <form:errors
						path="hhmi" cssStyle="color:red" /></td>
			<tr>
				<td colspan="2"><input type="submit" value="検索"></td>
			</tr>
		</form:form>
	</table>

</body>