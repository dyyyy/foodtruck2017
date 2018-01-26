<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-lg">
					<!-- class="modal-dialog"에 modal-lg추가하면 큰모달,  modal-sm추가하면 작은모달, 아무것도 안쓰면 중간크기의 모달이 만들어진다. -->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								onclick="c()">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">푸드트럭 정보</h4>
						</div>
						<script type="text/javascript"
							src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2a898d01cf109199d2b5c34d8e1c5835&libraries=services,clusterer,drawing"></script>
						<div class="modal-body" id="map"
							style="width: 90%; height: 80%; margin-left: 13px;">
							<br> <br> <br> <br> <br> <br> <br>
							<script type="text/javascript">
								var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
									mapOption = {
										center : new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
										level : 5 // 지도의 확대 레벨
									};
							
								// 지도를 생성합니다    
								var map = new daum.maps.Map(mapContainer, mapOption);
							</script>
						</div>
						<div class="modal-body" id="location"></div>
						<div class="modal-body" id="info">
							<table width="100%">
								<tr rowspan="2" style="border: 1px;">
									<td>이미지</td>
									<td scope="row">jpg</td>
									<td>jpg</td>
									<td>jpg</td>
								</tr>
								<tr>
									<td></td>
									<td>jpg</td>
									<td>jpg</td>
									<td>jpg</td>
								</tr>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" onclick="reply()">댓글
								저장</button>
						</div>
						<!-- data-dismiss="modal" : 모달을 닫는 기능을 갖고있다. -->

					</div>
					<!-- 모달 콘텐츠 -->
				</div>
				
				<!-- 모달 다이얼로그 -->
			</div>
			<!-- 모달 전체 윈도우 -->
</body>
</html>