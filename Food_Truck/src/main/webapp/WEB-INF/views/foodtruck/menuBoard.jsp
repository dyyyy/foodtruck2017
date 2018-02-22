<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<style>
/* for MS계열 브라우저 */
	@keyframes blink {
		0% {color: #e8da1e;}
		50% {color: #5ba2b3 ;}
	}
	 
/* for Chrome, Safari */
	@-webkit-keyframes blink {
		0% {color: #e8da1e;}
	 	50% {color: #5ba2b3;}
	}
	 
/* blink CSS 브라우저 별로 각각 애니메이션을 지정해 주어야 동작한다. */
	.blinkcss 
	{
	 font-weight:bold;
	 animation: blink 1s step-end infinite;
	 -webkit-animation: blink 1s step-end infinite;
	}
</style>
<jsp:include page="../comm/header.jsp"></jsp:include>
<body>
<%@include file="../comm/nav.jsp"%>

<!-- Shop Product Area Start -->
<div class="shop-product-area section fix">
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="row">
					<!-- Shop Tool Bar -->
					<div class="shop-tool-bar col-sm-12 fix">
						<div class="view-mode">
							<a href="/menuBoard2?pageNo=1"><i class="fa fa-th"></i></a> 
							<a href="/menuBoard?pageNo=1" class="active">
							<i class="fa fa-th-list"></i></a>
						</div>
					</div>				
				</div>
				
				<!-- Single Product -->
				<div class="shop-products">
				<c:forEach items="${list}" var="all">
				<fieldset>
					<div class="single-list-product col-sm-12">
						<div class="list-pro-image">
							<a href="/read?ftruckNo=${all.ftruckNo}"> 
								<img src="${all.ftruckImg}">
							</a>
						</div>
						<div class="list-pro-des fix">
							<a class="pro-name" href="/read?ftruckNo=${all.ftruckNo}">${all.ftruckName}</a>
							<c:if test="${all.ftruckEvent ne null }">
								<a class="eventA blinkcss" href="/detailEventForm?eventNo=${all.eventNo}">이벤트 중입니다.</a><br><br>
							</c:if>
							<!-- 푸드 트럭 별점 -->
							<div class="pro-ratting">
								<span style="width: ${all.ftruckGrade*20}%"></span>
							</div>
							<div>&nbsp;&nbsp;${all.ftruckGrade}점&nbsp;&nbsp;/&nbsp;리뷰수 : ${all.count} 개</div>
							<p>${all.ftruckIntro}</p>
						</div>
					</div>
				</fieldset><br>
				</c:forEach>
				
				<!-- Pagination -->
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
								<li><a href="menuBoard?pageNo=1">처음</a></li>
						<%
							}
							
							if (currentPage > 1) {
						%>
								<li><a href="menuBoard?pageNo=<%=currentPage - 1%>"><i class="fa fa-angle-left"></i></a></li>
						<%
							}
							
							for (int iCount = startPage; iCount <= endPage; iCount++) {
								if (iCount == currentPage) {
						%>
									<li class="active"><span><%=iCount%></span></li>
							<%
								} else {
							%>
									<li><a href="menuBoard?pageNo=<%=iCount%>"><%=iCount%></a><li>
							<%
								}
							}
							
							if (currentPage < totalPage) {
						%>
								<li><a href="menuBoard?pageNo=<%=currentPage + 1%>"><i class="fa fa-angle-right"></i></a></li>
						<%
							}
							if (endPage < totalPage) {
						%>
								<li><a href="menuBoard?pageNo=<%=totalPage%>">끝</a></li>
						<%
							}
						%>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<br>
<br>
<!-- Shop Product Area End -->
<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>