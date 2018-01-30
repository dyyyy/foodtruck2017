<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	jQuery(function($) {

		// var id = /^[a-z0-9_-]{3,16}$/; // 아이디 검사식
		var id = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
		var pw = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,15}$/; // 비밀번호 검사식
		var tel = /^[0-9]{8,11}$/; // 전화번호 검사식

		var form = $('.insertFoodTruck'), licenseNo = $('input[name="licenseNo"]'), ftruckName = $('input[name="ftruckName"]'), ftruckTel = $('input[name="ftruckTel"]');
		
		$('#checkNo').after(
				'<p></p>');

		// 아이디 중복 체크
		$("#checkNo").click(
				function() {
					$.ajax({
						url : '/licenseNoCheck',
						type : 'get',
						data : licenseNo.serialize(),
						success : function(getId) {
							if (licenseNo.val() == ""
									|| id.test(licenseNo.val()) != true) {
								alert("사업자 번호를 확인해 주세요.");
							} else if ($.trim(getId) == 0) {
								alert("사용 가능한 번호 입니다.");
								$("#checkNo").attr("result", "checked");
								$("#checkNo").css("display", "none");
								$("#comform").css("display", "inline");
							} else {
								alert("이미 사용하고 있는 번호 입니다.");
							}
						},
					});
				});
		
	});
</script>
</head>


<body>
<%@include file="../comm/header2.jsp" %>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span9" id="content">
				<!-- morris stacked chart -->
				<div class="row-fluid">
					<!-- block -->
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<div class="muted pull-left">푸드트럭 등록</div>
						</div>
						<div class="block-content collapse in ins">
						<form id="signup-form" action="/insertFoodTruck" method="post" class="insertFoodTruck">
							<!-- 사업자번호 -->
							<label>사업자번호<span>*</span></label> 
							<input type="text" name="licenseNo"> 
							<input type="button" id="checkNo" value="중복확인" result="unchecked" style="display: inline;">
							<!-- 푸드트럭 명 -->
							<label>이름<span>*</span></label> 
							<input type="text" name="ftruckName">
							<!-- 휴대폰 번호  -->
							<label>Phone Number<span>*</span></label> 
							<input type="text" name="ftruckTel"> 
							<input type="button" id="checkTel" value="인증하기">
							<!-- 주소 -->
							<label>주소<span>*</span></label>
							<input type=text name=ftruckAddr readonly> <input type=button value="주소검색"><p>
							<input type=text name=ftruckAddr2>
							<p>
							<br> <br>

							<!-- 푸드트럭 소개 -->
							<label>소개</label>
							<textarea name=ftruckIntro rows="7"></textarea><p>
							
							<label>배달여부</label>
							<input type=radio name=ftruckDlvYn value="Y" checked>Y
							<input type=radio name=ftruckDlvYn value="N">N<p>
							<label>예약여부</label>
							<input type=radio name=ftruckRsvYn value="Y"checked>Y
							<input type=radio name=ftruckRsvYn value="N">N<p>
							<label>운영여부</label>
							<input type=radio name=ftruckState value="Y" checked>Y
							<input type=radio name=ftruckState value="N">N<p>
							
							<label>카테고리</label><p>
							<select name=category>
								<option value="1">한식</option>
								<option value="2">중식</option>
								<option value="3">양식</option>
								<option value="4">일식</option>
							</select>
							
							<label>파일첨부</label>
							<input type=file name=ftruckImg>
							
							
							
							<p>
								<input type="reset" value="Reset"> <input type="submit"
									value="Sign up">
							</p>
						</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
						
						<!-- 
						<div class="block-content collapse in ins">
							사업자번호
							<input type=text name=ftruckLicenseNo>
							<input type=button value=중복확인>
							푸드트럭 명
							<input type=text name=ftruckName>
							전화번호
							<input type=text name=ftruckTel>
							주소
							<input type=text name=ftrudkAddress1>
							<input type=text name=ftrudkAddress2>
							소개
							<textarea name=ftruckIntro></textarea>
							배달여부
							<input type=radio>Y
							<input type=radio>N
							예약여부
							<input type=radio>Y
							<input type=radio>N
							운영여부
							<input type=radio>Y
							<input type=radio>N
							카테고리
							<select name=category>
								<option>test1</option>
								<option>test2</option>
								<option>test3</option>
							</select>
							파일첨부
							<input type=file name=ftrudkImg>
						
						</div>
						 -->
						


</body>
</html>