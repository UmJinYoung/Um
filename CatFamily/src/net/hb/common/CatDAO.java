
package net.hb.common;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class CatDAO {
   Connection CN; 
   Statement ST, ST3 ; //ST=CN.createStatement()
   PreparedStatement PST; //PST=CN.prepareStatment(sql)
   CallableStatement CS; //CS=CN.callableStatement(sql)
   ResultSet RS, RS3; //  RS.next( )
 
   String msg, msg2, msg3; 
   int Gtotal;
   
   boolean flag2=false;
   boolean flag=false;	
   
   private static CatDAO instance;

  public CatDAO( ) {
	CN=DB.getConnection();   
  }//�깮�꽦�옄end
  
  public static CatDAO getInstance(){
      if(instance==null)
          instance=new CatDAO();
      return instance;
  }
  
 public void dbCatInsert(DBbean bean) {
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
 
 public int dbCatCount() {
	  ArrayList<DBbean> list=new ArrayList<DBbean>( );	
	  try {
			  msg="select count(*) as cnt from cat ";
				ST=CN.createStatement();
				RS=ST.executeQuery(msg);
				RS.next() ;
				Gtotal=RS.getInt("cnt");
				System.out.println("전체검색"+Gtotal);
	   }catch(Exception ex){System.out.println("Error: "+ex);}
	  return Gtotal;
 }//end
	 
 public ArrayList<DBbean> dbCatSelect(int start, int end){
 //	  System.out.println("들어옴?");
	  ArrayList<DBbean> list=new ArrayList<DBbean>( );	
	  
	  try {
			  String x=" select * from ( ";
			  String y=" select rownum rn, cat_name, num, title, img1, img2, img3, img4 from cat ";
			  String z=" ) where rn between "+start+" and "+ end;
			  msg=x+y+z;
			  ST=CN.createStatement();
			  RS=ST.executeQuery(msg);
			  
			  while(RS.next()==true) {
				 DBbean bean=new DBbean();
				  bean.setRn(RS.getInt("rn"));
				  bean.setCat_name(RS.getString("cat_name"));
				  bean.setCat_num(RS.getInt("num"));
				  bean.setCat_title(RS.getString("title"));
				  bean.setCat_img1(RS.getString("img1"));
				  bean.setCat_img2(RS.getString("img2"));
				  bean.setCat_img3(RS.getString("img3"));
				  bean.setCat_img4(RS.getString("img4"));
				 list.add(bean);
			  }//while end
		
	  }catch(Exception ex){System.out.println("Error: "+ex);}
	  
	  return list;
	 }//dbSelect(X) end
 
 
 public DBbean dbCatDetail(int catnum) {
     DBbean bean = new DBbean();      
      try {
         msg = "select cat_name, num, title, img1, img2, img3, img4 from cat where num=?";
         PST=CN.prepareStatement(msg);
            PST.setInt(1, catnum);
         RS=PST.executeQuery();
         if(RS.next()) {
			  bean.setCat_name(RS.getString("cat_name"));
			  bean.setCat_num(RS.getInt("num"));
			  bean.setCat_title(RS.getString("title"));
			  bean.setCat_img1(RS.getString("img1"));
			  bean.setCat_img2(RS.getString("img2"));
			  bean.setCat_img3(RS.getString("img3"));
			  bean.setCat_img4(RS.getString("img4"));
			  
         }         
      }catch(Exception ex){System.out.println("Error: "+ex);}
      return bean;
    }//end
//  
//  public void dbDelete(int num) {
//	   try {
//		   msg="delete from qa where num = " +num;
//			ST=CN.createStatement();
//			ST.executeUpdate(msg);
//			
//            System.out.println(num+ " delete OK!!! ");
//			
//	   }catch(Exception ex){System.out.println("Error: "+ex);}
//  }//end
//  
//  public void dbwriter(DBbean bean) {
//      try {
//         msg = "insert into qa values (?, qa_seq.nextval, ?, sysdate, ?, 0, 0)";         
//          PST=CN.prepareStatement(msg);
//              PST.setString(1, bean.getid());
//              PST.setString(2, bean.gettitle());
//              PST.setString(3, bean.getcontent());
//           //   PST.setInt(4, bean.getvi());              
//           RS=PST.executeQuery();      
//         
//      }catch(Exception ex){System.out.println("Error: "+ex);}      
//    }//end
//  
//  public DBbean dbEdit(DBbean bean) {
//	  try {
//			msg="update qa set title=?,content=?,nalja=sysdate where num=?";
//			PST=CN.prepareStatement(msg);  	
//		     	PST.setString(1, bean.gettitle());
//		     	PST.setString(2, bean.getcontent());
//		     	PST.setInt(3,bean.getnum());
//		     	PST.executeUpdate();
//		    RS=PST.executeQuery();
//	     	System.out.println("dbEdit(DBbean bean) 수정성공");
//		 }catch(Exception ex){System.out.println("Error: "+ex);}
//	  return bean;
//  }
//  
//  public void dbMemberEdit(DBbean bean) {
//	  try {
//			msg="update cf set pw=?, name=?, birth=?, email=?, phone=?, add1=?, add2=? where id=?";
//			PST=CN.prepareStatement(msg);  	
//		     	PST.setString(1, bean.getpw());
//		     	PST.setString(2, bean.getname());
//		     	PST.setString(3, bean.getbirth());
//		     	PST.setString(4, bean.getemail());
//		     	PST.setString(5, bean.getphone());
//		     	PST.setString(6, bean.getadd1());
//		     	PST.setString(7, bean.getadd2());
//		     	PST.setString(8, bean.getid());
//		     	PST.executeUpdate();
//		    RS=PST.executeQuery();
//	     	System.out.println("dbEdit(DBbean bean) 수정성공");
//		 }catch(Exception ex){System.out.println("Error: "+ex);}
//  }
//  
 public void catinsert(String id, String catname) {
	 try {
			msg="update cf set cat=? where id=?";
			PST=CN.prepareStatement(msg);  	
		     	PST.setString(1, catname);
		     	PST.setString(2, id);
		     	PST.executeUpdate();
		    RS=PST.executeQuery();
	     	System.out.println("dbEdit(DBbean bean) 분양신청완료");
		 }catch(Exception ex){System.out.println("Error: "+ex);}
 }
 
 
  public void dbtest() {
	try {
      //��=紐⑦삎=蹂듬텤				   
	}catch(Exception ex){System.out.println("Error: "+ex);}	   
 }//end
 
}//DBDAO class END