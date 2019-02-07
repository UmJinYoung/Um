<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>webmadang.net|fixed menu</title>
	<meta name="description" content="웹마당넷">
    <style>
      body {
        margin: 0px;
		padding: 0px;
      }
	  #fixed-title {
        text-align: center;
      }
      #fixed-menu {
		
        width: 100%;
		text-align: center;
		padding: 10px 0px;
        background-color: #ff0022;
		
      }
      #main-wrapper {
        width: 100%;
		background-color: #f3f3f3;
		color:#ff0000;
		height:1500px;

      }
	  .fixed-title {
        position: fixed;
        top: 0px;
      }
      #fixed-menu li {
        display: inline-block;
        margin-right: 50px;
      }
	  h1 {
	  color: #07090C;
	  font-weight:bold;
      }
    </style>
  <script src="//code.jquery.com/jquery-3.3.1.js"></script>
    <script>
      $( document ).ready( function() {
        var jbOffset = $( '#fixed-menu' ).offset();
        $( window ).scroll( function() {
          if ( $( document ).scrollTop() > jbOffset.top ) {
            $( '#fixed-menu' ).addClass( 'fixed-title' );
          }
          else {
            $( '#fixed-menu' ).removeClass( 'fixed-title' );
          }
        });
      } );
    </script>
  </head>
  <body>
    <div id="fixed-title">
      <h1>나는 홈페이지 타이틀입니다.</h1>
    </div>
    <div id="fixed-menu">
      <h1>나는 고정 메뉴입니다.</h1>
      <ul>
        <li>메뉴1</li>
        <li>메뉴2</li>
        <li>메뉴3</li>
      </ul>
    </div>
    <div id="main-wrapper">
    </div>
  </body>
</html>