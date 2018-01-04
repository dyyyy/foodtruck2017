<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.foodtruck.vo.FoodTruckVO"%>
<%@ page import="com.foodtruck.vo.ReviewVO"%>
<%@ page import="com.foodtruck.vo.ProductVO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.*"%>

<%
	@SuppressWarnings("unchecked")
	List<ReviewVO> list = (List<ReviewVO>) request.getAttribute("review");
	@SuppressWarnings("unchecked")
	List<ProductVO> list2 = (List<ProductVO>) request.getAttribute("product");
	FoodTruckVO vo = (FoodTruckVO) request.getAttribute("vo");
%>

<!DOCTYPE html>
<html>

<jsp:include page="../comm/header.jsp"></jsp:include>

<head>
<script type="text/javascript">
	function goOrder() {
		var licenseNo =
<%=vo.getLicenseNo()%>
	;
		order.action = "order?licenseNo=" + licenseNo
		order.method = "post"
		order.submit();
	}
</script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=kVz0Er4ERmUrd5eHhHXi&submodules=geocoder"></script>
</head>

<body>

	<%@include file="../comm/nav.jsp"%>

	<section class="product-page page fix">
		<!--Start Product Details Area-->
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="details-pro-tab">
						<!-- Tab panes -->
						<div class="tab-content details-pro-tab-content">
							<div class="tab-pane fade in active" id="image-1">
								<div class="simpleLens-big-image-container">
									<a class="simpleLens-lens-image"
										data-lens-image="/resources/img/foodtruck/<%=vo.getFtruckImg()%>">
										<img src="/resources/img/foodtruck/<%=vo.getFtruckImg()%>"
										alt="" class="simpleLens-big-image">
									</a>
								</div>
							</div>
							<div class="tab-pane fade" id="image-2">
								<div class="simpleLens-big-image-container">
									<a class="simpleLens-lens-image"
										data-lens-image="/resources/img/foodtruck/<%=vo.getFtruckImg()%>">
										<img src="/resources/img/foodtruck/<%=vo.getFtruckImg()%>"
										alt="" class="simpleLens-big-image">
									</a>
								</div>
							</div>
							<div class="tab-pane fade" id="image-3">
								<div class="simpleLens-big-image-container">
									<a class="simpleLens-lens-image"
										data-lens-image="/resources/img/foodtruck/<%=vo.getFtruckImg()%>">
										<img src="/resources/img/foodtruck/<%=vo.getFtruckImg()%>"
										alt="" class="simpleLens-big-image">
									</a>
								</div>
							</div>
							<div class="tab-pane fade" id="image-4">
								<div class="simpleLens-big-image-container">
									<a class="simpleLens-lens-image"
										data-lens-image="/resources/img/foodtruck/<%=vo.getFtruckImg()%>">
										<img src="/resources/img/foodtruck/<%=vo.getFtruckImg()%>"
										alt="" class="simpleLens-big-image">
									</a>
								</div>
							</div>
						</div>
						<!-- Nav tabs -->
						<ul class="tabs-list details-pro-tab-list" role="tablist">
							<li class="active"><a href="#image-1" data-toggle="tab"><img
									src="/resources/img/foodtruck/<%=vo.getFtruckImg()%>" alt="" /></a></li>
							<li><a href="#image-2" data-toggle="tab"><img
									src="/resources/img/foodtruck/<%=vo.getFtruckImg()%>" alt="" /></a></li>
							<li><a href="#image-3" data-toggle="tab"><img
									src="/resources/img/foodtruck/<%=vo.getFtruckImg()%>" alt="" /></a></li>
							<li><a href="#image-4" data-toggle="tab"><img
									src="/resources/img/foodtruck/<%=vo.getFtruckImg()%>" alt="" /></a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="shop-details">
						<!-- Product Name -->
						<h2><%=vo.getFtruckName()%></h2>
						<!-- Product Ratting -->
						<div class="star">
							<span style="width: <%=vo.getFtruckGrade() * 10%>%"></span>
						</div>
						<div class="infomation" style="font-size: 15px; color: #5e636d">
							평점:<%=vo.getFtruckGrade()%>점<br> 주소:<%=vo.getFtruckAddr()%><br>
							전화번호:<%=vo.getFtruckTel()%><br> 배달여부:
							<%=vo.getFtruckDlvYn()%>
							예약여부:
							<%=vo.getFtruckRsvYn()%>
						</div>
						
						<div class="review">
							<!-- 네이버지도 시작 -->
							<div id="map" style="width: 550px; height: 330px;"></div>

							<script>
							var mapOptions = {
								    center: new naver.maps.LatLng(37.3595704, 127.105399),
								    zoom: 8
								};
							var map = new naver.maps.Map('map', mapOptions);
							
							
							//정보창
							var HOME_PATH = window.HOME_PATH || '.';
							var foodtruck = new naver.maps.LatLng(<%=vo.getLatitude()%>, <%=vo.getLongitude()%>),
							 marker = new naver.maps.Marker({
						        map: map,
						        position: foodtruck
						    });			
							var contentString = [
						        '<div class="iw_inner">',
						        '   <h3>서울특별시청</h3>',
						        '   <p>서울특별시 중구 태평로1가 31 | 서울특별시 중구 세종대로 110 서울특별시청<br />',
						        '       <img src="'+ HOME_PATH +'/img/example/hi-seoul.jpg" width="55" height="55" alt="서울시청" class="thumb" /><br />',
						        '       02-120 | 공공,사회기관 &gt; 특별,광역시청<br />',
						        '       <a href="http://www.seoul.go.kr" target="_blank">www.seoul.go.kr/</a>',
						        '   </p>',
						        '</div>'
						    ].join('');
							var infowindow = new naver.maps.InfoWindow({
							    content: contentString
							});
							naver.maps.Event.addListener(marker, "click", function(e) {
							    if (infowindow.getMap()) {
							        infowindow.close();
							    } else {
							        infowindow.open(map, marker);
							    }
							});
							infowindow.close(map, marker);
							//정보창 끝
							
							
							
							
							//내위치찾기
							function onSuccessGeolocation(position) {
							    var location = new naver.maps.LatLng(position.coords.latitude,
							                                         position.coords.longitude);

							    map.setCenter(location); // 얻은 좌표를 지도의 중심으로 설정합니다.
							    map.setZoom(10); // 지도의 줌 레벨을 변경합니다.

							    var infowindow1 = new naver.maps.InfoWindow({
									content: '<div style="padding:5px;">' +
								        '여기에 계신가요?'+'</div>'
								        		
								});//내위치 말풍선
							    
							    var marker2 = new naver.maps.Marker({
							        position: new naver.maps.LatLng(location.lat() , location.lng()),
							        map: map
							    });
							    
							    naver.maps.Event.addListener(marker2, "click", function(e) {
								    if (infowindow1.getMap()) {
								        infowindow1.close();
								    } else {
								        infowindow1.open(map, marker);
								    }
								});
							    
							    infowindow1.open(map, location);
							}

							function onErrorGeolocation() {
							    var center = map.getCenter();

							    infowindow1.setContent('<div style="padding:20px;">' +
							        '<h5 style="margin-bottom:5px;color:#f00;">Geolocation failed!</h5>'+ "latitude: "+ center.lat() +"<br />longitude: "+ center.lng() +'</div>');

							    infowindow1.open(map, center);
							}

							$(window).on("load", function() {
							    if (navigator.geolocation) {
							        navigator.geolocation.getCurrentPosition(onSuccessGeolocation, onErrorGeolocation);
							    } else {
							        var center = map.getCenter();

							        infowindow1.setContent('<div style="padding:20px;"><h5 style="margin-bottom:5px;color:#f00;">Geolocation not supported</h5>'+ "latitude: "+ center.lat() +"<br />longitude: "+ center.lng() +'</div>');
							        infowindow1.open(map, center);
							    }
							});

							</script>
							<form name="order">
								<button class="getoder" onclick="goOrder()">주문하러가기!!</button>
							</form>
						</div>
					</div>
				</div>
				<div class="col-sm-12 fix">
					<div class="description">
						<!-- Nav tabs -->
						<ul class="nav product-nav">
							<li class="active"><a data-toggle="tab" href="#description">푸드트럭
									소개</a></li>
							<li class=""><a data-toggle="tab" href="#review">리뷰</a></li>
							<li class=""><a data-toggle="tab" href="#tags">상품</a></li>
						</ul>
						<!-- Tab panes -->
						<div class="tab-content">
							<div id="description" class="tab-pane fade active in"
								role="tabpanel">
								<%=vo.getFtruckIntro()%>
							</div>
							<!-- 상품 리스트 시작 -->
							<div id="tags" class="tab-pane fade" role="tabpanel">
								<table class="reviewlist2">
									<%
										for (int i = 0; i < list2.size(); i++) {
									%>
									<tr style="width: 860px; height: 95.2px;">
										<td style="width: 120px; height: 94.8px;">사진</td>
										<td style="width: 840px; height: 95.2px;"><%=list2.get(i).getProdName()%><%=list2.get(i).getProdContent()%></td>

										<td style="width: 140px; height: 95.2px;">
											<dl class="comment">
												<dt>가격</dt>
												<dd><%=list2.get(i).getProdPrice()%></dd>
											</dl>
										</td>
									</tr>
									<%
										}
									%>
								</table>
							</div>
							<!-- 상품리스트 끝 -->
							<div id="review" class="tab-pane fade" role="tabpanel">
								<!-- 리뷰 리스트 시작 -->
								<table class="reviewlist">
									<%
										for (int i = 0; i < list.size(); i++) {
									%>
									<tr style="width: 860px; height: 95.2px;">
										<td style="width: 120px; height: 94.8px;">
											<div class="star">
												<span style="width: <%=list.get(i).getGrade() * 10%>%"></span>
											</div>
										</td>
										<td style="width: 840px; height: 95.2px;"><%=list.get(i).getRevContent()%></td>

										<td style="width: 140px; height: 95.2px;">
											<dl class="comment">
												<dt>작성자</dt>
												<dd><%=list.get(i).getMemId()%></dd>
												<dt>등록일</dt>
												<dd><%=list.get(i).getRevDtm()%></dd>
											</dl>
										</td>
									</tr>
									<%}%>
								</table>
								<!-- 리뷰 리스트 끝 -->
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--End Product Details Area-->
	<jsp:include page="../comm/footer.jsp"></jsp:include>

</body>