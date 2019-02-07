package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.DBDAO;
import net.hb.common.DBbean;

//프레임워크?
@WebServlet("/detail.do")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		int data=Integer.parseInt(request.getParameter("idx"));
	    DBDAO dao=new DBDAO();
	    DBbean bean=dao.dbDetail(data);
	    request.setAttribute("bean", bean);
	    RequestDispatcher dis=request.getRequestDispatcher("guestDetail.jsp");
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
	//get이나 post 두개중 하나 호출되면 작동되게 두개다 써줌
}//DetailController class end
