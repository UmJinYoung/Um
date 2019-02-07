<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ page import="net.hb.common.DBDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guestDeleteSave.jsp]</title></head>
<body>
 <%
   //guestDeleteSave.jsp
   int data=Integer.parseInt(request.getParameter("idx"));
   //ssiCopy.jsp
   //DBDAO 직접접근 
   //<jsp:useBean
   DBDAO  dao= new DBDAO( );
   dao.dbDelete(data);
   response.sendRedirect("guestList.jsp"); 
 %>
</body>
</html>


















