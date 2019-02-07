package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hb.common.CommentDAO;
import net.hb.common.DBDAO;
import net.hb.common.DBbean;

@WebServlet("/detail.do")
public class DetailController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html;charset=UTF-8");
      HttpSession sess = request.getSession();
      String id = (String)sess.getAttribute("sessionID");
      PrintWriter out=response.getWriter();
      DBDAO dao=new DBDAO();
      int data=Integer.parseInt(request.getParameter("idx"));
      System.out.println("num:"+data);
      boolean flag =false;
      Cookie[] cookies = request.getCookies();
        if (cookies != null) {
           System.out.println(cookies.length);
         for (int i = 0; i < cookies.length; i++) {
          if(cookies[i].getName().equals(id+"#"+String.valueOf(data))) {
             flag = true;
             System.out.println("1");
           break;
          }
         }
        }
        if(!flag) {
           dao.dbDetailcount(data);//조회수증가
             Cookie c1 = new Cookie(id+"#"+String.valueOf(data), id+"#"+String.valueOf(data)); 
             c1.setMaxAge(1*24*60*60);//하루저장
             response.addCookie(c1);    
        }

      
      
      
      // 게시글 번호를 이용하여 해당 글에 있는 댓글 목록을 가져온다.
        CommentDAO commentDAO = CommentDAO.getInstance();
        ArrayList<DBbean> commentList = commentDAO.getCommentList(data);
        DBbean bean = new DBbean();
     //  DBDAO dao=new DBDAO();
        bean=dao.dbDetail(data);
       
       if(commentList.size() > 0) {
          request.setAttribute("commentList", commentList);
       }
       request.setAttribute("bean", bean);
       request.setAttribute("pageNum", data);
       System.out.println(bean.getcontent());
       RequestDispatcher dis=request.getRequestDispatcher("qaDetail.jsp");
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