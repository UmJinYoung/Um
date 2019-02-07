<%@ page language="java" contentType="text/html; charset=UTF-8"  %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <style type="text/css">
     *{font-size:20pt;}
  	 p,div{
  	   font-size:20pt; font-weight:bold;
  	   padding:10px; width:700px; 
  	  }
  </style>
  
  <title>test_jQuery1.jsp</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
  <script>
   jQuery(document).ready(function( ){  //람다식
    	$('#asp').click(function(){
    		$('#asp').text("asp태그영역 노란색");
    		$('#asp').css({
    			"background-color": "yellow",
    			"color": "red",
    			"font-siez": "34px"
    		});
    	});
    });
    
    $(document).ready(function( ){ 
    	$('#jsp').click(function(){
    	   $('#jsp').text("jsp태그영역 핑크색");
    	   $('#jsp').css("background-color", "pink");
    	   $('#jsp').css("color", "blue"); 
    	   $('#jsp').css("font-size", "34px"); 
    	});
    });
    
    $(function( ){ 
    	$('#php').on("click",function(){
    		$(this).text("php태그영역 this 오렌지");
    		$(this).css("background-color", "orange");
    		$(this).css("color", "blue"); 
    		$(this).css("font-size", "34px"); 
    	});
    });
    
    $(function( ){ 
    	$('p').click(function(){
    	   $('p').text("p라인개행 태그영역 lightblue");
    	   $('p').css("background-color", "lightblue");
    	   $('p').css("color", "blue"); 
    	   $('p').css("font-size", "34px"); 
    	});
    });
    
    $(function(){ 
       $('#btnTitle').click(function(){
    	   var msg= $("#title").val();
    	   alert("당신의 메세지: "+ msg );
       });	
    });
  </script>
</head>
<body>
 <div id="asp">asp</div> 
 <div id="jsp">jsp</div> 
 <div id="php">php</div> 
 <p>p태그 </p>
 
 <hr>
 <form>
   제목:<input type="text" id="title" value="snow">
      <input type="button"  value="제목보기" id="btnTitle"></button> 
 </form>
</body>
</html>












