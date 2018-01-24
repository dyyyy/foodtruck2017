<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="../comm/header.jsp"></jsp:include>
<%@include file="../comm/nav.jsp"%>
<head>
<script>

$(function() {
	$(".btnEdit").click(function() {
		
		var memberPw = $('input[name="memberPw"]')
		var check = prompt("비밀번호를 입력하세요")
		if(check == memberPw.val()) {
			frm.action = "/memberInfoUpdateGet"
			frm.method = "POST"
			frm.submit()
		}else{
			alert("정보가 틀렸습니다.")
			return false;
		}
		
	})
})	
</script>

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
</head>
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
							<li><a href="#">예약 내역</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6 col-md-5">
					<div class="join">
							<h1> 회원 정보 </h1>
						<form id="frm" action="/join" method="post" class="joinForm">
							<!-- 이메일 (id) -->
							<label>ID<span>*</span></label>
							<input type="text" name="memberId" readonly="readonly" value="${memberInfo.memberId}">
							<!-- 비밀번호 hidden -->
							<input type="hidden" name="memberPw" value="${memberInfo.memberPw}">
							<!-- 이름 -->
							<label>Name<span>*</span></label> 
							<input type="text" name="memberName" readonly="readonly" value="${memberInfo.memberName}">
							<!-- 휴대폰 번호  -->
							<label>Phone Number<span>*</span></label>
							<input type="text" name="memberTel" readonly="readonly" value="${memberInfo.memberTel}">
							<br> <br>
							<!-- 버튼 -->
							<input type="button" value="수정" class="btnEdit">
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
	<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>