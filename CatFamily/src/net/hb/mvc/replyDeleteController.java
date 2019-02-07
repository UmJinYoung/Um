package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.CommentDAO;
import net.hb.common.DBDAO;

//�봽�젅�엫�썙�겕?
@WebServlet("/replydelete.do")
//web.xml mapping
public class replyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		int data=Integer.parseInt(request.getParameter("num"));
		int qanum = Integer.parseInt(request.getParameter("qanum"));
		System.out.println("댓글num:"+data);
		System.out.println("게시글num:"+qanum);
		
		CommentDAO dao=new CommentDAO();
		
		dao.deleteComment(data, qanum);	//Ctrl+F5
		System.out.println("delete 됨?");
		out.println("1");
	}//doUser end

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response); //瑗�瑗�瑗� 湲곗닠
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}//doGet end

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response); //瑗�瑗�瑗� 湲곗닠
		//doGet(request, response);
	}//doPost end

}//DeleteController class end
