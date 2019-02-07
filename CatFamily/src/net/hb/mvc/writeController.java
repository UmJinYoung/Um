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
@WebServlet("/write.do")
public class writeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		  String a = request.getParameter("idx");
	      String b = request.getParameter("title");
	      String c = request.getParameter("content");
	      System.out.println(a+""+b+""+c);
	   
		  DBbean bean=new DBbean();
		  DBDAO dao=new DBDAO();
			bean.setid(a);
			bean.settitle(b);
			bean.setcontent(c);		
		
		dao.dbwriter(bean);
		response.sendRedirect("qalist.do");
		
		/*
		 * RequestDispatcher dis=request.getRequestDispatcher("qalist.do");
		 * dis.forward(request, response);
		 */		
	}//doUser end

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response); //瑗�瑗�瑗� 湲곗닠
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}//doGet end

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response); //瑗�瑗�瑗� 湲곗닠
		//doGet(request, response);
	}//doPost end

}//InsertController class end