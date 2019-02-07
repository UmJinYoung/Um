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
	
	<script type="text/javascript">
	
	var httpRequest = null;
    
    // httpRequest 객체 생성
    function getXMLHttpRequest(){
        var httpRequest = null;
    
        if(window.ActiveXObject){
            try{
                httpRequest = new ActiveXObject("Msxml2.XMLHTTP");    
            } catch(e) {
                try{
                    httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e2) { httpRequest = null; }
            }
        }
        else if(window.XMLHttpRequest){
            httpRequest = new window.XMLHttpRequest();
        }
        return httpRequest;    
    }

	function cmUpdateOpen(comment_num){
        window.name = "parentForm";
        window.open("replyedit2.do?num="+comment_num,
                    "replyedit2", "width=570, height=350, resizable = no, scrollbars = no");
    }
	
	function cmDeleteOpen(comment_num, comment_qanum){
        var msg = confirm("댓글을 삭제합니다.");    
        if(msg == true){ // 확인을 누를경우
            deleteCmt(comment_num, comment_qanum);
        }
        else{
            return false; // 삭제취소
        }
    }

	
	function deleteCmt(comment_num, comment_qanum)
    {
	//	alert(comment_num+""+comment_qanum);
        var param="comment_num="+comment_num ;
        httpRequest = getXMLHttpRequest();
        httpRequest.onreadystatechange = checkFunc;
        httpRequest.open("POST", "replydelete.do?num="+comment_num+"&qanum="+comment_qanum, true);    
        httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=EUC-KR'); 
        httpRequest.send(param);
        
    }
	
	function checkFunc(){
        if(httpRequest.readyState == 4){
            // 결과값을 가져온다.
            var resultText = httpRequest.responseText;
            if(resultText == 1){ 
            	alert("삭제완료");
                document.location.reload(); // 상세보기 창 새로고침
            }
        }
    }

	</script>
<jsp:include page="top.jsp"></jsp:include>
  </head>
<body>
<center>
<div align="center">
<table width="600" height="600" border="0" background-color:white;>
	<tr>
		<th align="left">제목 : ${bean.title} </th>
		<th align="right">${bean.nalja}</th>
		
	</tr>
	<tr >
		<th align="left" width="100">${bean.id}</th>
		<th align="right" width="100">조회수 : ${bean.vi} </th>
	</tr>
	<tr width="300" height="600">
		<th align="left">${bean.content} </th>
		<th></th>
	</tr>
</table>    
<br>
			<c:if test="${bean.id == sessionScope.sessionID}">
			<input type="button" onClick="location.href='edit.jsp?idx=${bean.id}&idx2=${bean.num}'" value="수정">
 			<input type="button" onclick="location.href='qadelete.do?idx=${bean.num}'" value="삭제">
 			</c:if>
 			<input type="button" onclick="location.href='qalist.do'" value="목록">
 			
<br>
<br>
<br>
	
	<!-- 댓글 부분 -->
 <table border="1" bordercolor="lightgray">
        
    <!-- 댓글 목록 -->    
    <c:if test="${requestScope.commentList != null}">
        <c:forEach var="comment" items="${requestScope.commentList}">
            <tr>
                <!-- 아이디, 작성날짜 -->
                <td id="b"  width="100" align="center">
                        <font style='font-size:11pt; color:gray'>${comment.comment_id}<font style='font-size:11pt; color:gray'><br>
                        <font style='font-size:11pt; color:lightgray'>${comment.comment_date}</font>
                </td>
                <!-- 본문내용 -->
                <td id="b"  width="550">
                       <font style='font-size:11pt; color:black'> ${comment.comment_content} </font>
                </td>
                <!-- 버튼 -->
                <td id="b"  width="100" align="center">
                    <!-- 댓글 작성자만 수정, 삭제 가능하도록 -->    
                    <c:if test="${comment.comment_id == sessionScope.sessionID}">
                        <input type="submit" onclick="cmUpdateOpen(${comment.comment_num})" value="수정">  
                        <input type="submit" onclick="cmDeleteOpen(${comment.comment_num}, ${bean.num})" value="삭제">
                    </c:if>        
                </td>
            </tr>
        </c:forEach>
    </c:if>
            
            <!-- 로그인 했을 경우만 댓글 작성가능 -->
            <c:if test="${sessionScope.sessionID !=null}">
            <tr bgcolor="#F5F5F5">
            <form id="writeCommentForm" action="replywrite.do">
            	<input type="hidden" name="comment_qanum" value="${bean.num}">
                <input type="hidden" name="comment_board" value="${bean.num}">
                <input type="hidden" name="comment_id" value="${sessionScope.sessionID}">
                <!-- 아이디-->
                <td id="b" width="100" align="center">

                        <font style='font-size:11pt; color:gray'>${sessionScope.sessionID}</font>

                </td>
                <!-- 본문 작성-->
                <td id="b"  width="550">

                        <textarea name="comment_content" rows="7" cols="199" style="font-size:12px; font-color:gray"></textarea>

                </td>
                <!-- 댓글 등록 버튼 -->
                <td id="b" width="100" align="center">
                        <input type="submit" value="등록">
                </td>
            </form>
            </tr>
            </c:if>
    
        </table>
    </div>
</center>
</body>
 <jsp:include page="Bottom.jsp"></jsp:include>
</html>