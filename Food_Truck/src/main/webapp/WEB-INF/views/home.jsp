<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>    
<html>

<jsp:include page="comm/header.jsp"></jsp:include>

<body>

<%@include file="comm/nav.jsp" %>

	<!--start Featured Product Area-->
	<div class="featured-product section fix">
		<div class="container">
			<div class="row">
				<div class="section-title">
					<h2>Weekly Featured FoodTrucks</h2>
					<div class="underline"></div>
				</div>
				<div class="col-sm-12">
					<!-- Featured slider Area Start -->
					<div class="feature-pro-slider owl-carousel">
					
					

						
						<!-- Single Product Start -->
						<c:forEach var="rank" items="${rank}" >
						<fieldset>
						<div class="product-item fix">
							<div class="product-img-hover">
								<!-- Product image -->
								<a href="/read?ftruckNo=${rank.ftruckNo}" class="pro-image fix"><img src="resources/img/foodtruck/${rank.ftruckImg}" alt="featured" /></a>
								<!-- Product action Btn -->
								<div class="product-action-btn">
									<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
									<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
									<a class="add-cart" href="#"><i class="fa fa-shopping-cart"></i></a>
								</div>
							</div>
							<div class="pro-name-price-ratting">
								<!-- Product Name -->
								<div class="pro-name">
									<a href="/read?ftruckNo=${rank.ftruckNo }">${rank.ftruckName}</a>
								</div>
								<!-- Product Ratting -->
								<div class="pro-ratting">
									<span style="width: ${rank.ftruckGrade*20}%"></span>
								</div>
								<!-- Product Price -->
								<div class="pro-price fix">
									<p>
										<span class="new">평점 : ${rank.ftruckGrade }</span>
									</p>
								</div>
							</div>
						</div>
						</fieldset>
						</c:forEach>
						<!-- Single Product End -->
						
						
						
						
					</div>
					<!-- Featured slider Area End -->
				</div>
			</div>
		</div>
	</div>
	<!--End Featured Product Area-->
	<div class="tab-product-area section fix">
		<!--Start Product Area-->
		<div class="container">
			<div class="row">
				<!-- Nav tabs -->
				<ul class="tabs-list" role="tablist">
					<li class="active"><a href="#new" data-toggle="tab">NEW
							ARRIVALS</a></li>
					<li><a href="#feature" data-toggle="tab">FEATURED</a></li>
					<li><a href="#b-sales" data-toggle="tab">BEST SELLERS</a></li>
					<li><a href="#trending" data-toggle="tab">TRENDING</a></li>
				</ul>
				<!-- Tab panes -->
				<div class="tab-content">
					<div class="tab-pane fade in active" id="new">
						<div class="tab-pro-slider new-product owl-carousel">
							<div class="single-product-item fix">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/1.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item fix">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/6.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item fix">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/7.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item fix">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/4.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item fix">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/1.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item fix">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/6.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item fix">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/7.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item fix">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/4.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="feature">
						<div class="tab-pro-slider feature-product owl-carousel">
							<div class="single-product-item fix">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item fix">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item fix">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/4.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/1.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item fix">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/6.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/7.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item fix">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item fix">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item fix">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/4.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/1.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item fix">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/6.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/7.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="b-sales">
						<div class="tab-pro-slider best-product owl-carousel">
							<div class="single-product-item">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/10.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/1.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/4.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/6.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/10.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/1.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/4.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/6.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="trending">
						<div class="tab-pro-slider trending-product owl-carousel">
							<div class="single-product-item">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/6.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/4.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/9.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/10.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/1.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/8.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/3.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/2.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/6.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/4.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/9.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/10.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
							<div class="single-product-item">
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/1.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
								<!-- Single Product Start -->
								<div class="product-item fix">
									<div class="product-img-hover">
										<!-- Product image -->
										<a href="##" class="pro-image fix"><img
											src="img/product/8.jpg" alt="product" /></a>
										<!-- Product action Btn -->
										<div class="product-action-btn">
											<a class="quick-view" href="#"><i class="fa fa-search"></i></a>
											<a class="favorite" href="#"><i class="fa fa-heart-o"></i></a>
											<a class="add-cart" href="#"><i
												class="fa fa-shopping-cart"></i></a>
										</div>
									</div>
									<div class="pro-name-price-ratting">
										<!-- Product Name -->
										<div class="pro-name">
											<a href="##">Product Name Demo</a>
										</div>
										<!-- Product Ratting -->
										<div class="pro-ratting">
											<i class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star"></i> <i class="on fa fa-star"></i> <i
												class="on fa fa-star-half-o"></i>
										</div>
										<!-- Product Price -->
										<div class="pro-price fix">
											<p>
												<span class="old">$165</span><span class="new">$150</span>
											</p>
										</div>
									</div>
								</div>
								<!-- Single Product End -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--End Product Area-->

	<jsp:include page="comm/footer.jsp"></jsp:include>
</body>
</html>