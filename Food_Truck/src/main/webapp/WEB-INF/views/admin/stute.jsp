<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function change() {
	
}
</script>
</head>
<%@include file="../comm/header2.jsp"%>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3" id="sidebar">
				<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
					<li><a href="/admin"><i class="icon-chevron-right"></i>메인</a>
					</li>
					<li class="active"><a href="/stute?pageNo=0"><i
							class="icon-chevron-right"></i>푸드트럭 현황&상태</a></li>
					<li><a href="/sellerQnA?pageNo=0"><i class="icon-chevron-right"></i>판매자
							게시판</a></li>
					<li><a href="/memberQnA?pageNo=0"><i class="icon-chevron-right"></i>Q&A</a>
					</li>
					<li><a href="/festival?pageNo=0"><i class="icon-chevron-right"></i>축제관리</a>
					</li>
					<li><a href="/foodtruck?pageNo=0"><i class="icon-chevron-right"></i>푸드트럭 관리</a>
					</li>
				</ul>
			</div>
			<!--/span-->
			<div class="span9" id="content">
				<div class="row-fluid">
					<!-- block -->
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<div class="muted pull-left">
								푸드트럭 현황 <select onchange="state"><option>운영중</option>
									<option>마감</option>
									<option>전체보기</option></select>
							</div>
						</div>
						<div class="block-content collapse in">
							<div class="span12">
								<table cellpadding="0" cellspacing="0" border="0"
									class="table table-striped table-bordered" id="example">
									<thead>
										<tr>
											<th>푸드트럭 이름</th>
											<th>연락처</th>
											<th>현재위치</th>
											<th>등록일</th>
											<th>현재 상태</th>
										</tr>
									</thead>
									<tbody>
										<tr class="odd gradeX">
											<td>Trident</td>
											<td>Internet Explorer 4.0</td>
											<td>Win 95+</td>
											<td class="center">4</td>
											<td class="center">X</td>
										</tr>
										<tr class="even gradeC">
											<td>Trident</td>
											<td>Internet Explorer 5.0</td>
											<td>Win 95+</td>
											<td class="center">5</td>
											<td class="center">C</td>
										</tr>									
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- /block -->
				</div>
				<hr>
				<footer>
				<p>&copy; Vincent Gabriel 2013</p>
				</footer>
			</div>
			<!--/.fluid-container-->

			<script src="vendors/jquery-1.9.1.js"></script>
			<script src="bootstrap/js/bootstrap.min.js"></script>
			<script src="vendors/datatables/js/jquery.dataTables.min.js"></script>


			<script src="assets/scripts.js"></script>
			<script src="assets/DT_bootstrap.js"></script>
			<script>
				$(function() {

				});
			</script>
</body>
</html>