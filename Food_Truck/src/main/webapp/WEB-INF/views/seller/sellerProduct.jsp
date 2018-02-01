<%@page import="java.util.HashSet"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.foodtruck.vo.SellerVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>상품</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
function modal(e) {
	var licenseNo = e.getAttribute("data-id");
	$.ajax({
		url : "/modal",
		data : {
			"licenseNo" : licenseNo
		},
		type : "post",
		dataType : "json",
		success : function(data) {		
			$(".num").html('<input type="hidden" value="' + data.licenseNo + '" id="licenseNo">');
		}
	})
}
	function ch() {
		var licenseNo = $("select").val();
		$.ajax({
			url : "/sellerProduct",
			data : {
				"licenseNo" : licenseNo
			},
			type : "post",
			dataType : "json",
			success : function(data) {
				$(".block-content collapse in").html();
			}
		})
		location.href = "sellerProduct?licenseNo=" + sel;
	}
	function add(){
		var name =document.getElementById("pname").value;
		var price =document.getElementById("pprice").value;
		var content =document.getElementById("pcontent").value;
		var img =document.getElementById("pimg").value;
		var origin =document.getElementById("porigin").value;
		var licenseNo =document.getElementById("licenseNo").value;
		$.ajax({
			url:"insertProduct",
			data:{
				"licenseNo":licenseNo,
				"prodName":name,
				"prodPrice":price,
				"prodContent":content,
				"img":img,
				"prodOrgin":origin
			},
			type : "post",
			dataType : "json",
			success : function(data) {
				if(data==1){
					alert("상품이 등록되었습니다")
				}else{
					alert("상품등록이 실패했습니다 관리자에게 문의해주세요!");
				}
				location.reload();
			}
		})
		
	}
</script>
<style>
.row-fluid [class*="span"] {
	display: block;
	float: left;
	width: 100%;
	min-height: 30px;
	margin-left: 0.12766%;
	*margin-left: 0.12766%;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box
}

.gfd {
	margin-left: 60px;
}
</style>
</head>
<%@include file="../comm/header2.jsp"%>
<body>
	<%
		List<SellerVO> list = (List<SellerVO>) request.getAttribute("list");
	%>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span9" id="content">
				<!-- morris stacked chart -->
				<div class="row-fluid">
					<!-- block -->
					<div class="block">
						<div class="navbar navbar-inner block-header">
							<div class="muted pull-left">
								나의 상품&nbsp;&nbsp;&nbsp;&nbsp;<select onchange="ck()">
									<optgroup label="사업자번호">
										<%
											for (int i = 0; i < list.size(); i++) {
										%>
										<option><%=list.get(i).getLicenseNo()%></option>
										<%
											}
										%>
									</optgroup>
								</select>
							</div>
							<div class="muted pull-right">
								<button class="btn" style="margin-top: -5px;"
									data-toggle="modal" data-target="#tutorialsplaneModal" data-id="${licenseNo}" onclick="modal(this)">상품
									등록하기</button>
							</div>
						</div>
						<div class="block-content collapse in">
							<div class="gfd">
								<!-- 상품 리스트 뿌려주기  1행 MAX 4개 상품 -->
								<c:forEach items="${list2}" var="all">
									<div class="span3">
										<a href="#" class="thumbnail"> <img
											data-src="holder.js/260x180" alt="260x180"
											style="width: 260px; height: 180px;" src="${all.prodImg}">
										</a>
										<div align="center">
											<table >
												<tr>
													<td><h5>${all.prodName}(&#8361;${all.prodPrice})</h5></td>
												</tr>
											</table>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="tutorialsplaneModal" class="modal fade" role='dialog'>
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">상품 등록하기</h4>
				</div>
				<div class="modal-body" style="margin-left: 10px;">
					<form class="form-horizontal" name="addProduct">
						<table border=1 class="table table-striped table-bordered" >
							<tr>
								<td align="center" style="width: 100px;">상품이름</td>
								<td colspan=3 ><input type="text" style="width: 350px;" id="pname"></td>
							</tr>
							<tr>
								<td align="center">상품 가격</td>
								<td colspan=3><input type="text" style="width: 350px;" id="pprice"></td>
							</tr>
							<tr>
								<td rowspan=3>상품 설명</td>
								<td rowspan=3 colspan=3><textarea rows="5" cols="8" style="width: 350px;" id="pcontent"></textarea></td>
							</tr>
							<tr></tr>
							<tr></tr>
							<tr>
								<td>이미지 파일</td>
								<td colspan=3><input type="file" style="width: 350px;" id="pimg" enctype="multipart/form-data"></td>
							</tr>
							<tr>
								<td rowspan=2>원산지</td>
								<td rowspan=2 colspan=3><textarea rows="5" cols="5" style="width: 350px;" id="porigin"></textarea></td>
							</tr>
							<tr></tr>
						</table>
						<div class="num"></div>
					</form>
				</div>
				
				<div class="modal-footer">
					<button class="btn btn-default" onclick="add()">등록하기</button>
					<button type="button" class="btn btn-default" data-dismiss="modal"
						onclick="cl()">닫기</button>
				</div>
			</div>
		</div>
	</div>
	<div id="tutorialsplaneModal2" class="modal fade" role='dialog'>
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">상품내용</h4>
				</div>
				<div class="modal-body" style="margin-left: 10px;"></div>
				<div class="modal-footer">
					<button class="btn btn-default" onclick="add()">수정하기</button>
					<button type="button" class="btn btn-default" data-dismiss="modal"
						onclick="cl()">닫기</button>
				</div>
			</div>
		</div>
	</div>
</body>

</html>