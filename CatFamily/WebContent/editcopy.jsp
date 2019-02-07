<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<body>
<center>
<h2> 게시글 쓰기 </h2>
<%
	String id=request.getParameter("idx");
	String num=request.getParameter("idx2");
%>
<form action="edit.do?idx=<%=num%>" method="post">
<table width="600" border="1" bordercolor="gray" bgcolor="skyblue">
	<tr height="40" >
		<td align="center" width="150"> 작성자 </td>
		<td width="450"> <input type="hidden" name="id"> <%=id %> </td>
	</tr>
	<tr height="40" >
		<td align="center" width="150"> 제목 </td>
		<td width="450"> <input type="text" name="title" size="60"></td>
	</tr>
	<tr height="40" >
		<td align="center" width="150"> 글내용 </td>
		<td width="450"><textarea rows="10" cols="60" name="content"></textarea></td>
	</tr>
	<tr height="40" >
		<td align="center" colspan="2">
			<input type="submit" value="완료">&nbsp;&nbsp;
			<input type="button" onclick="location.href='qalist.do?idx=<%=id%>'" value="뒤로가기">&nbsp;&nbsp;
		</td>
	</tr>
</table>
</form>
</center>
</body>
 <jsp:include page="Bottom.jsp"></jsp:include>
</html>