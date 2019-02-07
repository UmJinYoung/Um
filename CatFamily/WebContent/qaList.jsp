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
	  
	</style>

  <script type="text/javascript">
	function changeclear( ){
//		alert("dd");
		document.getElementById(keyword).value = "";
		
	}//end
  </script>
  <jsp:include page="top.jsp"></jsp:include>
</head>
<body>
<form action="qalist.do">
<center>
	<br><br>
    <font style='font-size:24pt; color:gray'>질문과 답변</font>
    <br><br>
	<table width=900 border=0 cellspacing=0 id="a"  bgcolor="white">
</center>
		<tr>
	    <td colspan=5 align="right"> 게시글 수 : ${Gtotal} &nbsp;&nbsp;</td>
	    </tr>
		<tr>
          <td colspan="2" width=300 align="center">제목</td>
          <td align="left">작성자</td>
          <td align="center">작성일</th>
          <td align="center">조회</th>
        </tr>
        
        <tr>  
          <th align="left"> <font style='font-size:11pt; color:red'> 공지 </font> </th>
          <th align="left"> <font style='font-size:11pt; color:red'> [이벤트] --------------알립니다. </font></th>
          <th align="left"> <font style='font-size:11pt; color:gray'>운영자</font> </th>
          <th align="center"> <font style='font-size:11pt; color:gray'>2019.01.10</font> </th>
          <th align="center"> <font style='font-size:11pt; color:gray'>1만</font> </th>
        </tr>
        
        <tr>  
          <th align="left"> <font style='font-size:11pt; color:red'> 공지 </font> </th>
          <th align="left"> <font style='font-size:11pt; color:red'> [이벤트] --------------알립니다. </font></th>
          <th align="left"> <font style='font-size:11pt; color:gray'>운영자</font> </th>
          <th align="center"> <font style='font-size:11pt; color:gray'>2019.01.10</font> </th>
          <th align="center"> <font style='font-size:11pt; color:gray'>1만</font> </th>
        </tr>
        
        <tr>  
          <th align="left"> <font style='font-size:11pt; color:red'> 공지 </font> </th>
          <th align="left"> <font style='font-size:11pt; color:red'> [이벤트] --------------알립니다. </font></th>
          <th align="left"> <font style='font-size:11pt; color:gray'>운영자</font> </th>
          <th align="center"> <font style='font-size:11pt; color:gray'>2019.01.10</font> </th>
          <th align="center"> <font style='font-size:11pt; color:gray'>1만</font> </th>
        </tr>
        
        <tr>  
          <th align="left"> <font style='font-size:11pt; color:red'> 공지 </font> </th>
          <th align="left"> <font style='font-size:11pt; color:red'> [이벤트] --------------알립니다. </font></th>
          <th align="left"> <font style='font-size:11pt; color:gray'>운영자</font> </th>
          <th align="center"> <font style='font-size:11pt; color:gray'>2019.01.10</font> </th>
          <th align="center"> <font style='font-size:11pt; color:gray'>1만</font> </th>
        </tr>
        
        <tr>  
          <th align="left"> <font style='font-size:11pt; color:red'> 공지 </font> </th>
          <th align="left"> <font style='font-size:11pt; color:red'> [이벤트] --------------알립니다. </font></th>
          <th align="left"> <font style='font-size:11pt; color:gray'>운영자</font> </th>
          <th align="center"> <font style='font-size:11pt; color:gray'>2019.01.10</font> </th>
          <th align="center"> <font style='font-size:11pt; color:gray'>1만</font> </th>
        </tr>
        
        <tr>  
          <th align="left"> <font style='font-size:11pt; color:red'> 공지 </font> </th>
          <th align="left"> <font style='font-size:11pt; color:red'> [이벤트] --------------알립니다. </font></th>
          <th align="left"> <font style='font-size:11pt; color:gray'>운영자</font> </th>
          <th align="center"> <font style='font-size:11pt; color:gray'>2019.01.10</font> </th>
          <th align="center"> <font style='font-size:11pt; color:gray'>1만</font> </th>
        </tr>
        
        <tr>  
          <th align="left"> <font style='font-size:11pt; color:red'> 공지 </font> </th>
          <th align="left"> <font style='font-size:11pt; color:red'> [이벤트] --------------알립니다. </font></th>
          <th align="left"> <font style='font-size:11pt; color:gray'>운영자</font> </th>
          <th align="center"> <font style='font-size:11pt; color:gray'>2019.01.10</font> </th>
          <th align="center"> <font style='font-size:11pt; color:gray'>1만</font> </th>
        </tr>
        
        
		<c:forEach var="dto" items="${qa}"> 
		<tr align="left">	
			<td><font style='font-size:9pt; color:gray'>${dto.rn}</font></td>	
			<td><font style='font-size:11pt; color:black'><a href="detail.do?idx=${dto.num}">${dto.title} [${dto.replycnt}] </a></font></td> 
			<td align="left"><font style='font-size:11pt; color:gray'>${dto.id}</font></td>
			<td align="center"><font style='font-size:11pt; color:gray'>${dto.nalja}</font></td>
			<td align="center"><font style='font-size:11pt; color:gray'>${dto.vi}</font></td>
		</tr>
		</c:forEach>
		
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td align=right> <input type="button" style="font-size:10px" value="글쓰기" onclick="location.href='write.jsp?idx=${sessionScope.sessionID}'" > </td>
		</tr>
	</table>
	
	
	
	
	<br><br>
	
	<table width="70%" border=0 cellspacing=0 bgcolor=#e7e7e7>
		 <tr align="center">
   <td colspan="5">
 	<c:if test="${startpage>10}">
 	   <a href="qalist.do?pageNum=${startpage-10}">[이전]</a>
 	</c:if>
   
 	<c:forEach var="i" begin="${startpage}" end="${endpage}">
 	   <c:choose>
 	     <c:when test="${i==pageNUM}">
 	       <font style='font-size:10pt; color:red'> ${i} </font> 
 	     </c:when>
 	     <c:otherwise> 
 	       <a href="qalist.do?pageNum=${i}&keyfield=${keyfield}&keyword=${keyword}">${i}</a>
 	     </c:otherwise>
 	   </c:choose>	
 	</c:forEach>
     
   <c:if test="${endpage<pagecount}">
	 <a href="qalist.do?pageNum=${startpage+10}">[다음]</a>
   </c:if>

   </td>
  </tr>
  
 <tr align="center">
  	<td colspan="5">
  	 <form name="myform">

  	 	<select name="keyfield">
			<option value="" onclick="changeclear();" selected="selected" >전   체</option>
			<option value="id" <c:if test="${keyfield=='id'}">selected="selected"</c:if>>작성자</option>
			<option value="title" <c:if test="${keyfield=='title'}">selected="selected"</c:if>>제 목</option>
			<option value="content" <c:if test="${keyfield=='content'}">selected="selected"</c:if>>내 용</option>
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