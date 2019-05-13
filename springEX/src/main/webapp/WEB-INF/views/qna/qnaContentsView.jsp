<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.test.board.dto.Employee"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	Employee employee = (Employee) session.getAttribute("auth_id");
	boolean login = (employee == null) ? false : true;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<input type="hidden" name="qCode" value="${contentsView.qCode }">
		<tr>
			<td>id</td>
			<td>${contentsView.qCode }</td>
		</tr>
		<tr>
			<td>name</td>
			<td>${contentsView.qName }</td>
		</tr>
		<tr>
			<td>email</td>
			<td>${contentsView.qEmail }</td>
		</tr>
		<tr>
			<td>phone</td>
			<td>${contentsView.qPhone }</td>
		</tr>
	</table>
	<input type="hidden" name="${replyView.aCode }">
	<h4>reply</h4>
	<h4>${replyView.aAnswer }</h4>
	<h6>---------------</h6>
	<h3>reply wite</h3>
	<form action="qnaReply" method="POST">
		<input type="hidden" name="emCode" value="${auth_id.emCode}">
		<input type="hidden" name="qCode" value="${contentsView.qCode }">

		<textarea rows="" cols="" name="reply" placeholder="wirte reply"></textarea>
		<input type="submit" value="submit">
	</form>

</body>
</html>