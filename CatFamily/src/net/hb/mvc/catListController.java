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

import net.hb.common.CatDAO;
import net.hb.common.DBbean;

@WebServlet("/catlist.do")
public class catListController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8"); 
	PrintWriter out=response.getWriter();
	
	 int start, end ;  //[7Ŭ��] start=61, end=70
	 int pagecount;  //316���ڵ尹�� ���������� 32������
	 int pageNUM ;   //[7����] =>����ȭ pageNUM=Integer.parsetInt("7")
	 int startpage, endpage; //[14Ŭ��]  startpage=11, endpage=20
	 String pnum;  //pnum=request.getParamenter("pageNum")
	 int temp; //������������ ���ϱ����ؼ� ����ϴº���  
	 int num; //���ȣ ������� 

	//////////////////////////////////////////////////////
	pnum=request.getParameter("pageNum");
	if(pnum=="" || pnum==null) { pnum="1"; }
	pageNUM=Integer.parseInt(pnum);  //[7����] ���� 7�� ��ȯ
	
	//[7������]
	start=(pageNUM-1)*10+1 ; 
	end=pageNUM*9;
	
	//������������ 316/10
	CatDAO dao=new CatDAO();
	int Gtotal=dao.dbCatCount();
	System.out.println("Gtotal:"+Gtotal);
	if(Gtotal%10==0){ pagecount=Gtotal/10; }
	else { pagecount=(Gtotal/10)+1; }
	
	//startpage [24] endpage
    //1  11  21  31 startpage
	//10 20  30  40 endpage
	temp=(pageNUM-1)%10; 
	startpage=pageNUM-temp; 
	endpage=startpage+9;
	if(endpage>pagecount){endpage=pagecount; }
	
	
	ArrayList<DBbean> CAT = dao.dbCatSelect(start, end);
	request.setAttribute("startpage", startpage);
	request.setAttribute("endpage", endpage);
	request.setAttribute("pageNUM", pageNUM);
	request.setAttribute("pagecount", pagecount); 
	request.setAttribute("qa", CAT);
	request.setAttribute("Gtotal", Gtotal);

//	response.sendRedirect("catList.jsp");

	RequestDispatcher dis=request.getRequestDispatcher("catList.jsp");
	dis.forward(request, response);

	System.out.println("이까지옴?");
	
  }//doUser end
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	doUser(request,response); 
  }//end

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	doUser(request,response); 
  }//end
}//ListController class END