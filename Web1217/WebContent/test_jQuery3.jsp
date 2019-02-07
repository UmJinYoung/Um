<%@ page language="java" contentType="text/html; charset=UTF-8"  %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <style type="text/css">
     *{font-size:20pt;}
  	  
	 body { font:12px dotum; }
     .box { clear:both; }
     .div_class { float:left;width:15%;margin:10px;padding:10px;border-color:#ccc;border:1px solid;line-height:24px;color:#ccc; }
     .div_class.selected { color:#777;border-color:#f55c72; }
     .div_class.selected>ul>li { cursor:pointer; }
     /*.div_class.selected>ul>li.selected { background-color:#f55c72;color:#fff; } */
     .div_class.selected>ul>li.selected { background-color:#ff00ff;color:#fff; }
  </style>
  
  <title>test_jQuery3.jsp</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
   <div class="box">
        <input type="radio" name="fruit" value="과일" /> 과일
        <input type="radio" name="fruit" value="과목" /> 과목
    </div>

    <div id="areaWrap" class="box">
        <div id="my_area1"  class="div_class">
            <ul>
                <li>수박</li>
                <li>딸기</li>
                <li>복숭아</li>
                <li>키위</li>
                <li>포도</li>
                <li>오렌지</li>
                <li>망고망고</li>
            </ul>
        </div>

        <div id="my_area2" class="div_class">
            <ul>
                <li>자바</li>
                <li>스프링</li>
                <li>자료구조</li>
                <li>파이썬</li>
                <li>Ajax</li>
                <li>리눅스</li>
                <li>Django</li>
            </ul>
        </div>
    </div>
</body>
</html>
 
 <script>
	  //과일,과목 선택하기
	  jQuery("input[name='fruit']").click(function(){
	      jQuery(".div_class").removeClass("selected");
	      if(this.value=="과일"){ jQuery("#my_area1").addClass("selected"); }
	      else if(this.value=="과목"){ jQuery("#my_area2").addClass("selected");}
	  });
	  
	  //항목선택하면 분홍색컬러변경*/
	  //<div id="my_area1"  class="div_class"> 과일영역
	  //<div id="my_area2"  class="div_class"> 과목영역
	  jQuery("#areaWrap").on("click", ".div_class.selected>ul>li",function(){
	      //var jthis = jQuery(this);
	      //if(jthis.hasClass("selected")){ jthis.removeClass("selected"); }
	      //else{ jthis.addClass("selected") };
	      if($(this).hasClass("selected")){ $(this).removeClass("selected"); }
	      else{ $(this).addClass("selected") };
	  });

 </script>















