<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../comm/header.jsp"></jsp:include>

<div class="login-page page fix"><!--start login Area-->
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-5">
				<div class="login">
					<form id="login-form" action="/loginChk" >
						<h2>Login</h2>
						<p>Welcome to your account</p>
<!-- 							페이스북 / 트위터 계정 연결 -->
<!-- 						<div class="social-login"> -->
<!-- 							<a id="facebook" href="#"><i class="fa fa-facebook"></i>Sign In with Facebook</a> -->
<!-- 							<a id="twitter" href="#"><i class="fa fa-twitter"></i>Sign In with Twitter</a> -->
<!-- 						</div> -->
						<label>ID<span>*</span></label>
						<input type="text" name="userId" />
						<label>Password<span>*</span></label>
						<input type="password" name="userPw"/>
						<div class="remember">
							<input type="checkbox" />
							<p>Remember me!</p>
							<a href="#">Forgot Your Password ?</a>
						</div>
						<p><input type="submit" value="login" /></p>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!--End login Area-->

<BR><BR><BR><BR>
<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>