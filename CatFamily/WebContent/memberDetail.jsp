<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qaDetail.jsp</title>
   <style>
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
	  .detail {
	  	color:grey;
	 	font-size:30pt;
	  }
	</style>
	
	<script type="text/javascript">

	</script>
<jsp:include page="top.jsp"></jsp:include>
  </head>
<body>
<center>
  <br><br>
  	<font style='font-size:24pt; color:gray'>Member DETAIL </font>
  <br><br>

<table width="600" border="0" align="center">
	<tr height="10" >
		<td align="center" width="150" background-color="gray"> <font style='font-size:11pt; color:black'>아이디</font> </td>
		<td width="200" align="center"> ${bean.id} </td>
	</tr>
	<tr height="10" >
		<td align="center" width="150"> <font style='font-size:11pt; color:black'>이 름</font> </td>
		<td width="200" align="center"> ${bean.title} </td>
	</tr>
	<tr height="10" >
		<td align="center" width="150"> <font style='font-size:11pt; color:black'>생 일</font> </td>
		<td width="200" align="center" > ${bean.phone} </td>
	</tr>
	<tr height="10" >
		<td align="center" width="150"> <font style='font-size:11pt; color:black'>이메일</font> </td>
		<td width="200" align="center"> ${bean.email} </td>
	</tr>
	<tr height=10>
		<td align="center" width="150"> <font style='font-size:11pt; color:black'>휴대폰</font> </td>
		<td width="450" align="center"> ${bean.phone} </td>
	</tr>
	<tr height=10>
		<td align="center" width="150"> <font style='font-size:11pt; color:black'>주 소</font> </td>
		<td width="450" align="center"> ${bean.add1} ${bean.add2 }</td>
	</tr>
	<tr height=10>
		<td align="center" width="150"> <font style='font-size:11pt; color:black'>고양이 분양</font> </td>
		<td width="450" align="center"> ${bean.cat} </td>
	</tr>
	</table>
	<br>
	<input type="button" value="뒤로" onclick="location.href='memberlist.do'">
	
</center>
<br>
</body>
 <jsp:include page="Bottom.jsp"></jsp:include>
</html>