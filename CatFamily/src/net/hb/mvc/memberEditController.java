package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.DBDAO;
import net.hb.common.DBbean;

//�봽�젅�엫�썙�겕?
@WebServlet("/memberedit.do")
public class memberEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		PrintWriter out=response.getWriter();
		
		  String a = request.getParameter("id");
	      String b = request.getParameter("pw");
	      String c = request.getParameter("name");
	      String d = request.getParameter("birth1");
	      String e = request.getParameter("birth2");
	      String f = request.getParameter("birth3");
	      String g = request.getParameter("email1");
	      String h = request.getParameter("email2");
	      String i = request.getParameter("phone1");
	      String j = request.getParameter("phone2");
	      String k = request.getParameter("phone3");
	      String l = request.getParameter("juso1");
	      String m = request.getParameter("juso2");
	      String birth=d+"년"+e+"월"+f+"일";
	      String email=g+"@"+h;
	      String phone=i+"-"+j+"-"+k;
		  System.out.println(a+" "+b+" "+c+" "+birth+" "+email+" "+phone+" "+l+" "+m);
		
		
		  DBbean bean=new DBbean();
		  DBDAO dao=new DBDAO();
			bean.setid(a);
			bean.setpw(b);
			bean.setname(c);
			bean.setbirth(birth);
			bean.setemail(email);
			bean.setphone(phone);
			bean.setadd1(l);
			bean.setadd2(m);
		  dao.dbMemberEdit(bean);
		  
		  response.sendRedirect("catmain.jsp");
		
	}//doUser end

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response); //瑗�瑗�瑗� 湲곗닠
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}//doGet end

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response); //瑗�瑗�瑗� 湲곗닠
		//doGet(request, response);
	}//doPost end

}//EditController class end
