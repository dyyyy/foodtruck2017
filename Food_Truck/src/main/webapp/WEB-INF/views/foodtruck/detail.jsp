<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.foodtruck.vo.FoodTruckVO"%>
<%@ page import="com.foodtruck.vo.ReviewVO"%>
<%@ page import="com.foodtruck.vo.ProductVO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.*"%>
<%
	String gubun = (String) session.getAttribute("gubun");
%>
<%List<ReviewVO> list = (List<ReviewVO>) request.getAttribute("review");%>
<%List<ProductVO> list2 = (List<ProductVO>) request.getAttribute("product");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body onload="map()">
	<%FoodTruckVO vo=(FoodTruckVO)request.getAttribute("vo");%>
<%
	if(gubun == null) {
%>
	<jsp:include page="../comm/header.jsp"></jsp:include>
<%
	} else {
%>
	<jsp:include page="../comm/loginGubun.jsp"></jsp:include>
<%
	}
%>
	<section class="product-page page fix"><!--Start Product Details Area-->
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<div class="details-pro-tab">
					<!-- Tab panes -->
					<div class="tab-content details-pro-tab-content">
						<div class="tab-pane fade in active" id="image-1">
							<div class="simpleLens-big-image-container">
								<a class="simpleLens-lens-image"
									data-lens-image="/resources/img/foodtruck/<%=vo.getFtruckImg() %>">
									<img src="/resources/img/foodtruck/<%=vo.getFtruckImg() %>"
									alt="" class="simpleLens-big-image">
								</a>
							</div>
						</div>
						<div class="tab-pane fade" id="image-2">
							<div class="simpleLens-big-image-container">
								<a class="simpleLens-lens-image"
									data-lens-image="/resources/img/foodtruck/<%=vo.getFtruckImg() %>">
									<img src="/resources/img/foodtruck/<%=vo.getFtruckImg() %>"
									alt="" class="simpleLens-big-image">
								</a>
							</div>
						</div>
						<div class="tab-pane fade" id="image-3">
							<div class="simpleLens-big-image-container">
								<a class="simpleLens-lens-image"
									data-lens-image="/resources/img/foodtruck/<%=vo.getFtruckImg() %>">
									<img src="/resources/img/foodtruck/<%=vo.getFtruckImg() %>"
									alt="" class="simpleLens-big-image">
								</a>
							</div>
						</div>
						<div class="tab-pane fade" id="image-4">
							<div class="simpleLens-big-image-container">
								<a class="simpleLens-lens-image"
									data-lens-image="/resources/img/foodtruck/<%=vo.getFtruckImg() %>">
									<img src="/resources/img/foodtruck/<%=vo.getFtruckImg() %>"
									alt="" class="simpleLens-big-image">
								</a>
							</div>
						</div>
					</div>
					<!-- Nav tabs -->
					<ul class="tabs-list details-pro-tab-list" role="tablist">
						<li class="active"><a href="#image-1" data-toggle="tab"><img
								src="/resources/img/foodtruck/<%=vo.getFtruckImg() %>" alt="" /></a></li>
						<li><a href="#image-2" data-toggle="tab"><img
								src="/resources/img/foodtruck/<%=vo.getFtruckImg() %>" alt="" /></a></li>
						<li><a href="#image-3" data-toggle="tab"><img
								src="/resources/img/foodtruck/<%=vo.getFtruckImg() %>" alt="" /></a></li>
						<li><a href="#image-4" data-toggle="tab"><img
								src="/resources/img/foodtruck/<%=vo.getFtruckImg() %>" alt="" /></a></li>
					</ul>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="shop-details">
					<!-- Product Name -->
					<h2><%=vo.getFtruckName() %></h2>
					<!-- Product Ratting -->
					<div class="star">
						<span style="width: <%=vo.getFtruckGrade()*10%>%"></span>
					</div>
					<div class="infomation" style="font-size: 15px; color: #5e636d">
					평점:<%=vo.getFtruckGrade() %>점<br>
					주소:<%=vo.getFtruckAddr() %><br>
					전화번호:<%=vo.getFtruckTel() %><br>
					배달여부:   <%=vo.getFtruckDlvYn() %>   예약여부:   <%=vo.getFtruckRsvYn() %>
					</div>
					<div class="review">
						<div id="map" style="width: 550px; height: 370px;"></div>
						<script type="text/javascript"
							src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2a898d01cf109199d2b5c34d8e1c5835"></script>
						<script type="text/javascript">
                  
                   function map(){
                      var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
                        mapOption = {
                           center : new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                           level : 5
                        // 지도의 확대 레벨
                        };

                      var map = new daum.maps.Map(mapContainer, mapOption);
                     
                         
                     /*마커표시하기*/
                    
                       
                     var positions = [
                             { title: '<%=vo.getFtruckName()%>',latlng: new daum.maps.LatLng(<%=vo.getLatitude() %>,<%=vo.getLongitude() %>),
                                content:'<div style="padding:5px;"><%=vo.getFtruckName()%><br><a href="http://map.daum.net/link/to/<%=vo.getFtruckName()%>,<%=vo.getLatitude() %>,<%=vo.getLongitude() %>							" style="color:blue" target="_blank">길찾기</a></div>'
								} ];

								for (var i = 0; i < positions.length; i++) {
									// 마커를 생성합니다
									var marker = new daum.maps.Marker({
										map : map, // 마커를 표시할 지도
										position : positions[i].latlng, // 마커를 표시할 위치
										title : positions[i].title, // 타이틀이 표시됩니다
										clickable : true
									});

									// 인포윈도우에 표시할 내용
									iwRemoveable = true;
									var infowindow = new daum.maps.InfoWindow({
										content : positions[i].content,
										removable : iwRemoveable
									});
									// 인포윈도우를 마커위에 표시합니다
									infowindow.open(map, marker);
									// 마커에 클릭이벤트를 등록합니다
									daum.maps.event.addListener(marker,
											'click', function() {
												// 마커 위에 인포윈도우를 표시합니다
												infowindow.open(map, marker);
											});

								}

								// HTML5의 geolocation으로 사용할 수 있는지 확인합니다
								if (navigator.geolocation) {

									// GeoLocation을 이용해서 접속 위치를 얻어옵니다
									navigator.geolocation
											.getCurrentPosition(function(
													position) {

												var lat = position.coords.latitude, // 위도
												lon = position.coords.longitude; // 경도

												var locPosition = new daum.maps.LatLng(
														lat, lon), // 마커가 표시될 위치를
												// geolocation으로
												// 얻어온 좌표로 생성합니다
												message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에
												// 표시될 내용입니다

												// 마커와 인포윈도우를 표시합니다
												displayMarker(locPosition,
														message);

											});

								} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다

									var locPosition = new daum.maps.LatLng(
											33.450701, 126.570667), message = 'geolocation을 사용할수 없어요..'

									displayMarker(locPosition, message);
								}

								// 지도에 마커와 인포윈도우를 표시하는 함수입니다
								function displayMarker(locPosition, message) {

									// 마커를 생성합니다
									var marker = new daum.maps.Marker({
										map : map,
										position : locPosition
									});

									var iwContent = message, // 인포윈도우에 표시할 내용
									iwRemoveable = true;

									// 인포윈도우를 생성합니다
									var infowindow = new daum.maps.InfoWindow({
										content : iwContent,
										removable : iwRemoveable
									});

									// 인포윈도우를 마커위에 표시합니다
									infowindow.open(map, marker);
									// 마커에 클릭이벤트를 등록합니다
									daum.maps.event.addListener(marker,
											'click', function() {
												// 마커 위에 인포윈도우를 표시합니다
												infowindow.open(map, marker);
											});

									// 지도 중심좌표를 접속위치로 변경합니다
									map.setCenter(locPosition);
								}

							}
						</script>
						<button class="getoder">주문하러가기!!</button>
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
						<div id="description" class="tab-pane fade active in" role="tabpanel">
							<%=vo.getFtruckIntro() %>
						</div>
						<!-- 상품 리스트 시작 -->
						<div id="tags" class="tab-pane fade" role="tabpanel">
						<table class="reviewlist2" >
						<%for(int i=0;i<list2.size();i++){ %>
								<tr style="width: 860px; height: 95.2px;">
									<td style="width: 120px; height: 94.8px;">
										사진
									</td>
									<td style="width: 840px; height: 95.2px;"><%=list2.get(i).getProdName()%><%=list2.get(i).getProdContent() %></td>

									<td style="width: 140px; height: 95.2px;">
											<dl class="comment" > 
											<dt>가격</dt>
											<dd><%=list2.get(i).getProdPrice() %></dd>			
									</dl>
									</td>
								</tr>
								<%} %>	
							</table>
							</div>
							<!-- 상품리스트 끝 -->
						<div id="review" class="tab-pane fade" role="tabpanel">
							<!-- 리뷰 리스트 시작 -->
							<table class="reviewlist">
							<%for(int i=0;i<list.size();i++){ %>
								<tr style="width: 860px; height: 95.2px;">
									<td style="width: 120px; height: 94.8px;">
										<div class="star">
											<span style="width: <%=list.get(i).getGrade() * 10%>%"></span>
										</div>
									</td>
									<td style="width: 840px; height: 95.2px;"><%=list.get(i).getRevContent() %></td>

									<td style="width: 140px; height: 95.2px;">
											<dl class="comment" > 
											<dt>작성자</dt>
											<dd><%=list.get(i).getMemId() %></dd>
											<dt>등록일</dt>
											<dd><%=list.get(i).getRevDtm() %></dd>
									</dl>
									</td>
								</tr>
								<%} %>
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