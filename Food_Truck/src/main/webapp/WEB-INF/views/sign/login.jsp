<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../comm/header.jsp" %>

<div class="login-page page fix"><!--start login Area-->
	<div class="container">
		<div class="row2">
			<div class="col-sm-6 col-md-5">
				<div class="login">
					<form id="login-form" action="/login" method="post">
						<h2>Login</h2>
						<p>Welcome to your account</p>
<!-- 							페이스북 / 트위터 계정 연결 -->
<!-- 						<div class="social-login"> -->
<!-- 							<a id="facebook" href="#"><i class="fa fa-facebook"></i>Sign In with Facebook</a> -->
<!-- 							<a id="twitter" href="#"><i class="fa fa-twitter"></i>Sign In with Twitter</a> -->
<!-- 						</div> -->
						<label>ID<span>*</span></label>
						<input type="text" name="id" />
						<label>Password<span>*</span></label>
						<input type="password" name="pw"/>
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