<%@page import="java.util.List"%>
<%@page import="com.foodtruck.vo.SellerVO"%>
<%@page import="com.foodtruck.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/resources/admin/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="/resources/admin/vendors/fullcalendar/fullcalendar.css" rel="stylesheet" media="screen">
<link href="/resources/admin/vendors/easypiechart/jquery.easy-pie-chart.css" rel="stylesheet" media="screen">
<link href="/resources/admin/assets/styles.css" rel="stylesheet" media="screen">
<script src="/resources/admin/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script src="/resources/admin/vendors/jquery-1.9.1.min.js"></script>
<script src="/resources/admin/vendors/jquery-ui-1.10.3.js"></script>
<script src="/resources/admin/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/admin/vendors/fullcalendar/fullcalendar.js"></script>
<script src="/resources/admin/vendors/fullcalendar/gcal.js"></script>
<script src="/resources/admin/assets/scripts.js"></script>
<script src="/resources/admin/assets/test.js"></script>
<link rel="stylesheet" href="/resources/admin/vendors/morris/morris.css">
<script src="/resources/admin/vendors/jquery.knob.js"></script>
<script src="/resources/admin/vendors/raphael-min.js"></script>
<script src="/resources/admin/vendors/morris/morris.min.js"></script>
<script src="/resources/admin/vendors/flot/jquery.flot.js"></script>
<script src="/resources/admin/vendors/flot/jquery.flot.categories.js"></script>
<script src="/resources/admin/vendors/flot/jquery.flot.pie.js"></script>
<script src="/resources/admin/vendors/flot/jquery.flot.time.js"></script>
<script src="/resources/admin/vendors/flot/jquery.flot.stack.js"></script>
<script src="/resources/admin/vendors/flot/jquery.flot.resize.js"></script>
<script src="/resources/admin/vendors/easypiechart/jquery.easy-pie-chart.js"></script>
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<%
					MemberVO mvo = (MemberVO) session.getAttribute("member");
					
					if(mvo.getMemberAuth().equals("1")) {
				%>
					<a class="brand" href="/admin">관리자</a>
				<%
					} else if(mvo.getMemberAuth().equals("2")) {
				%>
					<a class="brand" href="#">내 푸드트럭 관리</a>
				<%
					}
				%>				
				<div class="nav-collapse collapse">
					<ul class="nav pull-right">
						<li class="dropdown"><a href="#" role="button"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="icon-user"></i>${sessionScope.memberId}<i class="caret"></i>

						</a>
							<ul class="dropdown-menu">
								<li><a tabindex="-1" href="/">Main</a></li>
								<li class="divider"></li>
								<li><a tabindex="-1" href="/logout">Logout</a></li>
							</ul></li>
					</ul>
					<ul class="nav">
						<li class="active"><a href="#">미정</a></li>
						<li class="dropdown"><a href="#" data-toggle="dropdown"
							class="dropdown-toggle">미정 <b class="caret"></b>

						</a>
							<ul class="dropdown-menu" id="menu1">
								<li><a href="#">Tools <i class="icon-arrow-right"></i>

								</a>
									<ul class="dropdown-menu sub-menu">
										<li><a href="#">Reports</a></li>
										<li><a href="#">Logs</a></li>
										<li><a href="#">Errors</a></li>
									</ul></li>
								<li><a href="#">SEO Settings</a></li>
								<li><a href="#">Other Link</a></li>
								<li class="divider"></li>
								<li><a href="#">Other Link</a></li>
								<li><a href="#">Other Link</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" role="button"
							class="dropdown-toggle" data-toggle="dropdown">미정 <i
								class="caret"></i>

						</a>
							<ul class="dropdown-menu">
								<li><a tabindex="-1" href="#">Blog</a></li>
								<li><a tabindex="-1" href="#">News</a></li>
								<li><a tabindex="-1" href="#">Custom Pages</a></li>
								<li><a tabindex="-1" href="#">Calendar</a></li>
								<li class="divider"></li>
								<li><a tabindex="-1" href="#">FAQ</a></li>
							</ul>
						</li>
						<li class="dropdown"><a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
						미정 <i class="caret"></i>

						</a>
							<ul class="dropdown-menu">
							
								<li></li>
							</ul>
							</li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	
	<% 
		if(mvo.getMemberAuth().equals("2")) { 
			List list = (List)session.getAttribute("licenseNo");
			SellerVO ssvo = (SellerVO)list.get(0);
			
			List<SellerVO> svo = (List<SellerVO>) session.getAttribute("licenseNo");
	%>
	<div class="span3" id="sidebar" style="margin-right:50px;margin-left:50px;">
		<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
			<li>
				 <a href="/sellerMain?licenseNo=<%= ssvo.getLicenseNo() %>"><i class="icon-chevron-right"></i>주문 및 예약·배달</a> 
			</li>
			<li class="active">
				<a href="/sellerCalendar?licenseNo=<%= ssvo.getLicenseNo() %>"><i class="icon-chevron-right"></i>매출 통계</a>
			</li>
			<li>
				<a href="/sellerChart?licenseNo=<%= ssvo.getLicenseNo() %>"><i class="icon-chevron-right"></i>차트</a>
			</li>
			<li>
				<a href="/detailFoodTruckForm?licenseNo=<%= ssvo.getLicenseNo() %>"><i class="icon-chevron-right"></i>푸드트럭 정보</a>
			</li>
			<li>
				<a href="/insertFoodTruckForm"><i class="icon-chevron-right"></i>푸드트럭 등록</a>
			</li>
			<li>
				<a href="/sellerProduct?licenseNo=<%= ssvo.getLicenseNo() %>"><i class="icon-chevron-right"></i>내 푸드트럭 메뉴</a>
			</li>
		</ul>
	</div>
	
	<% } %>
</body>
</html>