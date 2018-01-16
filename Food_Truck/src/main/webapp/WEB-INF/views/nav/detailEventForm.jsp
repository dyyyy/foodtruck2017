<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js" type="text/javascript"></script>
<script>
	$(function() {
		
	});
</script>

</head>
<jsp:include page="../comm/header.jsp"></jsp:include>

<body>

<%@include file="../comm/nav.jsp" %>

	<div class="featured-product section fix">
		<div class="container">
		<!-- notice title -->
			<div class="section-title" style="text-align: left">
				<h2 style="font-size: 30px">Event</h2>
				<div class="underline" style="margin: 0px; width: 200px;"></div>
			</div>
		
		
			<table class="table">
				<tr>
					<th>제목</th>
					<td colspan=3>${vo.eventTitle}</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td>${vo.eventReg}</td>
					<th>조회수</th>
					<td>${vo.eventCnt}</td>
				</tr>
				<tr>
					<td colspan=2 class="notice-content">${vo.eventContent}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${vo.eventWriter}</td>
				</tr>
			</table>
			<button onclick="location.href='/updateEventForm?eventNo=${vo.eventNo}'">수정</button>
			<button id=delete onclick="location.href='/deleteEvent?eventNo=${vo.eventNo}'">삭제</button>
			<button onclick="location.href='/eventBoard?pageNo=1'">목록</button>
			
			
		</div>
	</div>


	<jsp:include page="../comm/footer.jsp"></jsp:include>

</body>
</html>