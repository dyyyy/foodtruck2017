<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type=text/css>
.login input {
	color: red;
}

#frm {
	padding-left: 200px;
}
h1 {
	padding-left: 220px;
}

.btnEdit {
	margin-left: 130px;
}
</style>
<jsp:include page="../comm/header.jsp"></jsp:include>
<%@include file="../comm/nav.jsp"%>
<body>
	<!--start create member Area-->
	<div class="login-page page fix">
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-md-3">
					<div class="single-sidebar">
						<h2>내 정보</h2>
						<ul align="center">
							<li><a href="/memberInfo">회원 정보</a></li>
							<li><a href="/memberOrderInfo">주문 내역</a></li>
							<li><a href="/memberQaInfoList">문의 내역</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6 col-md-5">
					<div class="join">
							<h1> 회원 정보 </h1>
						<form id="frm" action="/memberInfoUpdate" method="post" class="joinForm">
							<!-- 이메일 (id) -->
							<label>ID<span>*</span></label>
							<input type="text" name="memberId" value="${memberInfo.memberId}" readonly="readonly">
							<!-- Pw -->
							<label>PW<span>*</span></label>
							<input type="password" name="memberPw" value="">
							<!-- 이름 -->
							<label>Name<span>*</span></label> 
							<input type="text" name="memberName"  value="${memberInfo.memberName}">
							<!-- 휴대폰 번호  -->
							<label>Phone Number<span>*</span></label>
							<input type="text" name="memberTel" value="${memberInfo.memberTel}">
							<br> <br>
							<!-- 버튼 -->
							<input type="submit" value="수정" class="btnEdit">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--End create member Area-->
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
<%@include file="../comm/footer.jsp"%>
</html>