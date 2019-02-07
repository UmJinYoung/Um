package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.CommentDAO;
import net.hb.common.DBDAO;
import net.hb.common.DBbean;
import net.hb.common.memberDAO;

@WebServlet("/memberlist.do")
public class memberlistController extends HttpServlet {
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
	 
	 String returnpage; 
	 String keyfield=request.getParameter("keyfield");
	 String keyword=request.getParameter("keyword");
		HashMap<String, Object> listOpt = new HashMap<String, Object>();
		listOpt.put("keyfield", keyfield);
		listOpt.put("keyword", keyword);
	//////////////////////////////////////////////////////
	pnum=request.getParameter("pageNum");
	if(pnum=="" || pnum==null) { pnum="1"; }
	pageNUM=Integer.parseInt(pnum);  //[7����] ���� 7�� ��ȯ
	
	//[7������]
	start=(pageNUM-1)*10+1 ; 
	end=pageNUM*10;
	
	//게시글 수
	memberDAO dao=new memberDAO();
	int Gtotal=dao.dbmemberCount(listOpt);
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
	
	ArrayList<DBbean> LG = dao.dbmemberSelect(start, end, listOpt);
	request.setAttribute("keyword", keyword);
	request.setAttribute("keyfield", keyfield);
	request.setAttribute("startpage", startpage);
	request.setAttribute("endpage", endpage);
	request.setAttribute("pageNUM", pageNUM); //����ȭ ��������ȣ
	request.setAttribute("pagecount", pagecount); //��������
	request.setAttribute("member", LG);
	request.setAttribute("Gtotal", Gtotal);
	//LG,Gtotal �������������͸�   view������ �Ѱܿ�
	//���������� ���������� requestȰ��, guestList.jsp���� ȣ���� ������
	
	RequestDispatcher dis=request.getRequestDispatcher("memberList.jsp");
	dis.forward(request, response);
  }//doUser end
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	doUser(request,response); //���������
  }//end

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	doUser(request,response); //���������
  }//end
}//ListController class END