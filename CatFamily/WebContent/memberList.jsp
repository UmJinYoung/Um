<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
	 #a {
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
	  .write {
	  	color:gray;
	 	font-size:12px;
	  }
	  a{font-size:10pt; font-weight:bold; color:black; text-decoration:none;}
      a:hover{font-size:10pt; font-weight:bold; color:black; text-decoration:underline; }  
      
      select {
      	font-size:15px;
      }
      
      option {
      	font-size:15px;
      }
	  
	  .write {
	  	color:grey;
	 	font-size:30pt;
	  }
	</style>

  <script type="text/javascript">
	function changeclear( ){
		alert("dd");
		myform.keyword.value="";
		myform.keyword.focus();
	}//end
  </script>
  <jsp:include page="top.jsp"></jsp:include>
</head>
<body>
<form action="memberlist.do">
<center>
	<br><br>
    <font style='font-size:24pt; color:gray'>M E M B E R</font>
    <br><br>
	<table width=900 border=0 cellspacing=0 id="a"  bgcolor="white">
</center>
		<tr>
	    <td colspan=5 align="right"> MEMBER 수 : ${Gtotal} &nbsp;&nbsp;</td>
	    </tr>
		<tr>
          <th>회원아이디</th>
          <th>회원이름</th>
          <th>휴대폰번호</th>
          <th>이메일</th>
        </tr>
        
        <c:forEach var="dto" items="${member}"> 
		<tr align="center">
			<td>${dto.id}</td>
			<td><a href="memberdetail.do?idx=${dto.id}">${dto.name}</a></td> 
			<td>${dto.phone}</td>
			<td>${dto.email}</td>
		</tr>
		</c:forEach>
	</table>

	<br><br>
	
	<table width="70%" border=0 cellspacing=0 bgcolor=#e7e7e7>
		 <tr align="center">
   <td colspan="5">
   
   <c:if test="${startpage>10}">
 	   <a href="memberlist.do?pageNum=${startpage-10}">[이전]</a>
 	</c:if>
   
 	<c:forEach var="i" begin="${startpage}" end="${endpage}">
 	   <c:choose>
 	     <c:when test="${i==pageNUM}">
 	       <font style='font-size:10pt; color:red'>${i} </font> 
 	     </c:when>
 	     <c:otherwise> 
 	       <a href="memberlist.do?pageNum=${i}&keyfield=${keyfield}&keyword=${keyword}">${i}</a>
 	     </c:otherwise>
 	   </c:choose>	
 	</c:forEach>
     
   <c:if test="${endpage<pagecount}">
	 <a href="memberlist.do?pageNum=${startpage+10}">[다음]</a>
   </c:if>
   </td>
  </tr>
  
 <tr align="center">
  	<td colspan="5">
  	 <form name="myform">

  	 	<select name="keyfield">
			<option value="" onclick="changeclear();" selected="selected" >전   체</option>
			<option value="id" <c:if test="${keyfield=='id'}">selected="selected"</c:if>>아이디</option>
			<option value="name" <c:if test="${keyfield=='name'}">selected="selected"</c:if>>이름</option>
		</select>
		
  	 	<input type="text" name="keyword"  value="" style="font-size:15px; font-color:gray"> 
  	 	<input type="hidden" name="keyword" value="${keyword}"> 

  	 	<input type="submit" value="검 색 " style="font-size:15px"> 
  	 	
  	 </form>
  	</td>
  </tr>	
		<tr align="center">
	</table>
</center>	
</form>
</body>
 <jsp:include page="Bottom.jsp"></jsp:include>
</html>