<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- ��� �κ� -->
 <table border="1" bordercolor="lightgray">
        
    <!-- ��� ��� -->    
    <c:if test="${requestScope.commentList != null}">
        <c:forEach var="comment" items="${requestScope.commentList}">
            <tr>
                <!-- ���̵�, �ۼ���¥ -->
                <td id="b"  width="100" align="center">
                        <font style='font-size:11pt; color:gray'>${comment.comment_id}<font style='font-size:11pt; color:gray'><br>
                        <font style='font-size:11pt; color:lightgray'>${comment.comment_date}</font>
                </td>
                <!-- �������� -->
                <td id="b"  width="550">
                       <font style='font-size:11pt; color:black'> ${comment.comment_content} </font>
                </td>
                <!-- ��ư -->
                <td id="b"  width="100" align="center">
                    <!-- ��� �ۼ��ڸ� ����, ���� �����ϵ��� -->    
                    <c:if test="${comment.comment_id == sessionScope.sessionID}">
                        <input type="submit" onclick="cmUpdateOpen(${comment.comment_num})" value="����">  
                        <input type="submit" onclick="cmDeleteOpen(${comment.comment_num}, ${bean.num})" value="����">
                    </c:if>        
                </td>
            </tr>
        </c:forEach>
    </c:if>
            
            <!-- �α��� ���� ��츸 ��� �ۼ����� -->
            <c:if test="${sessionScope.sessionID !=null}">
            <tr bgcolor="#F5F5F5">
            <form id="writeCommentForm" action="replywrite.do">
            	<input type="hidden" name="comment_qanum" value="${bean.num}">
                <input type="hidden" name="comment_board" value="${bean.num}">
                <input type="hidden" name="comment_id" value="${sessionScope.sessionID}">
                <!-- ���̵�-->
                <td id="b" width="100" align="center">

                        <font style='font-size:11pt; color:gray'>${sessionScope.sessionID}</font>

                </td>
                <!-- ���� �ۼ�-->
                <td id="b"  width="550">

                        <textarea name="comment_content" rows="7" cols="199" style="font-size:12px; font-color:gray"></textarea>

                </td>
                <!-- ��� ��� ��ư -->
                <td id="b" width="100" align="center">
                        <input type="submit" value="���">
                </td>
            </form>
            </tr>
            </c:if>
    
        </table>

</body>
</html>