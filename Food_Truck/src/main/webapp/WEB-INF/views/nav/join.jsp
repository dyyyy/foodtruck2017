<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style type=text/css>
.test {
	color:red;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
jQuery( function($) { 

	// var id = /^[a-z0-9_-]{3,16}$/; // 아이디 검사식
	var id = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
	var pw = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,15}$/; // 비밀번호 검사식
	var tel = /^[0-9]{8,11}$/; // 전화번호 검사식
	
	var	form = $('.form'), 
			memberId = $('input[name=memberId]'), 
			memberPw = $('input[name=memberPw]'),
			memberPw1 = $('input[name=memberPw1]'),
			memberName = $('input[name=memberName]'), 
			memberTel = $('input[name=memberTel]');
		

	// 전송 버튼을 눌렀을 시 유효성 체크
	form.submit( function() {
		if (memberId.val() == "" || id.test(memberId.val()) != true) {
			alert('아이디를 확인해 주세요.');
			memberId.focus();
			return false;
		} else if(memberPw.val() == "" || pw.test(memberPw.val()) != true || memberPw.val() != memberPw1.val()) {
			alert('비밀번호를 확인해 주세요.');
			memberPw.focus();
			return false;
		} else if(memberName.val() == "") {
			alert('이름을 입력해 주세요.');
			memberName.focus();
			return false;
		} else if(memberTel.val() == "") {
			alert("휴대폰번호를 입력해 주세요.");
			memberTel.focus();
			return false;
		} else if($('input[name=agree1]').is(":checked") != true || $('input[name=agree2]').is(":checked") != true) {
			alert("이용약관 동의를 해야합니다.");
			return false;
		}
	});
	
	
	$('#checkId, input[name=memberPw], input[name=memberPw1]').after('<p></p>');
 
 	// 아이디 체크
 	memberId.keyup(function() {
 		var s = $("#checkId").next('p');
 		if(id.test(memberId.val()) != true) {
 			s.text("이메일 형식이 맞지 않습니다.").css("color", "red");	
 		} else {
 			s.text(" ");
 		}
 	});
 	
 	
	// 비밀번호 체크
	memberPw.keyup( function() {
		var s = $(this).next('p'); 
		if (memberPw.val().length == 0) { // 입력 값이 없을 때
			s.text('비밀번호를 입력해 주세요.'); 
		} else if(pw.test(memberPw.val()) != true) {
			s.text('비밀번호는 최소 8자리의 영문 및 숫자를 포함해야 합니다.').css("color", "red");
		} else { 
			s.text('사용 가능한 비밀번호 입니다.').css("color", "gray"); 
		}
	});
	
	
	// 비밀번호 확인 체크
	memberPw1.keyup(function() {
		var s = $(this).next('p');
		// 입력한 비밀번호와 다를 때
		if(memberPw.val() != memberPw1.val()) {
			s.text('입력하신 비밀번호와 다릅니다.').css("color", "red");
		} else {
			s.text("ok").css("color", "gray");
		}
	});
	
	
/* 
	// 휴대폰번호 체크
	memberTel.keydown( function() {
		if(event.keyCode==109 || event.keyCode==189) {
			return false;
		}
	});
 */	
 
	// 이용 약관 불러오기
	$("textarea[name=textarea]").load("test1.txt");
	
	
});
</script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../comm/header.jsp"></jsp:include>
<body>
<form class="form">
<table border=1>
	<tr>
		<td><b class=test>*</b>아이디(이메일 입력)</td>
		<td>
			<input type=text name=memberId>
			<button id=checkId>중복확인</button>
		</td>
	</tr>
	<tr>
		<td><b class=test>*</b>비밀번호</td>
		<td><input type=password name=memberPw></td>
	</tr>
	<tr>
		<td><b class=test>*</b>비밀번호확인</td>
		<td><input type=password name=memberPw1></td>
	</tr>
	<tr>
		<td><b class=test>*</b>이름</td>
		<td><input type=text name=memberName></td>
	</tr>
	<tr>
		<td><b class=test>*</b>휴대폰 번호</td>
		<td>
			<input type=text name=memberTel>
			<button id=checkTel>휴대폰인증</button>
		</td>
	</tr>
	<tr>
		<td>이벤트 정보 수신 동의</td>
		<td>
			<input type=checkbox name=checkSNS>SNS
			<input type=checkbox name=checkEmail>Email
		</td>
	</tr>
	
	<tr>
		<td rowspan=4><b class=test>*</b>이용약관</td>
	</tr>
	<tr>
		<td>
			<textarea name=textarea></textarea><p>
			<input type=checkbox name=agree1 check=unchecked>동의
		</td>
	</tr>
	<tr>
		<td><textarea name=textarea></textarea><p>
		<input type=checkbox name=agree2 check=unchecked>동의
		</td>
	</tr>
	
	
	
</table>
<input type=submit value=전송><input type=reset value=다시작성>
</form>
</body>
<jsp:include page="../comm/footer.jsp"></jsp:include>
</html>