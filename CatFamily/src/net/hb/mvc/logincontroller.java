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

@WebServlet("/catlogin.do")
public class logincontroller extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		 //lgoinList.jsp 단독실행하면 에러발생
		  //select쿼리문 preparedStatement
		  String a=request.getParameter("Log_id");
		  String b=request.getParameter("Log_pw");
		  	
		  DBbean bean=new DBbean();
		  DBDAO dao=new DBDAO();
			bean.setid(a);
			bean.setpw(b);
			boolean f=dao.dbLogin(a, b);
		  
		  System.out.println(a+""+b+"세션다음");
			  if(f==false) {
				  System.out.println("로그인 실패");
				  response.sendRedirect("catlogin.jsp");
			  } else {
				  HttpSession session = request.getSession();
				  session.setAttribute("sessionID", a);
				  System.out.println("로그인 성공");
				  response.sendRedirect("catmain.jsp");
			  }
		  
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
