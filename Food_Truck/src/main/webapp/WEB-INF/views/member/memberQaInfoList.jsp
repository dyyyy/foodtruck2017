<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-3.1.0.js"></script>
<jsp:include page="../comm/header.jsp"></jsp:include>

<style>
   .table-responsive, .unit, .table-info{
      border: hidden;
   }
</style>
<!-- 소스시작  -->
<script type="text/javascript">

	$(function() {
		
		$("#reviewForm").hide();
		
		$("#reviewBtn").on("click", function() {
			$("#reviewForm").show();
		})
	});
</script>
<style>
	 a:link { color: black; text-decoration: none;}
 	a:visited { color: black; text-decoration: none;}
	 a:hover { color: blue; text-decoration: underline;

</style>
<body>

   <%@include file="../comm/nav.jsp"%>
   <!-- test -->
   <div></div>
   <section class="cart-page page fix">
      <!--Start Cart Area-->
      <div class="container">
         <div class="row">
            <div class="col-sm-4 col-md-3">
               <div class="single-sidebar">
                  <h2>내 정보</h2>
                  <ul align="center">
                     <li><a href="/memberInfo">회원 정보</a></li>
                     <li><a href="/memberOrderInfo">주문 내역</a></li>
                     <li><a href="/memberQaInfoList">문의 내역</a></li>
                  </ul>
               </div>
            </div>
            <div class="col-sm-8 col-md-9">
               <div class="table-responsive">
                  <table class="table cart-table">      
                     <thead class="table-title">            
                        <tr>
                           <th class="qaScNo">문의번호</th>
                           <th class="qaScTitle" colspan="5">제목</th>
                           <th class="qaScReg">문의날짜</th>
                           <th class="qaScState">답변상태</th>
                        </tr>
                     </thead>
                     <tbody>
                     	<c:forEach items="${qalist}" var="list" varStatus="status">
                     	<tr>
                     		<td class="unit">${status.count}</td>
                     		<td class="unit" colspan="5"><a href="/memberQaInfo?qaScNo=${list.qaScNo}">${list.qaScTitle}</a></td>
                     		<td class="unit">${list.qaScReg}</td>
                     		<td class="unit">${list.qaScStat}</td>
                     	</tr>
                     	</c:forEach>	
                     </tbody>
                  </table>
               </div>
               <div class="col-sm-6 col-md-7"></div>
            </div>         
         </div>
      </div>
   </section>   
   <!--End Cart Area-->
   <br><br><br>
   
   <jsp:include page="../comm/footer.jsp"></jsp:include>
</body>
</html>