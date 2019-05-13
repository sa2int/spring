<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width" , initial-scale="1.0">

<link rel="stylesheet" href="css/bootstrap.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">



<title>Insert title here</title>

</head>

<body>



	<nav class="navbar navbar-default">

		<div class="naver-header">

			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">


				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>


			</button>

			<a class="navbar-brand" href="main.jsp">JSP 게시판 웹 사이트</a>

		</div>


		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<ul class="nav navbar-nav">

				<li><a href="main.jsp">메인</a>
				<li><a href="bbs.jsp">게시판</a>
			</ul>

			<ul class="nav navbar-nav navbar-right">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span></a>


					<ul class="dropdown-menu">

						<li class="active"><a href="login.jsp">로그인</a></li>

						<li><a href="join.jsp">회원가입</a></li>

					</ul></li>

			</ul>

		</div>

	</nav>


	<div class="container">

		<div class="col-lg-4"></div>

		<div class="col-lg-4">

			<div class="jumbotron" style="padding-top: 20px;">

				<form method="post" action="signUpInput">

					<h3 style="text-align: center">Sign up</h3>

					<div class="form-group">

						<input type="text" class="form-control" placeholder=name
							name="emName" maxlength="20">

					</div>

					<div class="form-group">

						<input type="text" class="form-control" placeholder="password"
							name="emPw" maxlength="20">

					</div>

					<div class="form-group">

						<input type="text" class="form-control" placeholder="commpany number"
							name="emNum" maxlength="20">

					</div>
					<div class="form-group">

						<input type="submit" class="form-control btn btn-primary" value="submit"
							 maxlength="20">
						<input type="reset" class="form-control btn btn-primary" value="reset"
							 maxlength="20">	 

					</div>
				
						
						
						</form>
						</div>
						</div>
						</div>	
							
</body>
</html>