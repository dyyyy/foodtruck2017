<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../comm/header.jsp"></jsp:include>
<div class="page-title fix"><!--Start Title-->
	<div class="overlay section">
		<h2>Shop List</h2>
	</div>
</div><!--End Title-->
<!-- Shop Product Area Start -->
<div class="shop-product-area section fix">
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="shop-sidebar fix">
					<!-- single-sidebar start -->
					<div class="sin-shop-sidebar shop-category">
						<h2>Category</h2>
						<ul>
							<li><a href="#">Rings</a></li>
							<li><a href="#">Necklaces</a></li>
							<li><a href="#">BRACELETS</a></li>
							<li><a href="#">EARRINGS</a></li>
							<li><a href="#">CHURIES</a></li>
							<li><a href="#">Jewelry Sets</a></li>
							<li><a href="#">KIDS JEWELRY</a></li>
							<li><a href="#">Others</a></li>
						</ul>
					</div>
					<!-- single-sidebar end -->
					<!-- single-sidebar start -->
					<div class="sin-shop-sidebar shop-add">
						<a href="#"><img src="/resources/img/shop-add-1.jpg" alt=""></a>
					</div>
					<!-- single-sidebar end -->
					<!-- single-sidebar start -->
					<div class="sin-shop-sidebar shop-brands">
						<h2>Brands</h2>
						<ul>
							<li><a href="#">Da Vonna<span>(25)</span></a></li>
							<li><a href="#">Glitzly Rocks<span>(20)</span></a></li>
							<li><a href="#">Hira Jewelrs<span>(35)</span></a></li>
							<li><a href="#">Diamond World<span>(65)</span></a></li>
							<li><a href="#">Apon Jewelrs<span>(35)</span></a></li>
							<li><a href="#">Grameen Jewelrs<span>(25)</span></a></li>
							<li><a href="#">Devs Jewelry<span>(85)</span></a></li>
							<li><a href="#">Sanonda Jewelrs<span>(15)</span></a></li>
						</ul>
					</div>
					<!-- single-sidebar end -->
					<!-- single-sidebar start -->
					<div class="sin-shop-sidebar product-price-range">
						<h2>Price</h2>
						<div class="slider-range-container">
							<div id="slider-range"></div>
							<p>
								<input type="text" id="price-amount" readonly>
							</p>
						</div>
					</div>
					<!-- single-sidebar end -->
					<!-- single-sidebar start -->
					<div class="sin-shop-sidebar shop-add">
						<a href="#"><img src="/resources/img/shop-add-2.jpg" alt=""></a>
					</div>
					<!-- single-sidebar end -->
					<!-- single-sidebar start -->
					<div class="sin-shop-sidebar shop-tags">
						<h2>Tags</h2>
						<ul>
							<li><a href="#">JEWELRY</a></li>
							<li><a href="#">Rings</a></li>
							<li><a href="#">EARRINGS</a></li>
							<li><a href="#">BRACELETS</a></li>
							<li><a href="#">Necklaces</a></li>
							<li><a href="#">Locket</a></li>
							<li><a href="#">Jewelry Sets</a></li>
							<li><a href="#">Churi</a></li>
							<li><a href="#">Watch</a></li>
						</ul>
					</div>
					<!-- single-sidebar end -->
				</div>
			</div>
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
								<a href="product-details.html">
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
								<h4 class="list-pro-price"><span class="new">$152</span><span class="old">$175</span></h4>
								<p>Lorem ipsum dolor sit amet, consectetur adicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua magna aliqua consectetur adicing elit, sed do eiusmod tempor incididunt ut labore magna aliqua consectetur adicing elit, sed do eiusmod tempor incunt ut labore magna aliqua consectetur adicing elit.</p>
								<div class="list-actions-btn">
									<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
									<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
									<a class="cart" href="#"><i class="fa fa-shopping-cart"></i></a>
								</div>
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