<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function($)
{
    // 페이지가 로딩될 때 'Loading 이미지'를 숨긴다.
    $('#viewLoading').hide();
 
    // ajax 실행 및 완료시 'Loading 이미지'의 동작을 컨트롤하자.
    $('#viewLoading')
    .ajaxStart(function()
    {
        // 로딩이미지의 위치 및 크기조절    
        $('#viewLoading').css('position', 'absolute');
        $('#viewLoading').css('left', $('#loadData').offset().left);
        $('#viewLoading').css('top', $('#loadData').offset().top);
        $('#viewLoading').css('width', $('#loadData').css('width'));
        $('#viewLoading').css('height', $('#loadData').css('height'));
 
        //$(this).show();
        $(this).fadeIn(500);
    })
    .ajaxStop(function()
    {
        //$(this).hide();
        $(this).fadeOut(500);
    });
});

</script>
<style>
div#viewLoading {
	text-align: center;
	padding-top: 70px;
	background: #FFFFF0;
	filter: alpha(opacity = 60);
	opacity: alpha*0.6;
}
</style>


<script type="text/javascript">
	$(function() {
		$("#re").click(function() {
			alert("약 30초 정도 소요가 됩니다.");
			
			$.ajax({
				url : "/api",
				success : function(data) {
					alert("축제 정보 받아오기 완료!");
					location.reload(); 
				},
				error : function(data) {
					alert("축제정보 받아오기 실패!");
				}
			})
		})
	})
</script>
</head>
<%@include file="../comm/header2.jsp"%>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3" id="sidebar">
				<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
					<li><a href="/admin"><i class="icon-chevron-right"></i>메인</a>
					</li>
					<li><a href="/stute"><i class="icon-chevron-right"></i>푸드트럭
							현황&상태</a></li>
					<li><a href="/sellerQnA"><i class="icon-chevron-right"></i>판매자
							게시판</a></li>
					<li><a href="/memberQnA"><i class="icon-chevron-right"></i>Q&A</a>
					</li>
					<li class="active"><a href="/festival"><i
							class="icon-chevron-right"></i>축제관리</a></li>
					<li><a href="/foodtruck"><i class="icon-chevron-right"></i>푸드트럭
							관리</a></li>
				</ul>
			</div>
			<!--/span-->
			<div class="span9" id="content">
				<div class="row-fluid">
					<!-- block -->
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<div class="muted pull-left">
								<button class="btn" id="re">축제 새로고침</button>
							</div>
						</div>
						<div class="block-content collapse in">
							<div class="span12">
								<table cellpadding="0" cellspacing="0" border="0"
									class="table table-striped table-bordered" id="example">
									<thead>
										<tr>
											<th></th>
											<th>행사 이름</th>
											<th>행사 주소</th>
											<th>행사 전화번호</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="all">
											<tr class="odd gradeX">
												<td><img src="${all.fesImg2}"
													style="width: 80px; height: 80px;"></td>
												<td>${all.fesName}</td>
												<td>${all.fesAddr}</td>
												<td>${all.fesTel}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div id="viewLoading" style="display: none;">
								<img src="resources/img/viewLoading.gif" />
							</div>
							<div class="pagination" align="center">
								<ul>
									<%
										int pageNo;//페이지번호
										int tot = (int) request.getAttribute("pagecount");//전체 게시물수
										try {
											pageNo = (int) request.getAttribute("pageNo");//페이지번호
										} catch (Exception e) {
											pageNo = 1;
										}
										int currentPage = pageNo;//페이지번호
										int countList = 10;
										int countPage = 10;
										int totalPage = tot / countList;//페이지당 게시물수()--  만약 게시물이 10개이면 페이지 수는 1개가된다.
										if (tot % countList > 0) {
											totalPage++;
										}
										///////////////////////////////////적용완료

										if (totalPage < currentPage) {
											currentPage = totalPage;
										} //게시물이 없을경우  0개의 게시물일떄 페이지는 1로 해준다.

										////////////////////////////
										int startPage = ((currentPage - 1) / 10) * 10 + 1;
										int endPage = startPage + countPage - 1;
										if (endPage > totalPage) {
											endPage = totalPage;
										}
										if (startPage > 1) {
									%>
									<li><a href="festival?pageNo=1">처음</a></li>
									<%
										}
										if (currentPage > 1) {
									%>
									<li><a href="festival?pageNo=<%=currentPage - 1%>"><i
											class="fa fa-angle-left"></i><</a></li>
									<%
										}
										for (int iCount = startPage; iCount <= endPage; iCount++) {
											if (iCount == currentPage) {
									%>
									<li class="active"><span><%=iCount%></span></li>
									<%
										} else {
									%>
									<li><a href="festival?pageNo=<%=iCount%>"><%=iCount%></a>
										<li>
										<%
											}
											}
											if (currentPage < totalPage) {
										%>
									
									
									<li><a href="festival?pageNo=<%=currentPage + 1%>"><i
											class="fa fa-angle-right"></i>></a></li>
									<%
										}
										if (endPage < totalPage) {
									%>
									<li><a href="festival?pageNo=<%=totalPage%>">끝</a></li>
									<%
										}
									%>
								</ul>
							</div>
						</div>
					</div>
					<!-- /block -->
				</div>
				<hr>
				<footer>
				<p>&copy; Vincent Gabriel 2013</p>
				</footer>
			</div>
			<!--/.fluid-container-->

			<script src="vendors/jquery-1.9.1.js">
</script> <script src="bootstrap/js/bootstrap.min.js"></script>
			<script src="vendors/datatables/js/jquery.dataTables.min.js"></script>


			<script src="assets/scripts.js"></script>
			<script src="assets/DT_bootstrap.js"></script>
			<script>
				$(function() {

				});
			</script>

									</body>
</html>