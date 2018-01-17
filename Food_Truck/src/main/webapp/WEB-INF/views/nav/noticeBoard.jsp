<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>

<jsp:include page="../comm/header.jsp"></jsp:include>

<body>

	<%@include file="../comm/nav.jsp"%>


	<div class="featured-product section fix">
		<div class="container">
			<!-- notice title -->
			<div class="section-title" style="text-align: left">
				<h2 style="font-size: 30px">Notice</h2>
				<div class="underline" style="margin: 0px; width: 200px;"></div>
			</div>

			<!-- notice -->
			<table class="table notice-main" >
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>등록일</th>
				</tr>
				<c:forEach var="rank" items="${rank}">
					<tr align="center">
						<td>${rank.noticeNo }</td>
						<td><a href="/detailNoticeForm?noticeNo=${rank.noticeNo}">${rank.noticeTitle}</a></td>
						<td>${rank.noticeWriter}</td>
						<td>${rank.noticeCnt}</td>
						<td>${rank.noticeReg}</td>
					</tr>
				</c:forEach>
			</table>
			<%
				//로그인 체크!
				if (mvo != null) {
					isLogin = true;
					if(mvo.getMemberAuth().equals("1")) {
			%>
			<button onclick="location.href='/writeNoticeForm'"
				style="margin-right: 0px">글쓰기</button>
			<% }} %>
			<div class="pagination">
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
					<li><a href="noticeBoard?pageNo=1">처음</a></li>
					<%
									}
									if (currentPage > 1) {
								%>
					<li><a href="noticeBoard?pageNo=<%=currentPage - 1%>"><i
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
					<li><a href="noticeBoard?pageNo=<%=iCount%>"><%=iCount%></a>
					<li>
						<%
									}
									}
									if (currentPage < totalPage) {
								%>
					
					<li><a href="noticeBoard?pageNo=<%=currentPage + 1%>"><i
							class="fa fa-angle-right"></i></a></li>
					<%
									}
									if (endPage < totalPage) {
								%>
					<li><a href="noticeBoard?pageNo=<%=totalPage%>">끝</a></li>
					<%
									}
								%>
				</ul>
			</div>
		</div>
	</div>

	<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>