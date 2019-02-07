package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.CommentDAO;
import net.hb.common.DBbean;

//�봽�젅�엫�썙�겕?
@WebServlet("/replyedit.do")
public class replyEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		PrintWriter out=response.getWriter();
		System.out.println("넘어옴?");
//		String a=request.getParameter("id");
		int replynum=Integer.parseInt(request.getParameter("num"));
		String content=request.getParameter("comment_content");
		System.out.println("replynum:"+replynum);
		System.out.println("content:"+content);
		
		CommentDAO dao = CommentDAO.getInstance();
		DBbean bean=new DBbean();
		CommentDAO comment=new CommentDAO();
			bean.setComment_num(replynum);
			bean.setComment_content(content);
		boolean result = comment.updateComment(bean);
		if(result) {
			out.println("1");
			System.out.println("수정 완료");
		}
		
		out.close();
		
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
