<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>    
<html>

<jsp:include page="../comm/header.jsp"></jsp:include>

<body>

<%@include file="../comm/nav.jsp" %>

<!-- Shop Product Area Start -->
<div class="shop-product-area section fix">
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="row">
					<!-- Shop Tool Bar -->
					<div class="shop-tool-bar col-sm-12 fix">
						<div class="view-mode">
							<a href="shop-list.html"><i class="fa fa-th"></i></a>
							<a href="shop-list.html" class="active"><i class="fa fa-th-list"></i></a>
						</div>
						<div class="sort-by">
							<span>Sort By</span>
							<select name="sort-by">
								<option selected="selected" value="mercede">price: Lower</option>
								<option value="saab">price(low&gt;high)</option>
								<option value="mercedes">price(high &gt; low)</option>
								<option value="audi">rating(highest)</option>
							</select>
						</div>
						<div class="show-product">
							<span>Show</span>
							<select name="sort-by">
								<option selected="selected" value="mercede">16</option>
								<option value="saab">20</option>
								<option value="mercedes">24</option>
							</select>
							<span>Per Page</span>
						</div>
						<div class="pro-Showing">
							<span>Showing 1 - 12 of 16 items</span>
						</div>
					</div>
					<div class="shop-products">
						<!-- Single Product -->
						<c:forEach items="${list}" var="all">
						<div class="single-list-product col-sm-12">
							<div class="list-pro-image">
								<a href="/read?licenseNo=${all.licenseNo}">
									<img src="/resources/img/foodtruck/${all.ftruckImg}">
								</a>
							</div>
							<div class="list-pro-des fix">
								<a class="pro-name" href="/read?ftruckNo=${all.ftruckNo}">${all.ftruckName}</a>
								<div class="pro-ratting">
									<i class="fa fa-star on"></i>
									<i class="fa fa-star on"></i>
									<i class="fa fa-star on"></i>
									<i class="fa fa-star on"></i>
									<i class="fa fa-star-half-o on"></i>
								</div>
								<p>${all.ftruckIntro}</p>
								
							</div>
						</div>
						</c:forEach>
						<!-- Pagination -->
						<div class="pagination" >
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
</div><!-- Shop Product Area End -->
<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>