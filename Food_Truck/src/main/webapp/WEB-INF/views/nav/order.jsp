<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.foodtruck.vo.ProductVO"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function a(fm) {
	alert();
}
$('input[id=qty]').change(function(){
	
	alert();
})

</script>
</head>
<body>
<%List<ProductVO> list= (List<ProductVO>)request.getAttribute("list");  %>
<jsp:include page="../comm/loginGubun.jsp"></jsp:include>
<section class="cart-page page fix"><!--Start Cart Area-->
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="table-responsive">
					<table class="table cart-table">
						<thead class="table-title">
							<tr>
								<th class="produ">PRODUCT</th>
								<th class="namedes">PRODUCT NAME &amp; DESCRIPTION</th>
								<th class="unit">UNIT PRICE</th>
								<th class="quantity">QUANTITY</th>
								<th class="valu">VALUE</th>
								<th class="acti">ACTION</th>
							</tr>													
						</thead>
						<tbody>
						<%for(int i=0;i<list.size();i++){ %>
							<tr class="table-info">
								<td class="produ">
									<a href="#"><img alt="" src="<%=list.get(i).getProdImg()%>"></a>
								</td>
								<td class="namedes">
									<h2><a href="#"><%=list.get(i).getProdName() %></a></h2>
									<p><%=list.get(i).getProdContent() %></p>
								</td>
								<td class="unit">
									<h5><%=list.get(i).getProdPrice() %></h5>
								</td>
								<td class="quantity">
								<form name="fm">
									<div class="cart-plus-minus">
										<input type="text" value="0" name="qtybutton" class="cart-plus-minus-box" id="qty" onchange="a(this)">
									</div>
								</form>
								</td>
								<td class="valu">
									<h5>$120</h5>
								</td>
								<td class="acti">
									<a href="#"><i class="fa fa-trash-o"></i></a>
								</td>
							</tr>
							<%} %>
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
					
				</div>
			</div>
			<div class="col-sm-6 col-md-5">
				<div class="proceed fix">
					<a href="#">CLEAR SHOPPING CART</a>
					<a href="#">UPDATE SHOPPING CART</a>
					<div class="total">
						<h5>총 금액 <span>$420</span></h5>
						<h6>할인 적용가 <span>$420</span></h6>
					</div>
					<a id="procedto" href="checkout.html">PROCEED TO CHECK OUT</a>
				</div>
			</div>
		</div>
	</div>
</section><!--End Cart Area-->
<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>