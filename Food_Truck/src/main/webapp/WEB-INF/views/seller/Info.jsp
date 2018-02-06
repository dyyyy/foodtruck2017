<%@page import="java.util.HashSet"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.foodtruck.vo.FoodTruckVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>상품</title>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<%@include file="../comm/header2.jsp"%>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3" id="sidebar">
				<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
					<li><a href="/sellerMain?licenseNo=${licenseNo}"> <i
							class="icon-chevron-right"></i>주문 및 예약·배달
					</a></li>
					<li><a href="/sellerCalendar?licenseNo=${licenseNo}"><i
							class="icon-chevron-right"></i>매출 통계</a></li>
					<li><a href="/sellerChart?licenseNo=${licenseNo}"><i
							class="icon-chevron-right"></i>차트</a></li>
					<li><a href="/sellerProduct?licenseNo=${licenseNo}"><i
							class="icon-chevron-right"></i>내 푸드트럭 메뉴</a></li>
					<li class="active"><a
						href="/sellerInfo?licenseNo=${licenseNo}"><i
							class="icon-chevron-right"></i>내 푸드트럭 설정</a></li>
				</ul>
			</div>
			<div class="span9" id="content">
				<!-- morris stacked chart -->
				<%FoodTruckVO vo=(FoodTruckVO)request.getAttribute("vo"); %>
				<div class="row-fluid">
					<!-- block -->
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<div class="muted pull-left">푸드트럭 위치 설정하기</div>
							<div class="muted pull-right" style="margin-top: -8px;"><button class="btn" onclick="reposition()">위치 등록하기</button></div>
							<input type="hidden" value="${licenseNo}" id="num">
						</div>
						<div class="block-content collapse in">
							<div id="map" style="width: 100%; height: 500px;"></div>

							<script type="text/javascript"
								src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2a898d01cf109199d2b5c34d8e1c5835&libraries=services,clusterer,drawing"></script>
							<script type="text/javascript">
							var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
						    mapOption = {
						        center: new daum.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
						        level: 2 // 지도의 확대 레벨
						    };  
						var name="<%=vo.getFtruckName()%>";
						// 지도를 생성합니다    
						var map = new daum.maps.Map(mapContainer, mapOption); 
						
						// 주소로 위치 찾기
						var geocoder = new daum.maps.services.Geocoder();

						geocoder.addressSearch('<%=vo.getFtruckAddr()%>', function(result, status) {

						    // 정상적으로 검색이 완료됐으면 
						     if (status === daum.maps.services.Status.OK) {

						        var coords = new daum.maps.LatLng(result[0].y, result[0].x);

						        // 결과값으로 받은 위치를 마커로 표시합니다
						        var marker = new daum.maps.Marker({
						            map: map,
						            position: coords
						        });

						        // 인포윈도우로 장소에 대한 설명을 표시합니다
						        var infowindow = new daum.maps.InfoWindow({
						            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+name+'</div>'
						        });
						        infowindow.open(map, marker);

						        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
						        map.setCenter(coords);
						    } 
						});
						//주소로 위치 찾기 끝
						
						
						var marker = new daum.maps.Marker(), // 클릭한 위치를 표시할 마커입니다
						    infowindow = new daum.maps.InfoWindow({zindex:1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다
						var ftruckAddr;
						var ftruckAddr2;
						var addr1;
						// 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다
						searchAddrFromCoords(map.getCenter(), displayCenterInfo);

						// 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
						daum.maps.event.addListener(map, 'click', function(mouseEvent) {
						    searchDetailAddrFromCoords(mouseEvent.latLng, function(result, status) {
						        if (status === daum.maps.services.Status.OK) {
						        	 
						            var detailAddr = !!result[0].road_address ? '<div>도로명주소 : ' + result[0].road_address.address_name + '</div>' : '';
						            detailAddr += '<div>지번 주소 : ' + result[0].address.address_name + '</div>';
						            ftruckAddr=result[0].address.address_name;
						            ftruckAddr2=!!result[0].road_address ? result[0].road_address.address_name: null;
						            var content = '<div class="bAddr">' +
						                            '<span class="title">법정동 주소정보</span>' + 
						                            detailAddr + 
						                        '</div>';
									addr1=detailAddr;
									
						            // 마커를 클릭한 위치에 표시합니다 
						            marker.setPosition(mouseEvent.latLng);
						            marker.setMap(map);
						            
						            // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
						            infowindow.setContent(content);
						            infowindow.open(map, marker);
						        }   
						    });
						});

						// 중심 좌표나 확대 수준이 변경됐을 때 지도 중심 좌표에 대한 주소 정보를 표시하도록 이벤트를 등록합니다
						daum.maps.event.addListener(map, 'idle', function() {
						    searchAddrFromCoords(map.getCenter(), displayCenterInfo);
						});

						function searchAddrFromCoords(coords, callback) {
						    // 좌표로 행정동 주소 정보를 요청합니다
						    geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);         
						}

						function searchDetailAddrFromCoords(coords, callback) {
						    // 좌표로 법정동 상세 주소 정보를 요청합니다
						    geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
						}

						// 지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
						function displayCenterInfo(result, status) {
						    if (status === daum.maps.services.Status.OK) {
						        var infoDiv = document.getElementById('centerAddr');

						        for(var i = 0; i < result.length; i++) {
						            // 행정동의 region_type 값은 'H' 이므로
						            if (result[i].region_type === 'H') {
						                infoDiv.innerHTML = result[i].address_name;
						                break;
						            }
						        }
						    }    
						}

						function reposition(){
							var licenseNo=document.getElementById("num").value;
							if(addr1==undefined){
								alert("원하시는 장소에 지도를 클릭해주세요");							
							}else{
							$.ajax({
								url:"/updatePosition",
								data:{
									licenseNo:licenseNo,
									ftruckAddr:ftruckAddr,
									ftruckAddr2:ftruckAddr2
								},
								type : "post",
								dataType : "json",
								success : function(data) {
									if(data==1){
										alert("새로운 위치로 업데이트 되었습니다.")
									}
								}
							})	
								
							}
						}
							</script>
							<script type="text/javascript">
							
							</script>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>