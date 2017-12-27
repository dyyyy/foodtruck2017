<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../comm/loginGubun.jsp"></jsp:include>

<!--start create member Area-->
<div class="login-page page fix">
	<div class="container">
		<div class="row2">
			<div class="col-sm-6 col-md-5">
				<div class="product">
					<form id="signup-form" action="/insertProduct">
						<h2>Fill Out Your FoodTruck's Menu</h2>
						<p>your own menu</p>
						<!-- 제품 이름 (prod_name) -->
						<label>제품 번호<span>*</span></label>
						<input type="text" name="prodNo">
						<!-- 제품 이름 (prod_name) -->
						<label>제품 이름<span>*</span></label>
						<input type="text" name="prodName">
						<!-- 제품 상세 (prod_content) -->
						<label>제품 상세</label>
						<textarea name="prodContent" id="message" rows="10" ></textarea>
						<!-- 가격 (prod_price) -->
						<label>가격<span>*</span></label>
						<input type="text" name="prodPrice">
						<!-- 이미지 (prod_price) -->
						<label>이미지</label>
						<input type="file" name=prodImg>
						<!-- 사업자 번호 (license_no)  -->
						<label>사업자 번호<span>*</span></label>
						<select name="licenseNo">
							<c:forEach items="${list}" var="list" >
								<option value="${list.licenseNo}">${list.licenseNo}</option>
							</c:forEach>
						</select>
						<!-- 버튼 -->
						<p><input type="reset" value="Reset" >
						<input type="submit" value="Sign up" ></p>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!--End create member Area-->
<br><br><br><br><br>
<jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>