<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guest.jsp]</title>  

  <style type="text/css">
    *{font-size:20pt; font-weight:bold;  font-family:  Segoe UI Symbol , comic Sans MS ;  }
    a{font-size:20pt; font-weight:bold; color:blue; text-decoration:none; }
    a:hover{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }                
  </style>
  
 <script type="text/javascript">

 </script>   
</head>

<body>
	<font color=blue> [guest.jsp] </font><p>
	<form name="myform" action="insert.do">
	   사번: <input type="text" name="sabun"> <br>
	   이름: <input type="text" name="name" value="LG"> <br>
	   제목: <input type="text" name="title" value="blue" > <br>
	   급여: <input type="text" name="pay"  value="97" > <p> 
	     <input type="submit" value="MVC2데이터저장">
	     <input type="reset"  value="입력취소">
	</form>
	
<p>
  <a href="index.jsp">[index]</a>
  <a href="guest.jsp">[신규등록]</a>
  <a href="list.do">[전체출력]</a>
  <a href="ssi.jsp">[ssi]</a>
  

 
</body>
</html>













