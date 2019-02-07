<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<style>

ul{
    padding:0;
    font-family:"굴림";
    text-align:center;
}
li {
    float: none !important;
   display:inline-block;
   }

.title {
   font-size:45px;
   font-weight: bold;
   letter-spacing:-2px; 
   text-decoration: none
}
div{
   margin-top:20px;
}
nav{
   margin-top:50px;
   text-align: center;
}
.one{
   width:500px; color:red; border:thin; solid red;
}
.my-hr1 {
   border:0;
   height:0.05px;
   background:black;
}
hr{
   margin-top:0px;
}

</style>
<script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
   function onclick() {
      alert("로그인 후 사용 가능합니다.");      
   }
   
</script>

</head>
<body>
<center>
   <div align="right" class="fixed-title">
    <c:if test="${sessionScope.login!=null}">
       <font style='font-size:11pt; color:black'> 아이디 :</font><font style='font-size:11pt; color:red'> [</font> <font style='font-size:11pt; color:black'><%=session.getAttribute("login")%></font> <font style='font-size:11pt; color:red'> ] </font>
       <input type="button" value="회원정보수정" onclick="location.href='member.jsp?idx=${sessionScope.login}'" style="font-size:11px"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <p>
       
       
    </c:if>
    </div>
    
<div align="center" class="fixed-menu">
  <a href="main.do" style="text-decoration:none"><legend class="title">CATFAMILY</legend></a>
  <nav id="topMenu">
    <ul>
    
    <!-- // 로그인 안되었을 경우 - 로그인, 회원가입 버튼을 보여준다. -->

      <li><a class='menuLink' href='catlist.do'>고양이분양</a></li>      
      <li>|</li>
    <c:if test ="${sessionScope.login==null}">      
      <li><a class='menuLink' href="javascript:onclick()" >질문과답변</a></li>
      <li>|</li>
      <li><a class='menuLink' href='join.do'>회원가입</a></li>
      <li>|</li>
      <li><a class='menuLink' href='login.do'>로그인</a></li>
      
      <!-- 로그인 했을 경우 -->
    </c:if>
    <c:if test ="${sessionScope.login!=null && sessionScope.login!='asdf'}">    
      <li><a class='menuLink' href='boardlist.do'>질문과답변</a></li>
      <li>|</li> 
      <li><a class='menuLink' href='logout.do'>로그아웃</a></li> 
      <li>|</li> 
      <li><a class='menuLink' href='map'>오시는길</a></li> 
      
      <!-- 관리자 로그인 -->
    </c:if>       
    <c:if test="${sessionScope.login!=null && (sessionScope.login=='asdf') }">
      <li><a class='menuLink' href='boardlist.do'>질문과답변</a></li>
      <li>|</li>
      <li><a class='menuLink' href='memberlist.do'>회원리스트</a></li>
      <li>|</li> 
      <li><a class='menuLink' href='logout.do'>로그아웃</a></li>

    </c:if>
   
   
    <!-- // 로그인 되었을 경우 - 로그아웃, 내정보 버튼을 보여준다. -->
<!--
    <c:if test="${sessionScope.sessionID!=null && sessionScope.sessionID!='kamal1'}">
      <li><a class='menuLink' href='catlist.do'>고양이분양</a></li>
      <li>|</li>
      <li><a class='menuLink' href='logout.do'>로그아웃</a></li>
      <li>|</li>
      <li><a class='menuLink' href='qalist.do'>질문과답변</a></li>
      <li>|</li>
      <li><a class='menuLink' href='bbs_list.jsp'>분양방법</a></li>
      <li>|</li>
      <li><a class='menuLink' href='map.jsp'>오시는길</a></li>
    </c:if> 
    -->
    
    <!--  관리자 로그인 -->
    <!--  
    <c:if test="${sessionScope.sessionID!=null && (sessionScope.sessionID=='kamal1')}">
      <li><a class='menuLink' href='catlist.do'>고양이분양</a></li>
      <li>|</li>
      <li><a class='menuLink' href='logout.do'>로그아웃</a></li>
      <li>|</li>      
      <li><a class='menuLink' href='qalist.do'>질문과답변</a></li>
      <li>|</li>
      <li><a class='menuLink' href='bbs_list.jsp'>분양방법</a></li>
      <li>|</li>
      <li><a class='menuLink' href='memberlist.do'>회원리스트</a></li>
   </c:if>
   -->
    </ul>
    </div>
  </nav>
</DIV>
<hr class="my-hr1">
</center>
</body>
</html>