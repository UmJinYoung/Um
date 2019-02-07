
package net.hb.common;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CommentDAO {
   Connection CN; 
   Statement ST, ST3 ; //ST=CN.createStatement()
   PreparedStatement PST; //PST=CN.prepareStatment(sql)
   CallableStatement CS; //CS=CN.callableStatement(sql)
   ResultSet RS, RS3; //  RS.next( )
 
   String msg, msg2, msg3; 
   java.util.Date Gnalja; 
   int ReplyCount;
   
   private static CommentDAO instance;

  public CommentDAO( ) {
	CN=DB.getConnection();   
  }//�깮�꽦�옄end
  
  
  public static CommentDAO getInstance(){
      if(instance==null)
          instance=new CommentDAO();
      return instance;
  }
  
  // 시퀀스를 가져온다.
  public int getSeq() 
  {
      int result = 1;
      try {
          // 시퀀스 값을 가져온다. (DUAL : 시퀀스 값을 가져오기위한 임시 테이블)
          StringBuffer sql = new StringBuffer();
          sql.append("SELECT reply_SEQ.NEXTVAL FROM DUAL");
          ST=CN.createStatement();
          //RS=ST.executeQuery(msg);
          RS=ST.executeQuery(sql.toString());
          if(RS.next()==true){ result=RS.getInt(1);}

      } catch (Exception e) {
          throw new RuntimeException(e.getMessage());
      }

      return result;
  } // end getSeq
  
  // 댓글 등록
  public boolean insertComment(DBbean comment)
  {
      boolean result = false;
      
      try {

          // 자동 커밋을 false로 한다.
          CN.setAutoCommit(false);
          
//          StringBuffer sql = new StringBuffer();
//          sql.append("INSERT INTO REPLY VALUES(?,reply_seq.nextval,?,?,sysdate)");
//          
//          PST.setString(1, comment.getComment_id());
//          PST.setInt(2, comment.getComment_qanum());
//       	  PST.setString(3, comment.getComment_content());
//       	  
//          int flag = PST.executeUpdate();
          
          msg="INSERT INTO REPLY VALUES(?,reply_seq.nextval,?,?,sysdate)";
          PST=CN.prepareStatement(msg);
            PST.setString(1, comment.getComment_id());
            PST.setInt(2, comment.getComment_qanum());
     	    PST.setString(3, comment.getComment_content());
     	   PST.executeUpdate();
     	      
			/*
			 * StringBuffer sql = new StringBuffer();
			 * sql.append("UPDATE QA SET REPLYCNT=REPLYCNT+1 WHERE NUM=?"); PST =
			 * CN.prepareStatement(sql.toString()); PST.setInt(1,
			 * comment.getComment_qanum()); RS = PST.executeQuery();
			 * System.out.println("쿼리문");
			 */
     	    
     	  msg2="UPDATE QA SET REPLYCNT=REPLYCNT+0.5 WHERE NUM=?";
     	  PST=CN.prepareStatement(msg2);
            PST.setInt(1, comment.getComment_qanum());
          PST.executeUpdate();

     	    
     	  int flag=PST.executeUpdate();
          if(flag > 0){
              result = true;
              CN.commit(); // 완료시 커밋
          }
          
      } catch (Exception e) {
          try {
              CN.rollback(); // 오류시 롤백
          } catch (SQLException sqle) {
              sqle.printStackTrace();
          } 
          e.printStackTrace();
//          throw new RuntimeException(e.getMessage());
      }

      return result;    
  } // end boardInsert();    
  
  // 댓글 목록 가져오기
  public ArrayList<DBbean> getCommentList(int boardNum)
  {
      ArrayList<DBbean> list = new ArrayList<DBbean>();
      
      try {
          
          /* 댓글의 페이지 처리를 하고싶다면 이 쿼리를 사용하면 된다.
           * SELECT * FROM
           *            (SELECT  ROWNUM AS rnum,
           *                   data.*
           *             FROM
           *                   (SELECT LEVEL,
           *                           COMMENT_NUM,
           *                             COMMENT_BOARD,
           *                           COMMENT_ID,
           *                           COMMENT_DATE,
           *                           COMMENT_PARENT,
           *                           COMMENT_CONTENT
           *                    FROM BOARD_COMMENT
           *                    WHERE COMMENT_BOARD = ?
           *                   START WITH COMMENT_PARENT = 0
           *                   CONNECT BY PRIOR COMMENT_NUM = COMMENT_PARENT) 
           *              data)
           *    WHERE rnum>=? and rnum<=? ;
           */
          
          StringBuffer sql = new StringBuffer();
          sql.append("    select r.num, r.id, r.nalja, r.content from qa q inner join reply r on q.num=r.qanum and r.qanum=?");
          
          PST=CN.prepareStatement(sql.toString());
          PST.setInt(1, boardNum); 
          RS = PST.executeQuery();
          while(RS.next())
          {
              DBbean comment = new DBbean();
              comment.setComment_id(RS.getString("id"));
              comment.setComment_content(RS.getString("content"));
              comment.setComment_date(RS.getDate("nalja"));
              comment.setComment_num(RS.getInt("num"));
              list.add(comment);
          }
              
      } catch (Exception e) {
          e.printStackTrace();
//          throw new RuntimeException(e.getMessage());
      }

      return list;
  } // end getCommentList
  
  //댓글 수정
  public boolean updateComment(DBbean comment) 
  {
      boolean result = false;
      
      try{
          CN.setAutoCommit(false); // 자동 커밋을 false로 한다.
          
          StringBuffer sql = new StringBuffer();
          sql.append("UPDATE REPLY SET");
          sql.append(" CONTENT = ?");
          sql.append(" WHERE NUM = ?");

          PST = CN.prepareStatement(sql.toString());
          PST.setString(1, comment.getComment_content());
          PST.setInt(2, comment.getComment_num());

          int flag = PST.executeUpdate();
          if(flag > 0){
              result = true;
              CN.commit(); // 완료시 커밋
          }
          
      } catch (Exception e) {
          try {
              CN.rollback(); // 오류시 롤백
          } catch (SQLException sqle) {
              sqle.printStackTrace();
          }
          e.printStackTrace();
//          throw new RuntimeException(e.getMessage());
      }

      return result;
  } // end updateComment  
  
  //댓글 삭제
  public boolean deleteComment(int comment_num, int comment_qanum) 
  {
      boolean result = false;

      try {

          CN.setAutoCommit(false); // 자동 커밋을 false로 한다.

			/*
			 * StringBuffer sql = new StringBuffer();
			 * sql.append("DELETE FROM REPLY WHERE num= ?");
			 * 
			 * PST = CN.prepareStatement(sql.toString()); PST.setInt(1, comment_num);
			 */
          System.out.println("들어감?");
          msg="DELETE FROM REPLY WHERE NUM=?";
          PST=CN.prepareStatement(msg);
            PST.setInt(1, comment_num);
          PST.executeUpdate();
          System.out.println("삭제됨");
          
          msg2="UPDATE QA SET REPLYCNT=REPLYCNT-0.5 WHERE NUM=?";
     	  PST=CN.prepareStatement(msg2);
            PST.setInt(1, comment_qanum);
            int flag = PST.executeUpdate();
          System.out.println("-0.5");
          
          if(flag > 0){
              result = true;
              CN.commit(); // 완료시 커밋
          }    
          
      } catch (Exception e) {
          try {
              CN.rollback(); // 오류시 롤백
          } catch (SQLException sqle) {
              sqle.printStackTrace();
          }
//          throw new RuntimeException(e.getMessage());
      }

      return result;
  } // end deleteComment 

  //댓글 정보
  public DBbean getComment(int comment_num)
  {
	  DBbean comment = null;
      
      try {
          
          StringBuffer sql = new StringBuffer();
          sql.append("SELECT * FROM REPLY WHERE NUM = ?");
          
          PST = CN.prepareStatement(sql.toString());
          PST.setInt(1, comment_num);
          
          RS = PST.executeQuery();
          while(RS.next())
          {
              comment = new DBbean();
              comment.setComment_num(RS.getInt("num"));
              comment.setComment_qanum(RS.getInt("qanum"));
              comment.setComment_id(RS.getString("id"));
              comment.setComment_date(RS.getDate("nalja"));
              comment.setComment_content(RS.getString("content"));
          }
      } catch (Exception e) {
          throw new RuntimeException(e.getMessage());
      }

      return comment; 
  } // end getComment
  
  public void getReplyCount(int comment_qanum)
  {
	  int ReplyCount = 0;
      
      try {
          
          
      } catch (Exception e) {
          throw new RuntimeException(e.getMessage());
      }
 
  } // end getComment

  public void dbtest() {
	try {
      				   
	}catch(Exception ex){System.out.println("Error: "+ex);}	   
 }//end
 
}//DBDAO class END