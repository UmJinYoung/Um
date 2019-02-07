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
@WebServlet("/preEdit.do")
public class PreEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		int data=Integer.parseInt(request.getParameter("idx"));
		DBDAO dao=new DBDAO();
	    DBbean bean=dao.dbDetail(data);
	    request.setAttribute("bean", bean);
		
		RequestDispatcher dis=request.getRequestDispatcher("guestEdit.jsp"); // response.sendRedirect("guestList.jsp")로 못넘겨서 이렇게 넘김
		dis.forward(request, response);
		
	}//doUser end

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response); //꼭꼭꼭 기술
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}//doGet end

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response); //꼭꼭꼭 기술
		//doGet(request, response);
	}//doPost end

}//EditController class end