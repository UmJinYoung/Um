package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.DBDAO;

//�봽�젅�엫�썙�겕?
@WebServlet("/qadelete.do")
//web.xml mapping
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		

		int data=Integer.parseInt(request.getParameter("idx"));
		DBDAO dao=new DBDAO();
		dao.dbDelete(data);	//Ctrl+F5
		dao.dbreplyDelete(data);
		
		response.sendRedirect("qalist.do");
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
