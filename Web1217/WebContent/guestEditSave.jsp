<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="./ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guestEditSave.jsp]</title></head>
<body>
 <%
   //guestEditSave.jsp 단독실행하면 에러발생
   Gsabun=Integer.parseInt(request.getParameter("sabun"));
   Gname=request.getParameter("name");
   Gtitle=request.getParameter("title");
   Gpay=Integer.parseInt(request.getParameter("pay"));
    
   msg="update guest set name=?,title=?,nalja=sysdate,pay=? where sabun=?";
   PST=CN.prepareStatement(msg); 
   	   PST.setString(1, Gname);
   	   PST.setString(2, Gtitle);
   	   PST.setInt(3, Gpay);
   	   PST.setInt(4,Gsabun);
   PST.executeUpdate();
   response.sendRedirect("guestList.jsp");
 %>
  
</body>
</html>




















