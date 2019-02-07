package net.hb.mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.CommentDAO;
import net.hb.common.DBbean;
import net.hb.common.memberDAO;

@WebServlet("/memberdetail.do")
public class memberDetailController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html;charset=UTF-8");
      
      String id = request.getParameter("idx");
      memberDAO dao=new memberDAO();
      System.out.println("id:"+id);
   
        DBbean bean = new DBbean();
        bean=dao.dbmemberDetail(id);
       
       request.setAttribute("bean", bean);
       
       RequestDispatcher dis=request.getRequestDispatcher("memberDetail.jsp");
      dis.forward(request, response);

   }//doUser end

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doUser(request,response); //瑗�瑗�瑗� 湲곗닠
      //response.getWriter().append("Served at: ").append(request.getContextPath());
   }//doGet end

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doUser(request,response); //瑗�瑗�瑗� 湲곗닠
      //doGet(request, response);
   }//doPost end
   //get�씠�굹 post �몢媛쒖쨷 �븯�굹 �샇異쒕릺硫� �옉�룞�릺寃� �몢媛쒕떎 �뜥以�
}//DetailController class end