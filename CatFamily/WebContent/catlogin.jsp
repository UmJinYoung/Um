<%@ page language="java" contentType="text/html; charset=UTF-8"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title> [catlogin.jsp]</title>
  <style type="text/css">
  	.input_group {
	 height: 20px;
	 font: 1em/50px 'Helvetica';
	}
	.input_group > label {
	   font-size:18px;
	} 
	.loginlegend {
		font-size:30pt;
		font-family:italic;
		color:grey;
	}
  </style>
  
 <jsp:include page="top.jsp"></jsp:include>
 
  <script type="text/javascript">
  function checkValue()
  {
      inputForm = eval("document.loginInfo");
      if(!inputForm.Log_id.value)
      {
          alert("아이디를 입력하세요");    
          inputForm.Log_id.focus();
          return false;
      }
      if(!inputForm.Log_pw.value)
      {
          alert("비밀번호를 입력하세요");    
          inputForm.Log_pw.focus();
          return false;
      }
  }

  </script>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>	
<body>
<center>
	<div id="wrap">
        <form name="loginInfo" method="post" action="catlogin.do" onsubmit="return checkValue()">
        
            <!-- 이미지 추가 -->
            <br><br>
            
             <div align="center">
  	<legend class="loginlegend">LOGIN</legend>
  </div><br>
  
            <table align="center">
                <tr>
                    <td >ID</td>
                    <td><input type="text" name="Log_id" maxlength="50"></td>
                </tr>
                <tr>
                    <td>PW</td>
                    <td><input type="password" name="Log_pw" maxlength="50"></td>
                </tr>
            </table>
            <div align="center">
            <input type="submit"  value="로그인"/>
            <input type="button" value="회원가입" onclick="location.href='catjoin.jsp'"/>
            </div>
        </form>
</center>
</body>
 <jsp:include page="Bottom.jsp"></jsp:include>
</html>
