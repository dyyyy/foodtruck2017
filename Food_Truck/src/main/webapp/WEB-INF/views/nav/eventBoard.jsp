<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>    
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>

<jsp:include page="../comm/header.jsp"></jsp:include>

<body>

<%@include file="../comm/nav.jsp" %>


	<div class="featured-product section fix">
		<div class="container">
			<!-- event title -->
			<div class="section-title" style="text-align: left">
				<h2 style="font-size: 30px">Event</h2>
				<div class="underline" style="margin: 0px; width: 200px;"></div>
			</div>
			
			<!-- event -->
			<table class="table notice-main">
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>등록일</th>
				</tr>
				<c:forEach var="rank" items="${rank}">
					<tr>
						<td>${rank.noticeNo }</td>
						<td><a href="/detailEventForm?noticeNo=${rank.noticeNo}">${rank.noticeTitle}</a></td>
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
				<button onclick="location.href='/writeEventForm'" style="margin-right:0px">글쓰기</button>
			<% }} %>
		</div>
	</div>

	<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>