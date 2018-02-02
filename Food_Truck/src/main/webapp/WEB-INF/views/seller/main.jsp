<%@page import="com.foodtruck.vo.OrderDetailVO"%>
<%@page import="com.foodtruck.vo.OrderVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
::-webkit-scrollbar {
	width: 8px;
	height: 8px;
	border: 3px solid #fff;
}

::-webkit-scrollbar-button:start:decrement, ::-webkit-scrollbar-button:end:increment
	{
	display: block;
	height: 10px;
	background: #efefef
}

::-webkit-scrollbar-track {
	background: #efefef;
	-webkit-border-radius: 10px;
	border-radius: 10px;
	-webkit-box-shadow: inset 0 0 4px rgba(0, 0, 0, .2)
}

::-webkit-scrollbar-thumb {
	height: 50px;
	width: 50px;
	background: rgba(0, 0, 0, .2);
	-webkit-border-radius: 8px;
	border-radius: 8px;
	-webkit-box-shadow: inset 0 0 4px rgba(0, 0, 0, .1)
}

.collapse.in.ins {
	height: 150px;
	overflow-y: scroll;
}
</style>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">		
 			$("select").change(function() {
 				var sel = $("select").val();		
 				location.href="sellerMain?licenseNo="+sel;
 				document.selected.value=sel;
 				$(sel).val().attr("selected", "selected");
 			});

		
</script>

</head>
<%@include file="../comm/header2.jsp"%>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3" id="sidebar">
				<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
					<li class="active"><a
						href="/sellerMain?licenseNo=${licenseNo}"> <i
							class="icon-chevron-right"></i>주문 및 예약·배달
					</a></li>
					<li><a href="/sellerCalendar?licenseNo=${licenseNo}"><i
							class="icon-chevron-right"></i>매출 통계</a></li>
					<li><a href="/sellerChart?licenseNo=${licenseNo}"><i
							class="icon-chevron-right"></i>차트</a></li>
					<li><a href="/sellerProduct?licenseNo=${licenseNo}"><i
							class="icon-chevron-right"></i>내 푸드트럭 메뉴</a></li>
				</ul>
			</div>

			<!--/span-->
			<div class="span9" id="content">
				<div class="row-fluid">
					<div class="alert alert-success">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<h4>Success</h4>
						The operation completed successfully
					</div>
					<div class="navbar">
						<div class="navbar-inner">
							<ul class="breadcrumb">
								<i class="icon-chevron-left hide-sidebar"><a href='#'
									title="Hide Sidebar" rel='tooltip'>&nbsp;</a></i>
								<i class="icon-chevron-right show-sidebar"
									style="display: none;"><a href='#' title="Show Sidebar"
									rel='tooltip'>&nbsp;</a></i>
								<li><a href="#">주문 및 예약·배달</a> <span class="divider">/</span>
								</li>
								<li><a href="#">Settings</a> <span class="divider">/</span>
								</li>
								<li class="active">Tools</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<!-- block -->
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<div class="muted pull-left">Statistics</div>
							<div class="pull-right">
								<span class="badge badge-warning">View More</span>

							</div>
						</div>
						<div class="block-content collapse in">
							<div class="span3">
								<div class="chart" data-percent="30">73%</div>
								<div class="chart-bottom-heading">
									<span class="label label-info">Visitors</span>

								</div>
							</div>
							<div class="span3">
								<div class="chart" data-percent="53">53%</div>
								<div class="chart-bottom-heading">
									<span class="label label-info">Page Views</span>

								</div>
							</div>
							<div class="span3">
								<div class="chart" data-percent="83">83%</div>
								<div class="chart-bottom-heading">
									<span class="label label-info">Users</span>

								</div>
							</div>
							<div class="span3">
								<div class="chart" data-percent="13">13%</div>
								<div class="chart-bottom-heading">
									<span class="label label-info">Orders</span>

								</div>
							</div>
						</div>
					</div>
					<!-- /block -->
				</div>

				<select name="licenseNo">
					<option>선택해주세요.</option>
					<c:forEach var="license" items="${license}">
						<option value="${license.licenseNo}">${license.ftruckName}</option>
					</c:forEach>
				</select>
				<div class="row-fluid">

					<div class="span6">

						<!-- block -->
						<div class="block">
							<div class="navbar navbar-inner block-header">
								<div class="muted pull-left">주문</div>
								<div class="pull-right">
									<span class="badge badge-info"></span>
								</div>
							</div>
							<div class="block-content collapse in ins">
								<table class="table table-striped">
									<thead>
										<tr>
											<th>주문 시간</th>
											<th>주문자 명</th>
											<th>음식</th>
											<th>요청사항</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="todayOrder" items="${todayOrder}">
											<tr>
												<td>${todayOrder.ordDate}</td>
												<td>${todayOrder.ordName}</td>
												<td>${todayOrder.prodName}</td>
												<td>${todayOrder.ordReq}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<!-- /block -->
					</div>


					<div class="span6">
						<!-- block -->
						<div class="block">
							<div class="navbar navbar-inner block-header">
								<div class="muted pull-left">예약</div>
								<div class="pull-right">
									<span class="badge badge-info">752</span>

								</div>
							</div>
							<div class="block-content collapse in ins">
								<table class="table table-striped">
									<thead>
										<tr>
											<th>예약시간</th>
											<th>주문자 명</th>
											<th>음식</th>
											<th>요청사항</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="todayOrder" items="${todayOrder}">
											<tr>
												<td>${todayOrder.ordRcvDate}</td>
												<td>${todayOrder.ordName}</td>
												<td>${todayOrder.prodName}</td>
												<td>${todayOrder.ordReq}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<!-- /block -->
					</div>
				</div>
				<div class="row-fluid">
					<div class="span6">
						<!-- block -->
						<div class="block">
							<div class="navbar navbar-inner block-header">
								<div class="muted pull-left">배달</div>
								<div class="pull-right">
									<span class="badge badge-info">17</span>

								</div>
							</div>
							<div class="block-content collapse in ins">
								<table class="table table-striped">
									<thead>
										<tr>
											<th>날짜</th>
											<th>주문자 명</th>
											<th>음식</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="todayDlv" items="${todayDlv}">
											<tr>
												<td>${todayDlv.ordDate}</td>
												<td>${todayDlv.ordName}</td>
												<td>${todayDlv.prodName}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<!-- /block -->
					</div>
					<div class="span6">
						<!-- block -->
						<div class="block">
							<div class="navbar navbar-inner block-header">
								<div class="muted pull-left">총 주문</div>
								<div class="pull-right">
									<span class="badge badge-info">812</span>

								</div>
							</div>
							<div class="block-content collapse in ins">
								<table class="table table-striped">
									<thead>
										<tr>
											<th>날짜</th>
											<th>주문자명</th>
											<th>음식</th>
											<th>요청사항</th>

										</tr>
									</thead>
									<c:forEach var="order" items="${order}">
										<tr>
											<td>${order.ordDate}</td>
											<td>${order.ordName}</td>
											<td>${order.prodName}</td>
											<td>${order.ordReq}</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
						<!-- /block -->
					</div>
				</div>
				<div class="row-fluid">
					<!-- block -->
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<div class="muted pull-left">Gallery</div>
							<div class="pull-right">
								<span class="badge badge-info">1,462</span>

							</div>
						</div>
						<div class="block-content collapse in">
						
						</div>
						<!-- /block -->
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
        $(function() {
            // Easy pie charts
            $('.chart').easyPieChart({animate: 1000});
        });
        </script>
</html>