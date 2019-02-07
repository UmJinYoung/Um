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
@WebServlet("/replywrite.do")
public class replywriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int num = Integer.parseInt(request.getParameter("comment_board"));
		String id = request.getParameter("comment_id");
		String content = request.getParameter("comment_content");
		int qanum = Integer.parseInt(request.getParameter("comment_qanum"));
		System.out.println("num:" + num);
		System.out.println("id:" + id);
		System.out.println("content:" + content);
		System.out.println("qanum:" + qanum);

		DBbean bean = new DBbean();
		CommentDAO dao = new CommentDAO();
		bean.setComment_qanum(num);
		bean.setComment_id(id);
		bean.setComment_content(content);
		bean.setComment_qanum(qanum);
		boolean f = dao.insertComment(bean);
//		dao.getReplyCount(qanum);
		System.out.println(f);

		if(f==true) { 
			System.out.println("f==true"); 
			response.sendRedirect("detail.do?idx="+num); 
			System.out.println("완료됨?");
		}else {
			System.out.println("f==false"); 
			response.sendRedirect("detail.do?idx="+num);
		}
		
		

//		response.sendRedirect("detail.do?idx="+num);
		
		/*
		 * RequestDispatcher dis=request.getRequestDispatcher("detail.do?idx="+num);
		 * dis.forward(request, response);
		 */

	}// doUser end

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response); // 瑗�瑗�瑗� 湲곗닠
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}// doGet end

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response); // 瑗�瑗�瑗� 湲곗닠
		// doGet(request, response);
	}// doPost end

}// InsertController class end