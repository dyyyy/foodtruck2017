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
								<a class="pro-name" href="/read?licenseNo=${all.licenseNo}">${all.ftruckName}</a>
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
						<div class="pagination">
							<ul>
								<li><a href="#"><i class="fa fa-angle-left"></i></a></li>
								<li class="active"><span>1</span></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">6</a></li>
								<li><a href="#">7</a></li>
								<li><a href="#">8</a></li>
								<li><a href="#">9</a></li>
								<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
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