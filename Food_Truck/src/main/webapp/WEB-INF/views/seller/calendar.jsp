<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Monthly - Event Tests</title>

<link rel="stylesheet" href="resources/calendar/css/monthly.css">
<script>
$("select").change(function() {
    var sel = $("select").val();      
    location.href="/sellerMain?licenseNo="+sel;
 });
</script>
<style type="text/css">
body {
	font-family: Calibri;
	background-color: #f0f0f0;
	padding: 0em 1em;
}

#mycalendar {
	width: 100%;
	margin: 2em auto 0 auto;
	max-width: 80em;
	border: 1px solid #F6F6F6;
	border-top: 10px solid #08c;
	border-bottom: 3px solid #A6A6A6;
}
</style>

</head>
<%@include file="../comm/header2.jsp"%>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
<%-- 		
			<select name="licenseNo">
				<option>선택해주세요.</option>
				<c:forEach var="license" items="${license}">
					<option value="${license.licenseNo}">${license.ftruckName}</option>
				</c:forEach>
			</select>
 --%>			
			<div class="span3" id="sidebar">
				<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
					<li><a href="/sellerMain?licenseNo=${licenseNo}"> <i
							class="icon-chevron-right"></i>주문 및 예약·배달
					</a></li>
					<li class="active"><a
						href="/sellerCalendarForm?licenseNo=${licenseNo}"><i
						href="/sellerCalendar?licenseNo=${licenseNo}"><i
							class="icon-chevron-right"></i>매출 통계</a></li>
					<li><a href="/sellerChart?licenseNo=${licenseNo}"><i
							class="icon-chevron-right"></i>차트</a></li>
					<li><a href="/sellerProduct?licenseNo=${licenseNo}"><i
							class="icon-chevron-right"></i>내 푸드트럭 메뉴</a></li>
					<li><a
						href="/sellerInfo?licenseNo=${licenseNo}"><i
							class="icon-chevron-right"></i>내 푸드트럭 설정</a></li>
				</ul>
			</div>
			<!--/span-->
			<div class="span9" id="content">
				<div class="row-fluid">
					<!-- block -->
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<div class="muted pull-left">매출·통계</div>
							<div class="pull-right">
								<span class="badge badge-warning">View More</span>

							</div>
						</div>
						<div class="block-content collapse in">
							
							<div class="monthly" id="mycalendar"></div>
							
							<script type="text/javascript"
								src="resources/calendar/js/jquery.js"></script>
							<script type="text/javascript"
								src="resources/calendar/js/monthly.js"></script>
							<script type="text/javascript">
							var list = [];
							var re = [];
							
							 var sampleEvents = 
									 
							 	<%= request.getAttribute("monthly") %> 
							 /* 
							 = {
								"monthly": [
									{
									"id": 1,
									"name": "Whole month event",
									"startdate": "2018-02-01",
									"endtime": "2:00",
									"color": "#99CCCC",
									"url": ""
									},
									{
									"id": 2,
									"name": "Test encompasses month",
									"startdate": "2016-10-29",
									"enddate": "2016-12-02",
									"starttime": "12:00",
									"endtime": "2:00",
									"color": "#CC99CC",
									"url": ""
									}
								]
								};
							 */
								$(window).load( function() {
									
									
									$('#mycalendar').monthly({
										mode: 'event',
										dataType: 'json',
										events: sampleEvents
									});
									
								}); 
							</script>
						</div>
						<!-- /block -->
					</div>
				</div>
			</div>
		</div>
</body>
</html>