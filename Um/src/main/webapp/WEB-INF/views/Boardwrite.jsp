<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[Boardwrite.jsp]</title>
   <style>
     table {
       width: 50%;
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
     .write {
        color:grey;
       font-size:30pt;
     }
   </style>
<jsp:include page="top.jsp"></jsp:include>
  </head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<center>
   <br><br>
    <font style='font-size:24pt; color:gray'>W R I T E </font>
    <br><br>
  <br>
<form action="boardinsert.do?id=${sessionScope.login}" enctype="multipart/form-data" method="post">

<table width="400" border="0" align="center">
   <tr height="40" >
      
      <td align="left">제목</td><td width="10" > <input type="text" name="title" size="100"></td>
   </tr>
   <tr height=400 >
      <td width="300" colspan="2"><textarea rows="15" cols=110 name="content"></textarea></td>
   </tr>
   <tr>
   	<td colspan="2">파일:<input type="file" name="upload_f"></td><p>  <!-- img_file_name이름대신 upload__f -->
   	</tr>
   </table>
   
<br><br>
   <tr height="40">
      <td align="center" colspan="2">
         <input type="submit" value="완료">&nbsp;&nbsp;
         <input type="reset" value="리셋">&nbsp;&nbsp;
         <input type="button" value="뒤로" onclick="location.href='boardlist.do'">
      </td>
   </tr>
</form>
<br><br>
</center>
</body>
</html>