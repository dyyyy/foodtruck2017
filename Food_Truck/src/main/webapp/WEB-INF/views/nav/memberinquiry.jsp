<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<jsp:include page="../comm/header.jsp"></jsp:include>
<script src="//code.jquery.com/jquery-1.11.0.min.js"
	type="text/javascript"></script>

<script type="text/javascript">
function itemChange(){
	 
	var info = ["가입/탈퇴","정보확인/수정"];
	var pay = ["주문/거래확인","영수증","카드결제","무통장입금"];
	var deliver = ["배달진행상태","배달지연/누락"];
	var cancel = ["취소 환불정보","취소 신청/철회"];
	var event = ["이벤트문의","기타"];
	 
	var selectItem = $("#select1").val();
	 
	var changeItem;
	  
	if(selectItem == "고객정보"){
	  changeItem = info;
	}
	else if(selectItem == "주문/결제"){
	  changeItem = pay;
	}
	else if(selectItem == "배송/예약"){
	  changeItem =  deliver;
	}
	else if(selectItem == "취소"){
	  changeItem =  cancel;
	}
	else if(selectItem == "이벤트/기타"){
	  changeItem =  event;
	}
	 
	$('#select2').empty();
	 
	for(var count = 0; count < changeItem.length; count++){                
	           var option = $("<option>"+changeItem[count]+"</option>");
	            $('#select2').append(option);
	            }
	 
	}
</script>
<body>
<form action="">
	<%@include file="../comm/nav.jsp"%>
	<div style="margin-left: 300px; margin-right: 300px;">
		<table summary="G마켓에 문의하기 작성 폼"
			style="margin-left: auto; margin-right: auto;"
			class="table notice-main">
			<caption class="section-title" style="float: left; margin-top: 50px">
				<h1>문의하기</h1>
			</caption>
			<colgroup>
				<col width="16%;">
				<col width="38%;">
				<col width="12%;">
				<col width="*;">
			</colgroup>
			<tbody>
				<tr>
					<th class="none" scope="row">문의 채널</th>
					<td class="none">
						<!-- 대대분류 시작 --> <!--div class="select_cate2" title="문의 채널 선택" alt="문의 채널 선택"> <!-- 2013-09-16 웹접근성 개편 -->
						<div class="select_cate2">
							<!-- 2015-05-26 웹접근성 개편 -->
							<select name="cboClass_0" id="cboClass_0" style="width: 200px;"
								title="문의 채널 선택">
								<option value="01">구매관련</option>
								<option value="02">예약/배달관련</option>
							</select>
						</div> <!-- 대대분류 종료 -->
					</td>
					<th scope="row">문의종류선택</th>
					<td>
						<!-- 중분류 시작 --> <select id="select1" name="cboClass_2"
						onchange="itemChange()" title="문의종류 선택 정보1" style="width: 100px;"><option
								value="ALL">선택</option>
							<option>고객정보</option>
							<option>주문/결제</option>
							<option>배송/예약</option>
							<option>취소</option>
							<option>이벤트/기타</option></select> <select id="select2"
						name="cboClass_3" title="문의종류 선택 정보2" style="width: 130px;">
							<option value="ALL">선택</option>
					</select>

					</td>
				</tr>

				<tr>
					<th scope="row" style="margin-bottom: 10px;">문의 제목</th>
					<td id="thTitle" colspan="0"><input type="text" name="title"
						id="title" class="txt" style="width: 261px;" maxlength="100"
						title="문의 제목 입력"> <!-- 2013-09-16 웹접근성 개편 --></td>
					<!-- WPR-359 -->
					<td scope="row"></td>
					<!-- //WPR-359 -->
				</tr>
				<tr>
					<th scope="row">문의 내용
						<p>
					</th>
					<td colspan="3"><textarea name="txtContents" id="txtContents"
							cols="65" rows="14" style="width: 587px; height: 168px;"
							onfocus="TextAreaFocused(this);" onkeydown="getsize(this);"
							wrap="VIRTUAL" class="txtbox" title="문의 내용 입력"></textarea>
						<div class="byte">
							<br>
						</div></td>
				</tr>
				<tr>
					<th scope="row">연락 받으실 SMS</th>
					<td colspan="3"><select name="hp1" id="hp1"
						style="width: 59px;" onchange="js_next_focus(this,3,'hp2')"
						title="핸드폰번호 앞자리">
							<option value="010" selected="">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
					</select> - <input type="text" class="txt" maxlength="4"
						style="width: 79px;" onkeyup="js_next_focus(this,4,'hp3')"
						name="hp2"  title="핸드폰번호 중간자리"> - <input
						type="text" class="txt" style="width: 79px;"
						onkeyup="js_next_focus(this,4,'title')" name="hp3" maxlength="4"
						 title="핸드폰번호 마지막자리"> <input
						name="SMS_NOTI_YN" type="checkbox" class="chk" value="Y"
						checked="" title="SMS로 답변 받음 체크">답신여부를 SMS로 받음 <!--<input name="chkCUSTOM_UPDATE_YN" id="chkCUSTOM_UPDATE_YN" type="checkbox" class="chk2" value="Y" title="나의정보 동시변경 체크" checked>나의정보 동시변경-->
					</td>
				</tr>
				<tr>
					<th scope="row" style="width: 200px;">답변 받으실 E-mail</th>
					<td colspan="3"><input type="text" class="txt"
						style="width: 100px;" name="e_mail1" id="e_mail1" title="메일 계정 입력">
						@ <input type="text" class="txt" style="width: 143px;"
						name="e_mail2" id="e_mail2" title="메일 도메인 입력"> <select
						name="mail_server" id="mail_server" style="width: 115px;"
						title="메일 제공 사이트 선택">
							<option value="">직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="daum.net">daum.net</option>
							<option value="hotmail.com">hotmail.com</option>
							<option value="nate.com">nate.com</option>
							<option value="yahoo.co.kr">yahoo.co.kr</option>
							<option value="paran.com">paran.com</option>
							<option value="empas.com">empas.com</option>
							<option value="dreamwiz.com">dreamwiz.com</option>
							<option value="freechal.com">freechal.com</option>
							<option value="lycos.co.kr">lycos.co.kr</option>
							<option value="korea.com">korea.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="hanmir.com">hanmir.com</option>
					</select> <input name="e_mail" type="hidden" value="">
						<p>
							&nbsp;<span style="font-size: 8pt"><font color="gray"
								face="돋움">회원정보 변경을 하려면 ? </font></span> <a href="" target="_blank"><u><font
									color="blue" face="돋움"><span style="FONT-SIZE: 8pt">&gt;&gt;
											나의설정 바로가기</span></font></u></a>
						</p></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="btn_center_box" align="center">
		<input type="submit" class="btn btn-danger btn-large" value="문의하기 등록">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="btn btn-danger btn-large" value="입력취소">
	</div>
	</form>
	<br>
	<br>
	<div class="my_faq_list"
		style="margin-left: 300px; margin-right: 300px;">
		<div class="sComm_faq">
			<table summary="나의 문의내역 리스트"
				style="margin-left: auto; margin-right: auto;"
				class="table notice-main">
				<caption style="margin-bottom: 50px;">
					<h1>나의 문의내역 리스트</h1>
				</caption>
				<colgroup>
					<col width="10%;">
					<col width="12%;">
					<col width="*;">
					<col width="12%;">
					<col width="12%;">
					<col width="11%;">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">NO</th>
						<th scope="col">문의유형</th>
						<th scope="col">공지내용</th>
						<th scope="col">문의일</th>
						<th scope="col">답변일</th>
						<th scope="col">처리상태</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>판매자게시판</td>
						<td class="subject"><a href="#"><span><strong>답변좀
										달아주세요!</strong></span></a></td>
						<td>2017-09-19</td>
						<td>2017-09-19</td>
						<td>답변완료</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	function email() {
		$('#e_mail2').val($('#mail_server').val());
	}
	$('#mail_server').change(email);
	
	

	
</script>
</html>