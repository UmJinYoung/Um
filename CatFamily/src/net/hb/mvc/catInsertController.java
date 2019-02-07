package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.CatDAO;
import net.hb.common.DBbean;

//�봽�젅�엫�썙�겕?
@WebServlet("/catinsert.do")
public class catInsertController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out=response.getWriter();
      
        String catname=request.getParameter("idx");
        System.out.println("고양이이름:"+catname);
        String id=request.getParameter("idx2");
        System.out.println("아이디:"+id);
        		
           CatDAO dao=new CatDAO();
           dao.catinsert(id, catname);
           
           response.sendRedirect("catlist.do");
           
           
   }//doUser end

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doUser(request,response); //瑗�瑗�瑗� 湲곗닠
      //response.getWriter().append("Served at: ").append(request.getContextPath());
   }//doGet end

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doUser(request,response); //瑗�瑗�瑗� 湲곗닠
      //doGet(request, response);
   }//doPost end

}//InsertController class end