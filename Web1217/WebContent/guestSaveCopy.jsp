<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ page import="net.hb.common.DBbean" %>
<%@ page import="net.hb.common.DBDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guestSaveCopy.jsp]</title></head>
<body>
 <%
  //guestSaveCopy.jsp 단독실행하면 에러발생
   int a=Integer.parseInt(request.getParameter("sabun"));
   String b=request.getParameter("name");
   String c=request.getParameter("title");
   int d=Integer.parseInt(request.getParameter("pay"));
   	//bean개체미사용, 비권장하는 메소드 저장처리  
   	//dao.dbInsert(a,b,c,d);
   	
   	//jsp문서 자바문서 직접연결 MVC1=mvc
      			
   	DBbean bc=new DBbean( );
   	DBDAO bc_dao=new DBDAO( );
   	
   	 bc.setSabun(a);
   	 bc.setName(b);
   	 bc.setTitle(c);
   	 bc.setPay(d);
   	 bc_dao.dbInsert(bc); //권장
   
    //response.sendRedirect("guestList.jsp"); 
 %>
  
  <jsp:useBean id="sk" class="net.hb.common.DBbean" />
  <jsp:useBean id="dao" class="net.hb.common.DBDAO" />
  <%
     sk.setSabun(a);
	 sk.setName(b);
	 sk.setTitle(c);
	 sk.setPay(d);
     dao.dbInsert(sk); 
     response.sendRedirect("guestList.jsp"); 
  %>
</body>
</html>


















