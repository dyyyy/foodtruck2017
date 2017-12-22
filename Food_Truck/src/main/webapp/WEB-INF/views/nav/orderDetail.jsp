<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OrderDetail Page</title>
</head>
<body>

<jsp:include page="../comm/loginGubun.jsp"></jsp:include>

<!-- test -->
<div></div>
<section class="cart-page page fix"><!--Start Cart Area-->
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="table-responsive">
					<table class="table cart-table">
						<thead class="table-title">
							<tr>
								<th class="produ">주문 번호</th>
								<th class="produ">제품 이름</th>
								<th class="quantity">수량</th>
								<th class="unit">주문 총 가격</th>
							</tr>													
						</thead>
						<tbody>
							<c:forEach items='${orderDetailList}' var="detailList">
							<tr class="table-info">
								<!-- 주문 번호 -->
								<td class="unit">${detailList.ordNo}</td>
								<!-- 제품 이름 -->
								<td class="unit">${detailList.prodName}</td>
								<!-- 수량-->
								<td class="unit">${detailList.qty}개</td>
								<!-- 주문 총 가격 -->
								<td class="unit">${detailList.ordPrice}원</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</section><!--End Cart Area-->

<br><br><br>
<jsp:include page="../comm/footer.jsp"></jsp:include><br><br><br><br><br><br>

</body>
</html>