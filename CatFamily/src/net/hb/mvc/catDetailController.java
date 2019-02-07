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

import net.hb.common.CatDAO;
import net.hb.common.DBDAO;
import net.hb.common.DBbean;

@WebServlet("/catdetail.do")
public class catDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		int catnum=Integer.parseInt(request.getParameter("idx"));
		System.out.println("catnum:"+catnum);
		
	    CatDAO dao=new CatDAO();
	    DBbean bean=dao.dbCatDetail(catnum);
	    System.out.println(bean.getCat_img1());
	    
	    request.setAttribute("cat", bean);
	    request.setAttribute("pageNum", catnum);
	    System.out.println(bean.getCat_img2());
	    System.out.println(bean.getCat_img3());
	    System.out.println(bean.getCat_img4());
	    
	    
	    RequestDispatcher dis=request.getRequestDispatcher("catDetail.jsp");
		dis.forward(request, response);
		
//		response.sendRedirect("catDetail.jsp");
		
		System.out.println("이까지옴?");
						
	}//doUser end

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response); 
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}//doGet end

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response); 
		//doGet(request, response);
	}//doPost end

}//DetailController class end
