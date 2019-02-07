<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
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

</body>
</html>