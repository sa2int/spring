<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="com.test.board.dto.Employee"%>
<%
	Employee employee = (Employee) session.getAttribute("auth_id");
	boolean login = (employee == null) ? false : true;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.2.0.min.js"></script>

<title>Insert title here</title>
<style>
tr {
	list-style: none;
	margin-left: 0;
}

display:inline-block

tr>td {
	color: #fff;
	text-decoration: none;
	/* display: block; */
	padding: 5px 10px;
	background-color: #888;
}

navbar {
	border: 1px solid red;
}

.menu a	{
	width: 100%;
	display: flex;
	justify-content: space-around;
}

table {
  
  border-bottom: 10px;
  border-collapse: separate;
}


input:focus, textarea:focus{     outline: none; }


	
ul {
	list-style: none;
	margin-left: 0;
}

ul>li {
	display: inline-block;
}

ul>li>a {
	color: #fff;
	text-decoration: none;
	display: block;
	padding: 5px 10px;
	background-color: #888;
}
body {
	padding: 10px;
}
</style>


</head>
<body>
	<h1 id="hh">List1111</h1>
	<%
		if (employee != null) {
	%>
	<h4>${auth_id.emName }</h4>
	<h5><a href="logout">logout</a></h5>
	<%
		} else {
	%>
	<h5>no login you need login</h5>
	<%
		}
	%>
	<div class="container">
		<ul class="nav nav-pills nav-fill">
			<li id="aa"class="menu nav-item"><a class=" nav-link active" href="qnaList">QnA List</a></li>
			<li class="menu nav-item"><a class=" nav-link" href="qnaResponding2?stCode=1">No reply</a></li>									
			<li class="menu nav-item"><a class=" nav-link" href="qnaResponding?stCode=2&emCode=${auth_id.emCode }">Resoponding</a></li>
			<li class="menu nav-item"><a class=" nav-link" href="qnaResponding?stCode=3&emCode=${auth_id.emCode }">Complete</a></li>
		</ul>
	</div>
	<div class="container">
		<table class="table table-bordered table-hover">
			<tr>
				<td>number</td>
				<td>name</td>
				<td>product</td>
				<td>Contents</td>
				<td>Regist Time</td>
				<td>state</td>
				<td>detail</td>
			</tr>
			<c:forEach items="${list }" var="dto">
				<tr>
					<td><a href="contentsView?qcode=${dto.qcode }">${dto.qcode }</a></td>
					<td>${dto.qname }</td>
					<td>${dto.pdName }</td>
					<td> <c:choose>
							<c:when test="${fn:length(dto.qcontents) > 14}">
								<c:out value="${fn:substring(dto.qcontents,0,13)}" />....
           					</c:when>
							<c:otherwise>
								<c:out value="${dto.qcontents}" />
							</c:otherwise>
						</c:choose> </td>
					<td>${dto.qregistTime }</td>
					<td>
						<form action="buttonState" method="post">
							<ul>
								<li>${dto.stCode }</li>
								<li><input type="hidden" name="emCode" value="${auth_id.emCode}"></li>
								<li><input type="hidden" name="qCode" value="${dto.qcode}"></li>
								<li><button type="submit" id=aa class="button"
										name="stCode" value="1">button</button></li>
								<li><button type="submit" class="button btn btn-primary"
										name="stCode" value="2">button</button></li>
								<li><button type="submit" class="button" name="stCode"
										value="3">button</button></li>
							</ul>
						</form>
					</td>
					<td><span class="glyphicon glyphicon-plus plusIcon" id="viewhidden" onclick="return false;"></span> <span
						class="glyphicon glyphicon-minus plusIcon" style="display: none"></span>
					</td>
				</tr>
				<tr class="aaa" style="display: none">
					<td></td>
					<td>Email</td>
					<td>Phone</td>
					<td rowspan="2">Contents</td>
					<td rowspan="2" colspan="3">
						${dto.qcontents }
					</td>
				</tr>
				<tr style="display: none">
					<td></td>
					<td>${dto.qemail}</td>
					<td>${dto.qphone}</td>					
				</tr>
				<tr id="answer" style="display: none">
					<td>comment complete</td>
					<td colspan="6">${dto.aanswer }
					</td>
				</tr> 
				<tr style="display: none">
				<form action="qnaReply" method="POST">
				<td></td>
				<td>Commnet</td>
				<td colspan="4">
					<input type="hidden" name="emCode" value="${auth_id.emCode}">
					<input type="hidden" name="qCode" value="${dto.qcode }">
					<textarea rows="5" name="reply" cols="120" style="width:100%; border: 0;"></textarea>
				</td>
				<input type="hidden" name="qemail" value="${dto.qemail }">
				<input type="hidden" name="title" value="no-reply[QnA案内]${dto.qname }から頂いた質問の答え">
				<td >
					<input type="submit" value="submit">
				</td>			
				</form>
				</tr>
			</c:forEach>
		</table>
	</div>
		<script type="text/javascript">
		$(".plusIcon").on("click", function() {
			var obj = $(this);
			if (obj.hasClass("glyphicon-plus")) {
				obj.hide();
				obj.next().toggle('slow');
				obj.parent().parent().next().toggle('slow');
				obj.parent().parent().next().next().toggle('slow');
				obj.parent().parent().next().next().next().toggle('slow');
				obj.parent().parent().next().next().next().next().toggle('slow');
			} else {
				obj.hide();
				obj.prev().show();
				obj.parent().parent().next().hide();
				obj.parent().parent().next().next().hide();
				obj.parent().parent().next().next().next().hide();
				obj.parent().parent().next().next().next().next().hide();
			}
		});
	</script>
</body>
</html>