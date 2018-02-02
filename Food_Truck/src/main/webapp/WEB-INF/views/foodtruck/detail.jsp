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
		var licenseNo = <%=vo.getLicenseNo()%>;
		order.action = "order?licenseNo=" + licenseNo
		order.method = "post"
		order.submit();
	}
	
	$(function() {	
		$("#cbtn").click(function() {
			if($(this).val() == '혼잡') {
				$(this).val('여유')
				$(this).attr('src','/resources/img/happy.png')
			}else{
				$(this).val('혼잡')
				$(this).attr('src','/resources/img/busy.png')
			}
		})
	})	
	
	
</script>
<body onload="map()">


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
									<img src="/resources/img/foodtruck/<%=vo.getFtruckImg()%>" alt="" class="simpleLens-big-image">
								</div>
							</div>
						</div>
							<a href="#" style="padding-left: 20px"><img src="/resources/img/busy.png" id="cbtn"></a>
						<!-- Nav tabs -->
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
							<div id="map" style="width: 550px; height: 370px;"></div>
							<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2a898d01cf109199d2b5c34d8e1c5835&libraries=services,clusterer,drawing"></script>
							<script type="text/javascript">
								function map() {
									var mapContainer = document
											.getElementById('map'), // 지도를 표시할 div  
									mapOption = {
										center : new daum.maps.LatLng(
												33.450701, 126.570667), // 지도의 중심좌표
										level : 8
									// 지도의 확대 레벨
									};
									var map = new daum.maps.Map(mapContainer,
											mapOption);

									// 주소-좌표 변환 객체를 생성합니다
									var geocoder = new daum.maps.services.Geocoder();

									// 주소로 좌표를 검색합니다
									geocoder.addressSearch('<%=vo.getFtruckAddr()%>', function(result, status) {

									    // 정상적으로 검색이 완료됐으면 
									     if (status === daum.maps.services.Status.OK) {

									        var coords = new daum.maps.LatLng(result[0].y, result[0].x);
									        
									        // 결과값으로 받은 위치를 마커로 표시합니다
									        var marker = new daum.maps.Marker({
									            map: map,
									            position: coords
									            
									        });
											var content='<div class="wrap">' + 
								            '    <div class="info">' + 
								            '        <div class="title">' + 
								            '            <%=vo.getFtruckName()%>' +  
								            '        </div>' + 
								            '        <div class="body">' + 
								            '            <div class="img">' +//이미지 작업후 수정예정
								            '                <img src="http://cfile181.uf.daum.net/image/250649365602043421936D" width="73" height="70">' +
								            '           </div>' + 
								            '            <div class="desc">' + 
								            '                <div class="ellipsis"><%=vo.getFtruckAddr()%></div>' +
								            '                <div><a href="http://map.daum.net/link/search/<%=vo.getFtruckAddr()%>"style="color:blue" target="_blank">길찾기</a></div>' + 
								            '            </div>' + 
								            '        </div>' + 
								            '    </div>' +    
								            '</div>'
									        // 인포윈도우로 장소에 대한 설명을 표시합니다
									      
									        var overlay = new daum.maps.CustomOverlay({
									            content: content,
									            map: map,
									            position: marker.getPosition(),
									            
									        });
									        
									     // 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
									        daum.maps.event.addListener(marker, 'click', function() {
									            overlay.setMap(map);
									        });

									        // 커스텀 오버레이를 닫기 위해 호출되는 함수입니다 
									        function closeOverlay() {
									            overlay.setMap(null);     
									        }

									    
									     // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
									        map.setCenter(coords); 
									        
									    } 
									});
								}
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
									<%
										}
									%>
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