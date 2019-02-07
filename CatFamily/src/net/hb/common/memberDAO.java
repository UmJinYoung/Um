
package net.hb.common;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class memberDAO {
   Connection CN; 
   Statement ST, ST3 ; //ST=CN.createStatement()
   PreparedStatement PST; //PST=CN.prepareStatment(sql)
   CallableStatement CS; //CS=CN.callableStatement(sql)
   ResultSet RS, RS3; //  RS.next( )
 
   String msg, msg2, msg3; 
   java.util.Date Gnalja; 
   int memeberCount;
   
   private static memberDAO instance;

  public memberDAO( ) {
	CN=DB.getConnection();   
  }//�깮�꽦�옄end
  
  public static memberDAO getInstance(){
      if(instance==null)
          instance=new memberDAO();
      return instance;
  }
  
  public int dbmemberCount(HashMap<String, Object> listOpt) {
	  ArrayList<DBbean> list=new ArrayList<DBbean>( );	
	  String keyfield=(String)listOpt.get("keyfield");
	  String keyword=(String)listOpt.get("keyword");
	  try {
		  if(keyfield==null || keyfield=="") {
			  msg="select count(*) as cnt from cf ";
				ST=CN.createStatement();
				RS=ST.executeQuery(msg);
				RS.next();
				memeberCount=RS.getInt("cnt");
				System.out.println("전체검색"+memeberCount);
		  }else if(keyfield.equals("id")) {
			  msg="select count(*) as cnt from cf where id like '%"+keyword+"%'";
				ST=CN.createStatement();
				RS=ST.executeQuery(msg);
				RS.next();
				memeberCount=RS.getInt("cnt");
				System.out.println("아이디검색:"+memeberCount);
		  }else if(keyfield.equals("name")) {
			  msg="select count(*) as cnt from cf where name like '%"+keyword+"%'";
				ST=CN.createStatement();
				RS=ST.executeQuery(msg);
				RS.next();
				memeberCount=RS.getInt("cnt");
				System.out.println("이름검색:"+memeberCount);
		  }
	   }catch(Exception ex){System.out.println("Error: "+ex);}
	  return memeberCount;
 }//end
	 
 public ArrayList<DBbean> dbmemberSelect(int start, int end, HashMap<String, Object> listOpt){
 //	  System.out.println("들어옴?");
	  ArrayList<DBbean> list=new ArrayList<DBbean>( );	
	  String keyfield=(String)listOpt.get("keyfield");
	  String keyword=(String)listOpt.get("keyword");
	  
	  try {
		if(keyfield==null || keyfield=="") {
			  String x=" select * from ( ";
			  String y=" select rownum rn, id, pw, name, birth, email, phone, add1, add2 from cf ";
			  String z=" ) where rn between "+start+" and "+ end;
			  msg=x+y+z;
			  ST=CN.createStatement();
			  RS=ST.executeQuery(msg);
			  
			  while(RS.next()==true) {
				 DBbean bean=new DBbean();
				  bean.setRn(RS.getInt("rn"));
				  bean.setid(RS.getString("id"));
				  bean.setname(RS.getString("name"));
				  bean.setbirth(RS.getString("birth"));
				  bean.setemail(RS.getString("email"));
				  bean.setphone(RS.getString("phone"));
				  bean.setadd1(RS.getString("add1"));
				  bean.setadd2(RS.getString("add2"));
				  list.add(bean);
			  }//while end
		}else if(keyfield.equals("id")) {//아이디로 검색
			String x=" select * from ( ";
			  String y=" select rownum rn, id, pw, name, birth, email, phone, add1, add2 from cf where id like '%"+keyword+"%'";
			  String z=" ) where rn between "+start+" and "+ end;
//			  msg=" select count(*) as cnt from qa where "+keyfield+" like '%"+keyword+"%'";
			  msg=x+y+z;
			  ST=CN.createStatement();
			  RS=ST.executeQuery(msg);
			  System.out.println("msg:"+msg);
			  
			  while(RS.next()==true) {
				  DBbean bean=new DBbean();
				  bean.setRn(RS.getInt("rn"));
				  bean.setid(RS.getString("id"));
				  bean.setname(RS.getString("name"));
				  bean.setbirth(RS.getString("birth"));
				  bean.setemail(RS.getString("email"));
				  bean.setphone(RS.getString("phone"));
				  bean.setadd1(RS.getString("add1"));
				  bean.setadd2(RS.getString("add2"));
				  list.add(bean);
			  }//while end
//			  System.out.println("완료됨?");
		}else if(keyfield.equals("name")) {//이름으로 검색
			String x=" select * from ( ";
			  String y=" select rownum rn, id, pw, name, birth, email, phone, add1, add2 from cf where name like '%"+keyword+"%'";
			  String z=" ) where rn between "+start+" and "+ end;
//			  msg=" select count(*) as cnt from qa where "+keyfield+" like '%"+keyword+"%'";
			  msg=x+y+z;
			  ST=CN.createStatement();
			  RS=ST.executeQuery(msg);
			  System.out.println("msg:"+msg);
			  
			  while(RS.next()==true) {
				  DBbean bean=new DBbean();
				  bean.setRn(RS.getInt("rn"));
				  bean.setid(RS.getString("id"));
				  bean.setname(RS.getString("name"));
				  bean.setbirth(RS.getString("birth"));
				  bean.setemail(RS.getString("email"));
				  bean.setphone(RS.getString("phone"));
				  bean.setadd1(RS.getString("add1"));
				  bean.setadd2(RS.getString("add2"));
				  list.add(bean);
			  }//while end
//			  System.out.println("완료됨?");
		}
		
	  }catch(Exception ex){System.out.println("Error: "+ex);}
	  
	  return list;
 }//dbSelect(X) end
 
 public DBbean dbmemberDetail(String id) {
     DBbean bean = null;      
      try {
         msg2 = "select * from cf where id=?";
         PST=CN.prepareStatement(msg2);
            PST.setString(1, id);
         RS=PST.executeQuery();
         if(RS.next()) {
             bean = new DBbean();
             bean.setid(RS.getString("id"));
             bean.settitle(RS.getString("name")); 
             bean.setbirth(RS.getString("birth"));
             bean.setemail(RS.getString("email"));
             bean.setphone(RS.getString("phone"));
             bean.setadd1(RS.getString("add1"));
             bean.setadd2(RS.getString("add2"));
             bean.setcat(RS.getString("cat"));
         }         
      }catch(Exception ex){System.out.println("Error: "+ex);}
      return bean;
    }//end

  public void dbtest() {
	try {
      //��=紐⑦삎=蹂듬텤				   
	}catch(Exception ex){System.out.println("Error: "+ex);}	   
 }//end
 
}//DBDAO class END