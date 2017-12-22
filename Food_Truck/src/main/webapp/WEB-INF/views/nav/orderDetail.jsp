<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OrderDetail Page</title>
</head>
<body>

<jsp:include page="../comm/loginGubun.jsp"></jsp:include>

<section class="cart-page page fix"><!--Start Cart Area-->
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="table-responsive">
					<table class="table cart-table">
						<thead class="table-title">
							<tr>
								<th class="produ">제품 번호</th>
								<th class="namedes">주문 번호</th>
								<th class="quantity">수량</th>
								<th class="unit">주문 총 가격</th>
							</tr>													
						</thead>
						<tbody>
							<tr class="table-info">
								<td class="namedes">
								<!-- 디비에서 가져온거 넣자 -->
								<!-- 제품 번호 넣을 자리 -->
									<h2><a href="#">PRODUCT NAME DEMO</a></h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
								</td>
								<!-- 주문 번호 -->
								<td class="unit">
									<h5>$120</h5>
								</td>
								<!-- 수량-->
								<td class="unit">
									<h5>$120</h5>
								</td>
								<!-- 주문 총 가격 -->
								<td class="valu">
									<h5>$120</h5>
								</td>
							</tr>
							<tr class="table-info">
								<td class="namedes">
									<h2><a href="#">PRODUCT NAME DEMO</a></h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
								</td>
								<td class="unit">
									<h5>$120</h5>
								</td>
								<td class="unit">
									<h5>$120</h5>
								</td>
								<td class="valu">
									<h5>$120</h5>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-sm-6 col-md-7">
				<div class="coupon">
					<a href="#">Continue Shopping</a>
					<h3>DISCOUNT COUPON CODE</h3>
					<input type="text" placeholder="DISCOUNT COUPON CODE HERE..." />
					<a href="#">Apply Coupon</a>
					<p><span>NOTE :</span> Shipping and Taxes are estimated and updated during checkout based on your billing and shipping information.</p>
				</div>
			</div>
			<div class="col-sm-6 col-md-5">
				<div class="proceed fix">
					<a href="#">CLEAR SHOPPING CART</a>
					<a href="#">UPDATE SHOPPING CART</a>
					<div class="total">
						<h5>Sub Total <span>$420</span></h5>
						<h6>Grand Total <span>$420</span></h6>
					</div>
					<a id="procedto" href="checkout.html">PROCEED TO CHECK OUT</a>
				</div>
			</div>
		</div>
	</div>
</section><!--End Cart Area-->

<br><br><br>
<jsp:include page="../comm/footer.jsp"></jsp:include><br><br><br><br><br><br>

</body>
</html>