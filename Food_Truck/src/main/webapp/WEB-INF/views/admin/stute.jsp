<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function change(abc){
	var option=document.getElementById("state").value;
	if(option=="운영중"){
		ck.action="/list?pageNo=1"
		ck.method="post"
		ck.submit();
	}else if(option=="마감"){
		
	}else{
		alert("전체보기");
	}
}

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
					<li class="active"><a href="/stute?pageNo=1"><i
							class="icon-chevron-right"></i>푸드트럭 현황&상태</a></li>
					<li><a href="/sellerQnA?pageNo=1"><i
							class="icon-chevron-right"></i>판매자 Q&A</a></li>
					<li><a href="/memberQnA?pageNo=1"><i
							class="icon-chevron-right"></i>일반회원 Q&A</a></li>
					<li><a href="/festival?pageNo=1"><i
							class="icon-chevron-right"></i>축제관리</a></li>
					<li><a href="/foodtruck?pageNo=1"><i
							class="icon-chevron-right"></i>푸드트럭 관리</a></li>
				</ul>
			</div>
			<!--/span-->
			<div class="span9" id="content">
				<div class="row-fluid">
					<!-- block -->
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<form name="ck">
								<div class="muted pull-left">
									푸드트럭 현황 <select id="state" onchange="change(this)"><option>운영중</option>
										<option>마감</option>
										<option>전체보기</option></select>
								</div>
							</form>
						</div>
						<div class="block-content collapse in">
							<div class="span12">
								<table cellpadding="0" cellspacing="0" border="0"
									class="table table-striped table-bordered" id="example">
									<thead>
										<tr>
											<th>푸드트럭 이름</th>
											<th>연락처</th>
											<th>현재위치</th>
											<th>현재 상태</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="all">
											<tr class="odd gradeX">
												<td>${all.ftruckName}</td>
												<td>${all.ftruckTel}</td>
												<td>${all.ftruckAddr}</td>
												<td class="center">${all.ftruckState}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- /block -->
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
							<li><a href="stute?pageNo=1">처음</a></li>
							<%
									}
									if (currentPage > 1) {
								%>
							<li><a href="stute?pageNo=<%=currentPage - 1%>"><i
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
							<li><a href="stute?pageNo=<%=iCount%>"><%=iCount%></a>
							<li>
								<%
									}
									}
									if (currentPage < totalPage) {
								%>
							
							<li><a href="stute?pageNo=<%=currentPage + 1%>"><i
									class="fa fa-angle-right"></i>></a></li>
							<%
									}
									if (endPage < totalPage) {
								%>
							<li><a href="stute?pageNo=<%=totalPage%>">끝</a></li>
							<%
									}
								%>
						</ul>
					</div>
				</div>
				<hr>
				<footer>
				<p>&copy; Vincent Gabriel 2013</p>
				</footer>
			</div>
			<!--/.fluid-container-->

			<script src="vendors/jquery-1.9.1.js"></script>
			<script src="bootstrap/js/bootstrap.min.js"></script>
			<script src="vendors/datatables/js/jquery.dataTables.min.js"></script>


			<script src="assets/scripts.js"></script>
			<script src="assets/DT_bootstrap.js"></script>
			<script>
				$(function() {

				});
			</script>
</body>
</html>