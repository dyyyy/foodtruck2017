<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8">
<title>Food Truck</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Fav Icon -->
<link id="favicon" rel="icon" type="image/png" href="img/favicon.ico" />
<!-- Google Font Raleway -->
<link
	href='https://fonts.googleapis.com/css?family=Raleway:200,300,500,400,600,700,800'
	rel='stylesheet' type='text/css'>
<!-- Google Font Dancing Script -->
<link href='https://fonts.googleapis.com/css?family=Dancing+Script'
	rel='stylesheet' type='text/css'>
<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="/resources/css/bootstrap.min.css" />
<!-- Font Awesome CSS -->
<link rel="stylesheet" type="text/css"
	href="/resources/css/font-awesome.min.css" />
<!-- Owl Carousel CSS -->
<link rel="stylesheet" type="text/css"
	href="/resources/css/owl.carousel.min.css" />
<!-- Animate CSS -->
<link rel="stylesheet" type="text/css"
	href="/resources/css/animate.min.css" />
<!-- simpleLens CSS -->
<link rel="stylesheet" type="text/css"
	href="/resources/css/jquery.simpleLens.css" />
<!-- Price Slider CSS -->
<link rel="stylesheet" type="text/css"
	href="/resources/css/jquery-price-slider.css" />
<!-- MeanMenu CSS -->
<link rel="stylesheet" type="text/css"
	href="/resources/css/meanmenu.min.css" />
<!-- Magnific Popup CSS -->
<link rel="stylesheet" type="text/css"
	href="/resources/css/magnific-popup.css" />
<!-- Nivo Slider CSS -->
<link rel="stylesheet" type="text/css"
	href="/resources/css/nivo-slider.css" />
<!-- Stylesheet CSS -->
<link rel="stylesheet" type="text/css" href="/resources/style.css" />
<!-- Responsive Stylesheet -->
<link rel="stylesheet" type="text/css"
	href="/resources/css/responsive.css" />
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->

<!--End Footer Area-->
<!-- jQuery 2.1.4 -->
<script type="text/javascript" src="/resources/js/jquery-2.1.4.min.js"></script>
<!-- Bootstrap JS -->
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
<!-- Owl Carousel JS -->
<script type="text/javascript" src="/resources/js/owl.carousel.min.js"></script>
<!--countTo JS -->
<script type="text/javascript" src="/resources/js/jquery.countTo.js"></script>
<!-- mixitup JS -->
<script type="text/javascript" src="/resources/js/jquery.mixitup.min.js"></script>
<!-- magnific popup JS -->
<script type="text/javascript"
	src="/resources/js/jquery.magnific-popup.min.js"></script>
<!-- Appear JS -->
<script type="text/javascript" src="/resources/js/jquery.appear.js"></script>
<!-- MeanMenu JS -->
<script type="text/javascript"
	src="/resources/js/jquery.meanmenu.min.js"></script>
<!-- Nivo Slider JS -->
<script type="text/javascript"
	src="/resources/js/jquery.nivo.slider.pack.js"></script>
<!-- Scrollup JS -->
<script type="text/javascript"
	src="/resources/js/jquery.scrollup.min.js"></script>
<!-- simpleLens JS -->
<script type="text/javascript"
	src="/resources/js/jquery.simpleLens.min.js"></script>
<!-- Price Slider JS -->
<script type="text/javascript"
	src="/resources/js/jquery-price-slider.js"></script>
<!-- WOW JS -->
<script type="text/javascript" src="/resources/js/wow.min.js"></script>
<script>
	new WOW().init();
</script>
<!-- Main JS -->
<script type="text/javascript" src="/resources/js/main.js"></script>
<!-- search -->
<script src='//code.jquery.com/jquery.min.js'></script>
<script type="text/javascript">
	//geolocation 처리
	var x = document.getElementById("search");
	function getLocation() {

		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(showPosition, showError);
		} else {
			x.innerHTML = "Geolocation is not supported by this browser.";
		}
	}
	//geolocation 위치 표시
	function showPosition(position) {

		$(function() {
			var lat = position.coords.latitude;
			var lon = position.coords.longitude;
			$
					.ajax({
						url : "/geo",
						type : "post",
						dataType : "json",
						contentType : "application/x-www-form-urlencoded; charset=euc-kr",
						data : {
							"latitude" : lat,
							"longitude" : lon
						},
						success : function(data) {
							$("#search").val(data.sigugun);

						},
						error : function() {
							alert("geolocation error");
						}
					});
		});
	}

	//geolocation 에러처리
	function showError(error) {

		switch (error.code) {
		case error.PERMISSION_DENIED:
			x.innerHTML = "User denied the request for Geolocation."
			break;
		case error.POSITION_UNAVAILABLE:
			x.innerHTML = "Location information is unavailable."
			break;
		case error.TIMEOUT:
			x.innerHTML = "The request to get user location timed out."
			break;
		case error.UNKNOWN_ERROR:
			x.innerHTML = "An unknown error occurred."
			break;
		}
	}
	
<% 
	String gubun  = (String)session.getAttribute("memberGubun");
%>

if(<%=gubun%> == "2") {
	$(function() {
		updateData()
	})
}		
	
	
function updateData() {
	var str = "&nbsp;&nbsp;"
	$.ajax({
		url : "/updateOrderCount",
		type : "post" ,
		cache : false,
		success : function(data) {
			var count = 0;
			var content = "";
			$.each(data,function(idx,val) {
				content += val.ftruckName + " : " + val.newCount + " 개  \n "
				count += val.newCount
			})
			$("#newCount").html(str+count+"개")
				$("#newInfo").click(function() {
					if(count != 0) {
						alert("새로운 주문 정보 \n" + content)
						location.href="/checkNewOrder"
					}else{
						alert("새로운 주문 정보가 없습니다.")
					}
				})				
		}
	})
	setTimeout("updateData()",10000)
}
	//search button
/*
	$(function() {
		$('#locbtn').click(function() {
			alert('search');
			
			var pageNo = 1;
			var search = $("#search").val();
			$.ajax({
				url : "/search",
				type : "post",
				dataType : "json",
				sync : false,
				data : {
					"pageNo" : pageNo,
					"search" : search
				}

			});
			
			
			
			
		});
		
	});*/
</script>
</head>