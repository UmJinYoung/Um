package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hb.common.DBDAO;
import net.hb.common.DBbean;

@WebServlet("/logout.do")
public class logoutcontroller extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		 //lgoinList.jsp 단독실행하면 에러발생
		  //select쿼리문 preparedStatement
		
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("catmain.jsp");
		
		 
	}
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doUser(request,response); //瑗�瑗�瑗� 湲곗닠
				//response.getWriter().append("Served at: ").append(request.getContextPath());
		}//doGet end

		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doUser(request,response); //瑗�瑗�瑗� 湲곗닠
				//doGet(request, response);
		}//doPost end

}
