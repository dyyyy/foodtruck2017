<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.foodtruck.vo.FoodTruckVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>* 운영자 - 푸드트럭 관리</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js" type="text/javascript"></script>
<script type="text/javascript">
	
	function modal(e) {
		
		var licenseNo = e.getAttribute("data-id");
		$.ajax({
			url : "/approvalList",
			data : 
				{
					"licenseNo" : licenseNo
				},
			type : "post",
			dataType : "json",
			success : function(data) {
				$(".set").html(data.content);
				$(".table12").html(data.table);
				$(".asd").html('<input type="hidden" value="' + data.licenseNo + '" id="licenseNo">')
			}
		})
	}
	
	function cl() {
		location.reload();
	}
	
	function approval(){
		var licenseNo=document.getElementById("licenseNo").value;
		
		$.ajax({
			url:"/approval",
			data: 
				{
					"licenseNo" : licenseNo
				},
			type: "post",
			success : function(data) {
				alert("승인완료!");
				location.reload();
			}
		})
	}
	
</script>
</head>
<%@include file="../comm/header2.jsp"%>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3" id="sidebar">
			<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
				<li><a href="/stute?pageNo=1"><i class="icon-chevron-right"></i>푸드트럭 현황&상태</a></li>
				<li><a href="/sellerQnA?pageNo=1"><i class="icon-chevron-right"></i>판매자 Q&A</a></li>
				<li><a href="/memberQnA?pageNo=1"><i class="icon-chevron-right"></i>일반회원 Q&A</a></li>
				<li><a href="/festival?pageNo=1"><i class="icon-chevron-right"></i>축제관리</a></li>
				<li class="active"><a href="/foodtruck?pageNo=1"><i class="icon-chevron-right"></i>푸드트럭 관리</a></li>
			</ul>
		</div>
		<!--/span-->
		<div class="span9" id="content">
			<div class="row-fluid">
				<!-- block -->
				<div class="block">
					<div class="navbar navbar-inner block-header">
						<div class="muted pull-left">승인 대기중인 푸드트럭 총 ${pagecount}개</div>
					</div>
	
				<div class="block-content collapse in">
					<table class="table table-bordered">
						<thead>
							<tr align="center" >
								<th style="width: 200px; ">회원 이메일</th>
								<th>회원이름</th>
								<th>사업자번호</th>
								<th>연락처</th>
								<th style="width: 100px;">상세 정보</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach items="${list}" var="all">
								<tr class="odd gradeX" align="center">
									<td>${all.memberId}</td>
									<td>${all.memberName}</td>
									<td>${all.licenseNo}</td>
									<td>${all.memberTel}</td>
									<td>
										<button type="button" class="btn" data-toggle="modal" data-target="#tutorialsplaneModal" data-id="${all.licenseNo}" onclick="modal(this)">상세정보</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="num"></div>
				<!-- /block -->
				<div class="pagination" align="center">
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
								<li><a href="foodtruck?pageNo=1">처음</a></li>
							<%
							} 
							if (currentPage > 1) {
							%>
								<li><a href="foodtruck?pageNo=<%=currentPage - 1%>"><i class="fa fa-angle-left"></i><</a></li>
							<%
							} 
								for (int iCount = startPage; iCount <= endPage; iCount++) {
									if (iCount == currentPage) {
								%>
									<li class="active"><span><%=iCount%></span></li>
								<%
									} else {
								%>
									<li><a href="foodtruck?pageNo=<%=iCount%>"><%=iCount%></a><li>
								<%
									}
								}
								if (currentPage < totalPage) {
								%>
									<li><a href="foodtruck?pageNo=<%=currentPage + 1%>"><i class="fa fa-angle-right">></i></a></li>
							<%
								}
								if (endPage < totalPage) {
								%>
									<li><a href="foodtruck?pageNo=<%=totalPage%>">끝</a></li>
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
<!-- 맨위 DIV끝 -->

<!-- 모달  -->
<div id="tutorialsplaneModal" class="modal fade" role='dialog'>
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">푸드트럭 정보</h4>
			</div>
			<div class="modal-body" style="margin-left: 10px;">
				<div><h4>위치</h4></div>
				<div id="map" style="width: 500px; height: 200px;"></div>
				<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2a898d01cf109199d2b5c34d8e1c5835&libraries=services,clusterer,drawing"></script>
				<script type="text/javascript">
				
					var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
						mapOption = 
							{
								center : new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
								level : 4 // 지도의 확대 레벨
							};
					// 지도를 생성합니다    
					var map = new daum.maps.Map(mapContainer, mapOption);
				</script>
				<div class="set"></div><br><br>
				<div><h4>정보</h4></div>ㅇㅇ
				<div class="table12" align="center"></div>
				<div class="asd"></div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" onclick="approval()">승인하기</button>
				<button type="button" class="btn btn-default" data-dismiss="modal" onclick="cl()">닫기</button>
			</div>
		</div>
	</div>
</div>
</body>
</html>