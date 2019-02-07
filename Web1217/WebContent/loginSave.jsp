<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="./ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [loginSave.jsp]</title></head>
<body>
 <%
  //var url="loginSave.jsp?UID="+a+"&UPWD="+b;
  String a=request.getParameter("UID");
  String b=request.getParameter("UPWD");
  msg="select count(*) as cnt from login where userid=? and pwd=?";
  PST=CN.prepareStatement(msg);
  	PST.setString(1, a);
  	PST.setString(2, b);
  RS=PST.executeQuery();
  if(RS.next()==true){ Gtotal=RS.getInt("cnt");}
  if(Gtotal>0){	
%>	
  <font color=blue size=7><b> <%=a%> Login Success!!! </b></font><p>
  <img src="images/bar.gif"  width=750><br>
  <img src="images/bar.gif"  width=750><br>
  <img src="images/bar.gif"  width=750><br>	
<%	  
  }else{ 
%>
   <font style="font-size:20pt; font-family: comic Sans MS;"><b><%=a %>Login Failed !!! </b></font><p>
   <font color=blue><b><a href=login.jsp>[login]</a></b></font>
   <font color=blue><b><a href=index.jsp>[index]</a></b></font>
<%    
  }
 %>
 
</body>
</html>


















