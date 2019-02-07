package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.DBDAO;
import net.hb.common.DBbean;

@WebServlet("/list.do")
public class ListController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	response.setContentType("text/html;charset=UTF-8"); 
	PrintWriter out=response.getWriter();
	
	 int start, end ;  //[7클릭] start=61, end=70
	 int pagecount;  //316레코드갯수 페이지갯수 32페이지
	 int pageNUM ;   //[7문자] =>숫자화 pageNUM=Integer.parsetInt("7")
	 int startpage, endpage; //[14클릭]  startpage=11, endpage=20
	 String pnum;  //pnum=request.getParamenter("pageNum")
	 int temp; //시작페이지를 구하기위해서 사용하는변수  
	 int num; //행번호 역순출력 
	 
	 //검색할때 
	 String sqry; 
	 String skey, sval; //검색필드, sky="title필드" sval="%p%"
	 String returnpage; 
	//////////////////////////////////////////////////////
	pnum=request.getParameter("pageNum");
	if(pnum=="" || pnum==null) { pnum="1"; }
	pageNUM=Integer.parseInt(pnum);  //[7문자] 숫자 7로 변환
	
	//[7페이지]
	start=(pageNUM-1)*10+1 ; 
	end=pageNUM*10;
	
	//총페이지갯수 316/10
	DBDAO dao=new DBDAO();
	int Gtotal=dao.dbCount();		
	if(Gtotal%10==0){ pagecount=Gtotal/10; } 
	else { pagecount=(Gtotal/10)+1; }
	
	//startpage [24] endpage
    //1  11  21  31 startpage
	//10 20  30  40 endpage
	temp=(pageNUM-1)%10; 
	startpage=pageNUM-temp; 
	endpage=startpage+9;
	if(endpage>pagecount){endpage=pagecount; }
	
	ArrayList<DBbean> LG=dao.dbSelect(start,end);
	request.setAttribute("naver", LG);
	request.setAttribute("Gtotal", Gtotal);
	request.setAttribute("startpage", startpage);
	request.setAttribute("endpage", endpage);
	request.setAttribute("pageNUM", pageNUM); //숫자화 페이지번호
	request.setAttribute("pagecount", pagecount); //총페이지
	
	//LG,Gtotal 지역변수데이터를   view문서로 넘겨요
	//페이지영역 데이터전송 request활용, guestList.jsp문서 호출을 포워딩
	RequestDispatcher dis=request.getRequestDispatcher("guestList.jsp");
	dis.forward(request, response);
  }//doUser end
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	doUser(request,response); //꼭꼭꼭기술
  }//end

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	doUser(request,response); //꼭꼭꼭기술
  }//end
}//ListController class END



