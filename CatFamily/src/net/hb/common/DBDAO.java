
package net.hb.common;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class DBDAO {
   Connection CN; 
   Statement ST, ST3 ; //ST=CN.createStatement()
   PreparedStatement PST; //PST=CN.prepareStatment(sql)
   CallableStatement CS; //CS=CN.callableStatement(sql)
   ResultSet RS, RS3; //  RS.next( )
 
   String msg, msg2, msg3; 
   String b, Gname, c , Gtitle; 
   java.util.Date Gnalja; 
   int Gtotal;
   
   boolean flag2=false;
   boolean flag=false;   

  public DBDAO( ) {
   CN=DB.getConnection();   
  }//�깮�꽦�옄end  
 
  
 public void dbInsert(DBbean bean) {
   try {//沅뚯옣
     msg="insert into cf values(?,?,?,?,?,?,?,?,?)";
     PST=CN.prepareStatement(msg);
        PST.setString(1, bean.getid());
        PST.setString(2, bean.getpw());
        PST.setString(3, bean.getname());
        PST.setString(4, bean.getbirth());
        PST.setString(5, bean.getemail());
        PST.setString(6, bean.getphone());
        PST.setString(7, bean.getadd1());
        PST.setString(8, bean.getadd2());
        PST.setString(9, null);
     PST.executeUpdate();
   }catch(Exception ex){System.out.println("Error: "+ex);}
 }//end
 
 public boolean dbLogin(String id, String pw) {
    try {
    msg="select count(*) as cnt from cf where id=? and pw=?";
     PST=CN.prepareStatement(msg);
        PST.setString(1, id);
        PST.setString(2, pw);
     RS=PST.executeQuery();
     if(RS.next()==true){ Gtotal=RS.getInt("cnt");}
     if(Gtotal>0){
      System.out.println(id+""+pw);
      flag=true;
      //세션설정.setAttribute( 가, 진짜id=a)
      //세션설정시간변경   web.xml
      //guestDetail.jsp문서에서 세션값출력 
     } else {
        flag=false;
        System.out.println("잘못입력");
     }
    }catch(Exception ex){System.out.println("Error: "+ex);}
   return flag;
 }
 
 public boolean dbIdcheck(String id) {
    try {
       msg="select count(*) as cnt  from cf where id=?";
       PST=CN.prepareStatement(msg);
           PST.setString(1, id);
        RS=PST.executeQuery();
        RS=PST.executeQuery();
        if(RS.next()==true){ Gtotal=RS.getInt("cnt");}
       if(Gtotal>0) {
          flag2=true;
       }else {
          flag2=false;
       }    
    }catch(Exception ex){System.out.println("Error: "+ex);}
   return flag2;
 }
 
 public int dbCount(HashMap<String, Object> listOpt) {
     ArrayList<DBbean> list=new ArrayList<DBbean>( );   
     String keyfield=(String)listOpt.get("keyfield");
     String keyword=(String)listOpt.get("keyword");
     try {
        if(keyfield==null || keyfield=="") {
           msg="select count(*) as cnt from qa ";
            ST=CN.createStatement();
            RS=ST.executeQuery(msg);
            RS.next() ;
            Gtotal=RS.getInt("cnt");
            System.out.println("전체검색"+Gtotal);
        }else if(keyfield.equals("id")) {
           msg="select count(*) as cnt from qa where id like '%"+keyword+"%'";
            ST=CN.createStatement();
            RS=ST.executeQuery(msg);
            RS.next() ;
            Gtotal=RS.getInt("cnt");
            System.out.println("이름검색:"+Gtotal);
        }else if(keyfield.equals("title")) {
           msg="select count(*) as cnt from qa where title like '%"+keyword+"%'";
            ST=CN.createStatement();
            RS=ST.executeQuery(msg);
            RS.next() ;
            Gtotal=RS.getInt("cnt");
            System.out.println("제목검색:"+Gtotal);
        }else if(keyfield.equals("content")) {
           msg="select count(*) as cnt from qa where content like '%"+keyword+"%'";
            ST=CN.createStatement();
            RS=ST.executeQuery(msg);
            RS.next() ;
            Gtotal=RS.getInt("cnt");
            System.out.println("내용검색:"+Gtotal);
        }
      
      }catch(Exception ex){System.out.println("Error: "+ex);}
     return Gtotal;
 }//end
    
 public ArrayList<DBbean> dbSelect(int start, int end, HashMap<String, Object> listOpt){
 //     System.out.println("들어옴?");
     ArrayList<DBbean> list=new ArrayList<DBbean>( );   
     String keyfield=(String)listOpt.get("keyfield");
     String keyword=(String)listOpt.get("keyword");
     
     try {
      if(keyfield==null || keyfield=="") {
           String x=" select * from ( ";
           String y=" select rownum rn, id, num, title, nalja, content, vi, replycnt from qa ";
           String z=" ) where rn between "+start+" and "+ end;
           msg=x+y+z;
           ST=CN.createStatement();
           RS=ST.executeQuery(msg);
           
           while(RS.next()==true) {
             DBbean bean=new DBbean();
              bean.setRn(RS.getInt("rn"));
              bean.setid(RS.getString("id"));
              bean.setnum(RS.getInt("num"));
              bean.settitle(RS.getString("title"));
              bean.setnalja(RS.getDate("nalja"));
              bean.setcontent(RS.getString("content"));
              bean.setvi(RS.getInt("vi"));
              bean.setreplycnt(RS.getInt("replycnt"));
              list.add(bean);
           }//while end
      }else if(keyfield.equals("id")) {//이름으로 검색
           String x=" select * from ( ";
           String y=" select rownum rn, id, num, title, nalja, content, vi, replycnt from qa where id like '%"+keyword+"%'";
           String z=" ) where rn between "+start+" and "+ end;
//           msg=" select count(*) as cnt from qa where "+keyfield+" like '%"+keyword+"%'";
           msg=x+y+z;
           ST=CN.createStatement();
           RS=ST.executeQuery(msg);
           System.out.println("msg:"+msg);
           
           while(RS.next()==true) {
             DBbean bean=new DBbean();
              bean.setRn(RS.getInt("rn"));
              bean.setid(RS.getString("id"));
              bean.setnum(RS.getInt("num"));
              bean.settitle(RS.getString("title"));
              bean.setnalja(RS.getDate("nalja"));
              bean.setcontent(RS.getString("content"));
              bean.setvi(RS.getInt("vi"));
              bean.setreplycnt(RS.getInt("replycnt"));
              list.add(bean);
           }//while end
//           System.out.println("완료됨?");
      }else if(keyfield.equals("title")) {//제목으로 검색
         String x=" select * from ( ";
           String y=" select rownum rn, id, num, title, nalja, content, vi, replycnt from qa where title like '%"+keyword+"%'";
           String z=" ) where rn between "+start+" and "+ end;
//           msg=" select count(*) as cnt from qa where "+keyfield+" like '%"+keyword+"%'";
           msg=x+y+z;
           ST=CN.createStatement();
           RS=ST.executeQuery(msg);
           System.out.println("msg:"+msg);
           
           while(RS.next()==true) {
             DBbean bean=new DBbean();
              bean.setRn(RS.getInt("rn"));
              bean.setid(RS.getString("id"));
              bean.setnum(RS.getInt("num"));
              bean.settitle(RS.getString("title"));
              bean.setnalja(RS.getDate("nalja"));
              bean.setcontent(RS.getString("content"));
              bean.setvi(RS.getInt("vi"));
              bean.setreplycnt(RS.getInt("replycnt"));
              list.add(bean);
           }//while end
         
      }else if(keyfield.equals("content")) {//내용으로 검색
         String x=" select * from ( ";
           String y=" select rownum rn, id, num, title, nalja, content, vi, replycnt from qa where content like '%"+keyword+"%'";
           String z=" ) where rn between "+start+" and "+ end;
//           msg=" select count(*) as cnt from qa where "+keyfield+" like '%"+keyword+"%'";
           msg=x+y+z;
           ST=CN.createStatement();
           RS=ST.executeQuery(msg);
           System.out.println("msg:"+msg);
           
           while(RS.next()==true) {
             DBbean bean=new DBbean();
              bean.setRn(RS.getInt("rn"));
              bean.setid(RS.getString("id"));
              bean.setnum(RS.getInt("num"));
              bean.settitle(RS.getString("title"));
              bean.setnalja(RS.getDate("nalja"));
              bean.setcontent(RS.getString("content"));
              bean.setvi(RS.getInt("vi"));
              bean.setreplycnt(RS.getInt("replycnt"));
              list.add(bean);
           }//while end
         
      }
      
     }catch(Exception ex){System.out.println("Error: "+ex);}
     
     return list;
    }//dbSelect(X) end
 
 
   /*
    * public DBbean dbDetail(int data) { DBbean bean = new DBbean( ); try {
    * msg="select * from qa where num = " + data; ST=CN.createStatement();
    * RS=ST.executeQuery(msg); if(RS.next()==true) {
    * bean.setid(RS.getString("id")); bean.settitle(RS.getString("title"));
    * bean.setnalja(RS.getDate("nalja")); bean.setcontent(RS.getString("content"));
    * bean.setvi(RS.getInt("vi")); }//if end }catch(Exception
    * ex){System.out.println("Error: "+ex);} return bean; }//dbDetail(int data) end
    */  
 
 public void dbDetailcount(int num) {     
      try {
         msg = "update qa set vi = vi+1 where num=?";
         PST=CN.prepareStatement(msg);
            PST.setInt(1, num);
            PST.executeUpdate();
                   
      }catch(Exception ex){System.out.println("Error: "+ex);}
    }//end
 
 public DBbean dbDetail(int num) {
     DBbean bean = null;      
      try {
         msg2 = "select * from qa where num=?";
         PST=CN.prepareStatement(msg2);
            PST.setInt(1, num);
         RS=PST.executeQuery();
         if(RS.next()) {
             bean = new DBbean();
             bean.setid(RS.getString("id"));
             bean.settitle(RS.getString("title")); 
             bean.setnum(RS.getInt("num"));
             bean.setnalja(RS.getDate("nalja"));
             bean.setcontent(RS.getString("content"));
             bean.setvi(RS.getInt("vi"));
             bean.setreplycnt(RS.getInt("replycnt"));
         }         
      }catch(Exception ex){System.out.println("Error: "+ex);}
      return bean;
    }//end
  
  public void dbDelete(int num) {
      try {
         msg="delete from qa where num = " +num;
         ST=CN.createStatement();
         ST.executeUpdate(msg);
         
            System.out.println(num+ " delete OK!!! ");
         
      }catch(Exception ex){System.out.println("Error: "+ex);}
  }//end
  
  public void dbreplyDelete(int num) {
      try {
         msg="delete from reply where qanum = " +num;
         ST=CN.createStatement();
         ST.executeUpdate(msg);
         System.out.println(num+ " 게시글의 댓글 ");
         
      }catch(Exception ex){System.out.println("Error: "+ex);}
 }//end
  
  
  
  public void dbwriter(DBbean bean) {
      try {
         msg = "insert into qa values (?, qa_seq.nextval, ?, sysdate, ?, 0, 0)";         
          PST=CN.prepareStatement(msg);
              PST.setString(1, bean.getid());
              PST.setString(2, bean.gettitle());
              PST.setString(3, bean.getcontent());
           //   PST.setInt(4, bean.getvi());              
           RS=PST.executeQuery();      
         
      }catch(Exception ex){System.out.println("Error: "+ex);}      
    }//end
  
  public DBbean dbEdit(DBbean bean) {
     try {
         msg="update qa set title=?,content=?,nalja=sysdate where num=?";
         PST=CN.prepareStatement(msg);     
              PST.setString(1, bean.gettitle());
              PST.setString(2, bean.getcontent());
              PST.setInt(3,bean.getnum());
              PST.executeUpdate();
          RS=PST.executeQuery();
           System.out.println("dbEdit(DBbean bean) 수정성공");
       }catch(Exception ex){System.out.println("Error: "+ex);}
     return bean;
  }
  
  public void dbMemberEdit(DBbean bean) {
     try {
         msg="update cf set pw=?, name=?, birth=?, email=?, phone=?, add1=?, add2=? where id=?";
         PST=CN.prepareStatement(msg);     
              PST.setString(1, bean.getpw());
              PST.setString(2, bean.getname());
              PST.setString(3, bean.getbirth());
              PST.setString(4, bean.getemail());
              PST.setString(5, bean.getphone());
              PST.setString(6, bean.getadd1());
              PST.setString(7, bean.getadd2());
              PST.setString(8, bean.getid());
              PST.executeUpdate();
          RS=PST.executeQuery();
           System.out.println("dbEdit(DBbean bean) 수정성공");
       }catch(Exception ex){System.out.println("Error: "+ex);}
       
  }
  
 
  public void dbtest() {
   try {
      //��=紐⑦삎=蹂듬텤               
   }catch(Exception ex){System.out.println("Error: "+ex);}      
 }//end
 
}//DBDAO class END