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
      if(!inputForm.id.value)
      {
          alert("아이디를 입력하세요");    
          inputForm.id.focus();
          return false;
      }
      if(!inputForm.pwd.value)
      {
          alert("비밀번호를 입력하세요");    
          inputForm.pwd.focus();
          return false;
      }
  }

  </script>
  <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>	
<body>
	<div id="wrap">
        <form name="loginInfo" method="post" action="loginProcess.do" onsubmit="return checkValue()">
        
            <!-- 이미지 추가 -->
            <br><br>
            
            <table>
                <tr>
                    <td bgcolor="skyblue">아이디</td>
                    <td><input type="text" name="id" maxlength="50"></td>
                </tr>
                <tr>
                    <td bgcolor="skyblue">비밀번호</td>
                    <td><input type="password" name="pwd" maxlength="50"></td>
                </tr>
            </table>
            <br>
            <input type="submit" value="로그인"/>
            <input type="button" value="회원가입" onclick="location.href='join.do'" />
        </form>   
    </div> 
 </body>

</html>
