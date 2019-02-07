<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[BoardDetail.jsp]</title>
   <style>
	  table {
	    width: 70%;
	    border-collapse: collapse;
	    font-size:12px;
    	border-collapse: collapse;
    	background-color:white;
    	border-bottom:white;
	  }
	  th{
	  	background-color:white;
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
<jsp:include page="top.jsp"></jsp:include>
  </head>
<body>
<center>

<table width="600" height="600" border="0" background-color:white;>
	<tr>
		<th align="left">제목 : ${bean.title} </th>
		<th align="right">${bean.nalja}</th>
		
	</tr>
	<tr >
		<th align="left" width="100">${bean.id}</th>
		
	</tr>
	<tr width="300" height="600">
		<th align="left"> <img src="./resources/upload/${bean.img_file_name}" width="300", height="300">${bean.content}</th>
		<th></th>
	</tr>
</table>    
<br>
			<c:if test="${bean.id == sessionScope.login}">
			<input type="button" onClick="location.href='boardpreEdit.do?idx=${bean.idx}'" value="수정">
 			<input type="button" onclick="location.href='boarddelete.do?idx=${bean.idx}'" value="삭제">
 			</c:if>
 			<input type="button" onclick="location.href='boardlist.do'" value="목록">
 			
<br>
<br>
<br>
 
</center>
</body>
</html>