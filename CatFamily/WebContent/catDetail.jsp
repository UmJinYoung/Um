<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qaDetail.jsp</title>
   <style>
	  font {
	  	text-align: center;
	  	font-weight: normal
	  }

	.button {
	  padding: 0.75em 2em;
	  text-align: center;
	  text-decoration: none;
	  color: $color;
	  border: 2px solid $color;
	  font-size: 16px;
	  display: inline-block;
	  border-radius: 0.3em;
	  transition: all 0.2s ease-in-out;
	  position: relative;
	  overflow: hidden;
  	&:before {
    content: "";
    background-color: rgba(255,255,255,0.5);
    height: 100%;
    width: 2em;
    display: block;
    position: absolute;

    left: -4.5em;
    transform: skewX(-45deg) translateX(0);
    transition: none;
  }
  &:hover {
    background-color: $color;
    color: #fff;
    border-bottom: 4px solid darken($color, 10%);
    &:before {
      transform: skewX(-45deg) translateX(13.5em);
     transition: all 0.5s ease-in-out;
    }
  }
	</style>
	
	<script type="text/javascript">

	</script>
	<jsp:include page="top.jsp"></jsp:include>
  </head>
<body>

<center>
		<br><br><br>
		<font style='font-size:15pt; color:black'> ${cat.cat_name} </font><p><br>	
    	<img src="images/${cat.cat_img2}" width="650" height="650" style="float:center; margin:0; padding:0;"></a><p><br>
  		<img src="images/${cat.cat_img3}" width="850" height="500" style="float:center; margin:0; padding:0;"></a><p><br>
  		<img src="images/${cat.cat_img4}" width="850" height="2000" style="float:center; margin:0; padding:0;"></a>
  				
		<div>
		<c:if test="${sessionScope.sessionID!=null}">
  		<input type="button" value="분양신청" onclick="location.href='catinsert.do?idx=${cat.cat_name}&idx2=${sessionScope.sessionID}'" class="button">
  		</c:if>
  		<input type="button" value="뒤로가기" onclick="location.href='catlist.do'" class="button">
  		</div>
  		<br><br>
</center>
</body>
<jsp:include page="Bottom.jsp"></jsp:include>
</html>