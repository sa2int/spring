<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	RequestDispatcher dispatcher = request.getRequestDispatcher("qnaForm.jsp");
	dispatcher.forward(request, response);

%> 
<H1>index</H1>
</body>
</html>