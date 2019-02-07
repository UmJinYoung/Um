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

//프레임워크?
@WebServlet("/insert.do")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
/*		System.out.println("InsertController.java컨트롤문서");
		out.println("<h1>InsertController.java컨트롤문서<br></h1>");
		out.println("<img src=images/bar.gif><br>");
		out.println("<img src=images/bar.gif><br>");
		out.println("<img src=images/bar.gif><p>");*/
		
		int a=Integer.parseInt(request.getParameter("sabun"));
		String b=request.getParameter("name");
		String c=request.getParameter("title");
		int d=Integer.parseInt(request.getParameter("pay"));
		System.out.println(a+" "+b+" "+c+" "+d);
		
		DBbean bean=new DBbean();
		DBDAO dao=new DBDAO();
			bean.setSabun(a);
			bean.setName(b);
			bean.setTitle(c);
			bean.setPay(d);
		dao.dbInsert(bean);
		//response.sendRedirect("guestList.jsp"); //에러발생
		response.sendRedirect("list.do");	//ListController.java실행
		
	}//doUser end

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response); //꼭꼭꼭 기술
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}//doGet end

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response); //꼭꼭꼭 기술
		//doGet(request, response);
	}//doPost end

}//InsertController class end
