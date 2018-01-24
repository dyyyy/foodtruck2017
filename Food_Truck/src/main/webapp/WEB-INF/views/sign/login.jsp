<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>    
<html>


<script>
   // 라디오버튼 회원 / 비회원 체크 
   function memberCheck(num) {
      
      if(num == 1) {
         mem_login.style.display = 'block';
         non_login.style.display = 'none';
      } else if(num == 2) {
         mem_login.style.display = 'none';
         non_login.style.display = 'block';
      }
   }

   
</script>


<jsp:include page="../comm/header.jsp"></jsp:include>
<body>

<%@include file="../comm/nav.jsp" %>

<div class="login-page page fix"><!--start login Area-->
   <div class="container">
      <div class="row2">
         <div class="col-sm-6 col-md-5">
            <div class="login">
               <form name="login_form" method="post" action="/login">
                  <div class="join" align="center">
                        <label><input type="radio" name="gubun" id="memberY" value="1" onclick ="memberCheck(1)" checked>회원&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="gubun" id="memberN" value="2" onclick ="memberCheck(2)">비회원</label>
                  </div><br><br>
                  <div id="mem_login" style="display:block">
					 <h2>Login</h2>
             	     <p>Welcome to your account</p>
                     <label>ID<span>*</span></label>
                     <input type="text" name="id" />
                     <label>Password<span>*</span></label>
                     <input type="password" name="pw"/>
                     <div class="remember">
                        <input type="checkbox" />
                        <p>Remember me!</p>
                        <a href="/findAccount">Forgot Your Password ?</a>
                     </div>
                     <p><input type=submit value="login" /></p>
                  </div>
               </form>
               <form name="nonMember_form" method="post" action="/nonMemberOrderDetail">
                  <div id="non_login" style="display:none">
					 <h2>Search</h2>
             	     <p>HIHIHIHIHIHIHIHIHIHI</p>                  
                     <label>주문번호<span>*</span></label>
                     <input type="text" name="ordNo" />
                     <label>전화번호<span>*</span></label>
                     <input type="text" name="ordTel" />
                     <p><input type="submit" value="search" /></p>
                  </div>
               </form>
            </div>
         </div>
      </div>
   </div>
</div>
<!--End login Area-->

<BR><BR><BR><BR>

<jsp:include page="../comm/footer.jsp"></jsp:include>

</body>
</html>