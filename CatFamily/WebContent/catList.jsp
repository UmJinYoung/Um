<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guestList.jsp]</title>
 
  <style type="text/css">
    *{font-size:10pt; font-weight:bold;  font-family: Comic Sans MS ; }
    a{font-size:10pt; font-weight:bold; color:gray; text-decoration:none;}
    a:hover{font-size:10pt; font-weight:bold; color:gray; text-decoration:underline; }  
    img:hover{
    	webkit-transform:scale(1.2,1.2); opacity:1; border:solid 1px  #FF3399;

    }    
    
 
              
  </style>
<jsp:include page="top.jsp"></jsp:include>
 
 </head>
<body>
<center>
  <c:set var="i" value="0" />
  <c:set var="j" value="3" />
  	<br><br>
    <font style='font-size:24pt; color:gray'>고양이 분양</font>
    <br><br>
  <table width=900 border=0 cellspacing=0 align="center"> 
  				
  		<c:forEach var="dto" items="${qa}">
  		<c:if test="${i%j == 0}">
  		<tr align="center">
		</c:if>
			<td>
    		<a href="catdetail.do?idx=${dto.cat_num}"><img src="images/${dto.cat_img1}" width="280" height="280" style="float:center; margin:0; padding:0;"></a><p><p>
  			<a href="catdetail.do?idx=${dto.cat_num}">${dto.cat_name}</a> <br><br>
  			</td>

  		<c:if test="${i%j == j-1}">
  		</tr>
  		</c:if>
  		
	    <c:set var="i" value="${i+1}" />
		</c:forEach>
		
<tr align="center">


   <td colspan="5">
 	<c:if test="${startpage>10}">
 	   <a href="catlist.do?pageNum=${startpage-10}">이전</a>
 	</c:if>
 	
 	<c:forEach var="i" begin="${startpage}" end="${endpage}">
 	   <c:choose>
 	     <c:when test="${i==pageNUM}">
 	      <font style='font-size:12pt; color:red'> ${i} </font> 
 	     </c:when>
 	     <c:otherwise> 
 	      <a href="catlist.do?pageNum=${i}&keyfield=${keyfield}&keyword=${keyword}">${i}</a>
 	     </c:otherwise>
 	   </c:choose>	
 	</c:forEach>
     
   <c:if test="${endpage<pagecount}">
	 <a href="catlist.do?pageNum=${startpage+10}"> 다음</a>
   </c:if>
   </td>
  </tr>
  </table>
  <br><br>
 </center>
</body>
 <jsp:include page="Bottom.jsp"></jsp:include>
</html>