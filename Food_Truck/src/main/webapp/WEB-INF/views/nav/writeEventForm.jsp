<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>    
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js" type="text/javascript"></script>

<script src="/resources/editor/js/HuskyEZCreator.js" type="text/javascript" charset="utf-8"></script>
<script>
    $(function(){
        //전역변수선언
        var editor_object = [];
        nhn.husky.EZCreator.createInIFrame({
            oAppRef: editor_object,
            elPlaceHolder: "editor",
            sSkinURI: "/resources/editor/SmartEditor2Skin.html", 
            htParams : {
                // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
                bUseToolbar : true,             
                // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
                bUseVerticalResizer : true,     
                // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
                bUseModeChanger : true, 
            }
        });
        //전송버튼 클릭이벤트
        $("#savebutton").click(function(){
            //id가 smarteditor인 textarea에 에디터에서 대입
            editor_object.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);
            // 이부분에 에디터 validation 검증
            //폼 submit
            if(confirm("등록하시겠습니까?") == true) {
	            $("#frm").submit();
            }
        });
        
        // 취소버튼 눌렀을 때
        $("#cancel").click(function() {
        	if(confirm("취소하시겠습니까?") == true) {
        		location.href="/eventBoard";
        	} 
        })
    });

</script>

</head>

<jsp:include page="../comm/header.jsp"></jsp:include>

<body>

<%@include file="../comm/nav.jsp" %>
	<div class="featured-product section fix">
		<div class="container">
			<!-- event title -->
			<div class="section-title" style="text-align: left">
				<h2 style="font-size: 30px">글쓰기</h2>
				<div class="underline" style="margin: 0px; width: 200px;"></div>
			</div>

			<form id="frm" action="/insertEvent" method="get">
				<table class="table">
					<tr>
						<th>제목</th>
						<td><input type=text name=eventTitle style="width: 970px;"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type=text name=memId style="width: 970px;"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea name="eventContent" id="editor" style="width: 970px ; height: 220px;" rows="10" cols="30"></textarea>
						</td>
					</tr>
				</table>
				
				<div class="row2">
					<div class="eventBtn">
						<input id="savebutton" type="button" value="확인"> 
						<input type=reset value="다시작성">
						<button id=cancel type="button">취소</button>
					</div>
				</div>
			</form>
		</div>
	</div><br><br>
	<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>