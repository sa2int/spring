<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
	    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> 
	
<title>Insert title here</title>
<style>
<style>
		@import url("http://fonts.googleapis.com/earlyaccess/nanumgothic.css");
		* {
    margin: 0 auto;
    padding: 0px;
}
	html {
		height: 100%;
	}
	
	body {
	    width:100%;
	    height:100%;
	    margin: 0;
  		padding-top: 80px;
  		padding-bottom: 40px;
  		font-family: "Nanum Gothic", arial, helvetica, sans-serif;
  		background-repeat: no-repeat;
  		background:linear-gradient(to bottom right, #f5f5f5, #6BA8D1);
	}
	
    .card {
        margin: 0 auto; /* Added */
        float: none; /* Added */
        margin-bottom: 10px; /* Added */
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	}
	
	.form-signin .form-control {
  		position: relative;
  		height: auto;
  		-webkit-box-sizing: border-box;
     	-moz-box-sizing: border-box;
        	 box-sizing: border-box;
  		padding: 10px;
  		font-size: 16px;
	}
</style>
</head>
<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

<div class="card align-middle" style="width:40rem; border-radius:20px;">
	<form action="changePwPro" method="POST">
		<table class="table table-bordered table-hover">
			<caption class="card-title text-center" style="margin-top:30px; color:#113366;"><h2>Change Password</h2></caption>
			<tr>
				<!-- <td>name</td> -->
				<td><input type="text" class="form-control" name="emName" placeholder="NAME"/></td>
			</tr>
			<tr>
				<!-- <td>email</td> -->
				<td><input type="text" class="form-control" name="emNum" placeholder="employee number"/></td>
			</tr>
			<tr>
				<!-- <td>phone</td> -->
				<td><input type="text" class="form-control" name="emNewPw" placeholder="PASSWORD"/></td>
			</tr>
			<tr>
				<!-- <td>phone</td> -->
				<td><input type="text" class="form-control" name="emNewPwChk" placeholder="PASSWORD CHECK"/></td>
			</tr>
			<tr>
				<td><input type="submit" id="btn-Yes" class="btn btn-lg btn-primary btn-block" name="submit" value="NEXT" /> <input
					type="reset" id="btn-Yes" class="btn btn-lg btn-primary btn-block" name="reset" value="CANCEL" /></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>