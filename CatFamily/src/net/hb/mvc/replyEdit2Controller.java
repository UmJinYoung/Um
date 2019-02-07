package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.CommentDAO;
import net.hb.common.DBbean;

//�봽�젅�엫�썙�겕?
@WebServlet("/replyedit2.do")
public class replyEdit2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * request.setCharacterEncoding("UTF-8"); response.setContentType("UTF-8");
		 */
		
		response.setContentType("text/html; charset=EUC-KR");
		request.setCharacterEncoding("EUC-KR"); 

		PrintWriter out=response.getWriter();
		
//		String a=request.getParameter("id");
		int replynum=Integer.parseInt(request.getParameter("num"));
		System.out.println("replynum:"+replynum);
		
		CommentDAO dao=CommentDAO.getInstance();
		DBbean comment=dao.getComment(replynum);
		
		request.setAttribute("comment", comment);
		System.out.println("content:"+comment.getComment_content());
		
		
		  RequestDispatcher dis=request.getRequestDispatcher("replyedit.jsp");
		  dis.forward(request, response);
		 
		
		//response.sendRedirect("replyedit.jsp");
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
