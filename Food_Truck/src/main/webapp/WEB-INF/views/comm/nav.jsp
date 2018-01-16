<%@page import="com.foodtruck.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav>
	<!--Start Header Top Area-->
	<div class="header-top">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-4">
					<div class="info">
						<div class="phn-num float-left"></div>
						<div class="mail-id float-left"></div>
					</div>
				</div>
				<div class="col-sm-12 col-md-4">
					<div class="socials text-center"></div>
				</div>
				<div class="col-sm-12 col-md-4">
					<div id="top-menu" class="float-right">
						<ul>

							<!-- 로그인 로직 -->
							<%
								boolean isLogin = false;
								MemberVO mvo = null;
								mvo = (MemberVO) session.getAttribute("member");
								//로그인 체크!
								if (mvo != null) {
									isLogin = true;
								}

								//로그인 안했을때
								if (!isLogin) {
							%>
							<li><a href="/loginform">로그인</a></li>
							<li><a href="/joinform">회원가입</a></li>
							
							<li><a href="#">고객센터<i class="fa fa-angle-down"></i></a>
								<ul>
									<li><a href="/noticeBoard?pageNo=1">공지사항</a></li>
									<li><a href="/eventBoard?pageNo=1">이벤트</a></li>
									<li><a href="/inquiry">1:1 문의</a></li>
								</ul>
							</li>
							
							<%
								} else {
							%>
							<li><a href="/logout">로그아웃</a></li>
							<%
								switch (mvo.getMemberAuth()) {
									//비회원
									case "0":
							%>
							<li>로그인되지 않았습니다.</li>
							<%
								break;
									//일반회원
									case "3":
							%>
							<li><a href="#">나의 주문<i class="fa fa-angle-down"></i></a>
								<ul>
									<li><a href="/orderList">전체 주문 내역</a></li>
									<li><a href="/favoritFoodtruck">관심 푸드트럭</a></li>
									<li><a href="/myWriting">내가 쓴글</a></li>
									<li><a href="/mySetting">나의 설정</a></li>
								</ul></li>
							<%
								break;
									//판매자
									case "2":
							%>
							<li><a href="#">판매자 메뉴<i class="fa fa-angle-down"></i></a>
								<ul>
									<!--<li><a href="/productInsert">제품 등록</a></li> -->
									<li><a href="/insertProductForm">제품 등록</a></li>
									<li><a href="/orderDetail">예약 내역</a></li>
									<li><a href="/deliveryDetails">배달 내역</a></li>
									<li><a href="/sellerCalendar">판매자 설정</a></li>
								</ul></li>
							<%
								break;
									//운영자
									case "1":
							%>
							<li><a href="#">관리자 메뉴<i class="fa fa-angle-down"></i></a>
								<ul>
									<li><a href="/adminMember">회원 관리</a></li>
									<li><a href="/adminSeller">판매자 관리</a></li>
									<li><a href="/admin">푸드트럭 관리</a></li>
								</ul></li>
							<%
								break;
									default:
										%>
										<li>로그인되지 않았습니다.</li>
										<%
										break;
									}
							%>
							<li><a href="#">고객센터<i class="fa fa-angle-down"></i></a>
								<ul>
									<li><a href="/noticeBoard?pageNo=1">공지사항</a></li>
									<li><a href="/eventBoard?pageNo=1">이벤트</a></li>
									<li><a href="/inquiry">1:1 문의</a></li>
								</ul>
							</li>
							<%
								}
							%>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--Start Header Top Area-->
	<!--Start Header Area-->
	<div class="header-area">
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-lg-3">
					<div class="log-link"></div>
				</div>
				<div class="col-sm-4 col-lg-6">
					<div class="logo text-center">
						<a href="/"> <img src="/resources/img/header/logo.png" alt="" />
							<!-- 푸드 트럭 이미지  /  h4 밑에 설명 --> <!-- 						<h4>online jewelry store</h4> -->
						</a>
					</div>
				</div>
				<div class="col-sm-4 col-lg-3">
					<!-- 쇼핑 카트 사용 ? / 안사용 ? -->
					<!-- 				<div class="cart-info float-right"> -->
					<!-- 					<a href="cart.html"> -->
					<!-- 						<h5>My cart <span>2</span> items - <span>$390</span></h5> -->
					<!-- 						<i class="fa fa-shopping-cart"></i> -->
					<!-- 					</a> -->
					<!-- 					<div class="cart-hover"> -->
					<!-- 						<ul class="header-cart-pro"> -->
					<!-- 							<li> -->
					<!-- 								<div class="image"><a href="#"><img alt="cart item" src="/resources/img/cart-1.jpg"></a></div> -->
					<!-- 								<div class="content fix"><a href="#">Product Name</a><span class="price">Price: $130</span><span class="quantity">Quantity: 1</span></div> -->
					<!-- 								<i class="fa fa-trash delete"></i> -->
					<!-- 							</li> -->
					<!-- 							<li> -->
					<!-- 								<div class="image"><a href="#"><img alt="cart item" src="/resources/img/cart-2.jpg"></a></div> -->
					<!-- 								<div class="content fix"><a href="#">Product Name</a><span class="price">Price: $130</span><span class="quantity">Quantity: 2</span></div> -->
					<!-- 								<i class="fa fa-trash delete"></i> -->
					<!-- 							</li> -->
					<!-- 						</ul> -->
					<!-- 						<div class="header-button-price"> -->
					<!-- 							<a href="checkout.html"><i class="fa fa-sign-out"></i><span>Check Out</span></a> -->
					<!-- 							<div class="total-price"><h3>Total Price : <span>$390</span></h3></div> -->
					<!-- 						</div> -->
					<!-- 					</div> -->
					<!-- 				</div> -->
					<div class="search float-right">
						<input type="text" value="" placeholder="Search Here...." />
						<button class="submit">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--End Header Area-->

	<!--Start Main Menu Area-->
	<!--Start Main Menu Area-->
	<div class="menu-area">
		<div class="container">
			<div class="row">
				<div class="clo-md-12">
					<div class="main-menu hidden-sm hidden-xs">
						<nav>
							<ul>
								<!-- 푸드트럭 리스트 -->
								<li><a href="/menuBoard?pageNo=1" class="active">FoodTruck
										List</a></li>

								<!-- 한식  -->
								<li><a href="/CategoryFood?pageNo=1&category=1">Korean
										Food</a></li>

								<!-- 중식  -->
								<li><a href="/CategoryFood?pageNo=1&category=2">Chinese
										Food</a></li>

								<!-- 양식  -->
								<li><a href="/CategoryFood?pageNo=1&category=3">Western
										Food</a></li>

								<!-- 일식  -->
								<li><a href="/CategoryFood?pageNo=1&category=4">Japanese
										Food</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
</nav>