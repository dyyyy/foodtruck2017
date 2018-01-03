<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.foodtruck.vo.ProductVO"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>    
<html>

<%@include file="../comm/header.jsp" %>

<body onload="init()">

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="http://code.jquery.com/jquery-3.1.0.js"></script>
	<script type="text/javascript">
		var sell_price;
		var amount;

		function init() {
			sell_price = document.form.sell_price.value;
			amount = document.form.amount.value;
			document.form.sum.value = sell_price;
			change();
		}

		function add() {
			hm = document.form.amount;
			sum = document.form.sum;
			hm.value++;

			sum.value = parseInt(hm.value) * sell_price;
		}

		function del() {
			hm = document.form.amount;
			sum = document.form.sum;
			if (hm.value > 1) {
				hm.value--;
				sum.value = parseInt(hm.value) * sell_price;
			}
		}

		function change() {
			hm = document.form.amount;
			sum = document.form.sum;

			if (hm.value < 0) {
				hm.value = 0;
			}
			sum.value = parseInt(hm.value) * sell_price;
		}
	</script>


	<form name="form">
		<%
			List<ProductVO> list = (List<ProductVO>) request.getAttribute("list");
		%>
		<section class="cart-page page fix">
			<!--Start Cart Area-->
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<div class="table-responsive">
							<table class="table cart-table">
								<thead class="table-title">
									<tr>
										<th class="produ">제품</th>
										<th class="namedes">제품이름 &amp; 제품설명</th>
										<th class="unit">가격</th>
										<th class="quantity">수량</th>
										<th class="valu">총가격</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < list.size(); i++) {
									%>
									<tr class="table-info">
										<td class="produ"><a href="#"><img alt=""
												src="<%=list.get(i).getProdImg()%>"></a></td>
										<td class="namedes">
											<h2>
												<a href="#"><%=list.get(i).getProdName()%></a>
											</h2>
											<p><%=list.get(i).getProdContent()%></p>
										</td>
										<td class="unit">
											<h5><%=list.get(i).getProdPrice()%></h5>
										</td>
										<td class="quantity"><input type=hidden name="sell_price"
											value="<%=list.get(i).getProdPrice()%>"> <input
											type="text" name="amount" value="1" size="3"
											onchange="change();"> <input type="button"
											value=" + " onclick="add();"> <input type="button"
											value=" - " onclick="del();"></td>
										<td class="valu">
											<h5>
												<input type="text" name="sum" size="11" readonly>
											</h5>
										</td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
						</div>
					</div>
					<div class="col-sm-6 col-md-7">
						<div class="coupon">
							<h3>할인쿠폰</h3>
							<input type="text" placeholder="쿠폰번호를 입력해주세요" /> <a href="#">쿠폰적용하기</a>

						</div>
					</div>
					<div class="col-sm-6 col-md-5">
						<div class="proceed fix">

							<div class="total">
								<h5>
									총 금액 <span>$420</span>
								</h5>
								<h6>
									할인 적용가 <span>$420</span>
								</h6>
							</div>
							<a id="procedto" href="checkout.html">PROCEED TO CHECK OUT</a>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!--End Cart Area-->
		<jsp:include page="../comm/footer.jsp"></jsp:include>
	</form>
</body>
</html>