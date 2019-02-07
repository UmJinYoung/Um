<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title> [member.jsp]</title>
  <style type="text/css">
  	table {
	    width: 70%;
	    border-collapse: collapse;
	    font-size:12px;
    	border-top: 1px solid black;
    	border-collapse: collapse;
    	background-color:white;
    	border-bottom:white;
    	
	  }
	  th{
	  	background-color:#e7e7e7;
	    border-bottom: 1px solid #444444;
	    
	    padding: 10px;
	    font-size:12px;
	    border-color: #dedede;
	    font-weight: normal
	    
	  }
	  td {
	 	border-bottom: 1px solid #444444;
	    padding: 10px;
	    font-size:13px;
	    border-color: #dedede;
	    font-weight: normal
	  }

  </style>
  <script src="./js/jquery-3.3.1.min.js"></script>
  <jsp:include page="top.jsp"></jsp:include>
</head>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="./js/InputJS.js"></script>
	
			<script type="text/javascript">
			
			function email() {
			      if (iform.emailin.value == '1') {
			         iform.email2.readonly = false;
			         iform.email2.value = '';
			         iform.email2.focus();
			      } else {
			         iform.email2.readonly = true;
			         iform.email2.value = iform.emailin.value;
			      }
			   }
			
			</script>		
			
 <body>
  <center>
    <br><br>
  	<font style='font-size:24pt; color:gray'>회 원 정 보 수 정 </font>
    <br><br>
 

 <form name="iform" method="post">
   <table>
   	 <tr>
   	 	<td> 아이디 :</td>
   	 	<td> <input type="hidden" name="id" value="${sessionScope.sessionID}">
				${sessionScope.sessionID}  </td>
   	 </tr>
   	 <tr>
   	 	<td> 비밀번호 : </td>
   	 	<td> <input type="password" name="pwd" id="pwd" />
   	 </tr>
   	 <tr>
   	 	<td> 비밀번호 확인 : </td>
   	 	<td> <input type="password" name="pwd2"
               id="pwd2" onkeyup="checkPwd();"> <label id="pwdlabel">&nbsp;&nbsp;비밀번호를
              	 한번 더 입력해주세요.</label>
   	 </tr>
   	 <tr>
   	 	<td> 이름 :  </td>
   	 	<td> <input type="text" name="name" id="name" /> </td>
   	 </tr>
   	 <tr>
   	 	<td> 생년월일 : </td>
   	 	<td> </label> <input type="text" name="birth1"
               id="birth1" size="5">년 <input type="text" name="birth2"
               id="birth2" size="5">월 <input type="text" name="birth3"
               id="birth3" size="5">일 </td>
   	 </tr>
   	 <tr>
   	 	<td> 이메일 : </td>
   	 	<td> <input type="text" name="email1" id="email1" />
            @ <input type="text" name="email2" id="email2" /> 
            <select   name="emailin" onChange="email();" id="emailin">
               <option value="input">이메일선택</option>
               <option value="naver.com">naver.com</option>
               <option value="gmail.com">gmail.com</option>
               <option value="daum.net">daum.net</option>
               <option value="nate.com">nate.com</option>
            </select> </td>
   	 </tr>
   	 <tr>
   	 	<td> 전화번호 : </td>
   	 	<td>  <select name="phone1"
               id="phone1">
               <option value="010">010</option>
               <option value="011">011</option>
               <option value="012">012</option>
               <option value="013">013</option>
               <option value="014">014</option>
               <option value="015">015</option>
               <option value="016">016</option>
               <option value="017">017</option>
               <option value="018">018</option>
               <option value="019">019</option>
            </select> - <input type="text" name="phone2" id="phone2" size="5"> -
            <input type="text" name="phone3" id="phone3" size="5">
        </td>
   	 </tr>
   	 <tr>
   	 	<td> 주소 : </td>
   	 	<td> <input type="text" size="30" id="juso1" name="juso1" readonly>  <input type="text" size="10" id="code"
                  name="code" readonly> <input type="button"
                  onclick="DaumPostcode()" value="우편번호">
        </td>
   	 </tr>
   	 <tr>
   	 	<td> 상세주소 : </td>
   	 	<td> <input type="text" size="30" id="juso2" name="juso2"
                        onkeyup="checklen(this,30)">
        </td>
   	 </tr>
   </table>
   <br>
   
   <input type="button" value="수정완료"  onclick="location.href='memberedit.do'">
   <input type="reset" value="취소" ><br><br>
  </form>
 </center>
 </body>
  <jsp:include page="Bottom.jsp"></jsp:include>
</html>