<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [login.jsp]</title>
  <style type="text/css">
    *{font-size:20pt; font-weight:bold;  font-family:  Segoe UI Symbol , comic Sans MS ;  }
    a{font-size:20pt; font-weight:bold; color:blue; text-decoration:none; }
    a:hover{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }
    #LOGIN{
      font-size:26pt; font-weight:bold;
      background: #FFFF00; height: 120px;
    }             
  </style>
  
  <script type="text/javascript">
    var xhr;
    
    function make( ){
     //xhr= new XMLHttpRequest( );  그리고 사용할때  make( );
     return new XMLHttpRequest( );	
    }//end
    
    function use( ){
      //var a=myform.userid.value;
      //var b=myform.pwd.value;
      var a=document.getElementById("userid").value;
      var b=document.getElementById("pwd").value;
      //alert("userid: " + a +" pwd: " + b) ; 
      xhr=make( );
      var url="loginSave.jsp?UID="+a+"&UPWD="+b;
      //alert(url);  강사컴은 여기까지 처리됨 
      xhr.onreadystatechange=disp; //함수이름만 괄호 있으면 처리안됨
      xhr.open("GET", url, true);
      xhr.send(null);
    }//end
    
    function disp( ){
      if(xhr.readyState==4){
    	 if(xhr.status==200){
    	    var str=xhr.responseText;
    	    document.getElementById("msg").innerHTML=str;
    	 } 
      }	
    }//end
  </script>
</head>

<body>
 <p style="margin:50px;">
 
 <div id="msg" align="center">
 <table  width=750 border=1 cellspacing=0 align="center">
   <form>
     <tr>
	  <td width="450"> <img src="images/x1.gif">userid:<img src="images/x1.gif"> </td>
	  <td width="250"> <input type="text" id="userid" name="userid" ></td>
			
	   <td rowspan=2 align="center">
	    <input type="button" onclick="use();" value="LOGIN" id="LOGIN" >
	   </td>
	</tr>
	
	<tr>
	  <td> <img src="images/x1.gif">userpw:<img src="images/x1.gif"> </td>
	  <td> <input type="text" id="pwd" name="pwd" value="1234"></td>
	</tr>
    </form>
 </table>
</div>

<br>
<div align="center">
	<img src="images/a1.png" width=750 height="250">
</div>
</body>
</html>












