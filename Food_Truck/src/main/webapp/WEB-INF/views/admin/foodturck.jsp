<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.1.1.min.js"></script>
<!-- Bpopup -->
<script src="js/plugins/bpopup/jquery.bpopup.min.js"></script>
<script type="text/javascript">
	function modal(e) {
		var licenseNo = e.getAttribute("data-id");
		 $('#popup').bPopup();   

		
	}

	function c() {
		location.reload();
	}
</script>
</head>
<%@include file="../comm/header2.jsp"%>

<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3" id="sidebar">
				<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
					<li><a href="/admin?pageNo=1"><i
							class="icon-chevron-right"></i>메인</a></li>
					<li><a href="/stute?pageNo=1"><i
							class="icon-chevron-right"></i>푸드트럭 현황&상태</a></li>
					<li><a href="/sellerQnA?pageNo=1"><i
							class="icon-chevron-right"></i>판매자 Q&A</a></li>
					<li><a href="/memberQnA?pageNo=1"><i
							class="icon-chevron-right"></i>일반회원 Q&A</a></li>
					<li><a href="/festival?pageNo=1"><i
							class="icon-chevron-right"></i>축제관리</a></li>
					<li class="active"><a href="/foodtruck?pageNo=1"><i
							class="icon-chevron-right"></i>푸드트럭 관리</a></li>
				</ul>
			</div>
			<!--/span-->
			<div class="span9" id="content">
				<div class="row-fluid">
					<!-- block -->
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<div class="muted pull-left">승인 대기중인 푸드트럭 총 ${pagecount}개</div>
						</div>
						<div class="block-content collapse in">
							<div class="span12">
								<table cellpadding="0" cellspacing="0" border="0"
									class="table table-striped table-bordered" id="example">
									<thead>
										<tr>
											<th style="width: 200px;">회원 이메일</th>
											<th>회원이름</th>
											<th>사업자번호</th>
											<th>연락처</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="all">
											<tr class="odd gradeX" align="center">
												<td>${all.memberId}</td>
												<td>${all.memberName}</td>
												<td><a href="#bpopup1" data-id="${all.licenseNo}"
													onclick="modal(this)">${all.licenseNo}</a></td>
												<td>${all.memberTel}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
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
									<li><a href="foodtruck?pageNo=1">처음</a></li>
									<%
										}
										if (currentPage > 1) {
									%>
									<li><a href="foodtruck?pageNo=<%=currentPage - 1%>"><i
											class="fa fa-angle-left"></i></a></li>
									<%
										}
										for (int iCount = startPage; iCount <= endPage; iCount++) {
											if (iCount == currentPage) {
									%>
									<li class="active"><span><%=iCount%></span></li>
									<%
										} else {
									%>
									<li><a href="foodtruck?pageNo=<%=iCount%>"><%=iCount%></a>
									<li>
										<%
											}
											}
											if (currentPage < totalPage) {
										%>
									
									<li><a href="foodtruck?pageNo=<%=currentPage + 1%>"><i
											class="fa fa-angle-right"></i></a></li>
									<%
										}
										if (endPage < totalPage) {
									%>
									<li><a href="foodtruck?pageNo=<%=totalPage%>">끝</a></li>
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
			</div>
			<div id="popup"
				style="display: none; background-color: white; width: 500px; height: 300px;">
				<p>bpopup 호출</p>
			</div>
</body>
</html>