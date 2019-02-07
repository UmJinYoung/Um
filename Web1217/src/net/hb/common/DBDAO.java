package net.hb.common;

import java.sql.*;
import java.util.ArrayList;

public class DBDAO {
   Connection CN; 
   Statement ST, ST3 ; //ST=CN.createStatement()
   PreparedStatement PST; //PST=CN.prepareStatment(sql)
   CallableStatement CS; //CS=CN.callableStatement(sql)
   ResultSet RS, RS3; //  RS.next( )
 
   String msg, msg3; 
   int a,Gsabun,  d, Gpay ; 
   String b, Gname, c , Gtitle; 
   java.util.Date Gnalja; 
   int Gtotal=27, Stotal=7, Rtotal=0; 
   
   int Rnum ; 
   int Rrn ; 
   String Rdata, Rwriter, Rcontent, datas; //guestreply.jsp
   int Rsabun;
   boolean flag=false;	
	
  public DBDAO( ) {
	CN=DB.getConnection();   
  }//생성자end
	
  
 public void dbInsert(DBbean bean) {
   try {//권장
     msg="insert into guest  values(?,?,?,sysdate,?)";
     PST=CN.prepareStatement(msg);
     	PST.setInt(1,bean.getSabun());
     	PST.setString(2, bean.getName());
     	PST.setString(3, bean.getTitle());
     	PST.setInt(4, bean.getPay());
     PST.executeUpdate();
     System.out.println("dbInsert(DBbean bean) 저장성공");
   }catch(Exception ex){System.out.println("Error: "+ex);}
 }//end
 
 
 public ArrayList<DBbean> dbSelect(int start, int end){
  ArrayList<DBbean> list=new ArrayList<DBbean>( );	
  try {
	  	 String x=" select * from ( ";
		 String y=" select rownum rn, sabun,name,title,nalja,pay from guest ";
		 String z=" ) where rn between "+start+" and "+end;
	  msg=x+y+z;
	  ST=CN.createStatement();
	  RS=ST.executeQuery(msg);
	  while(RS.next()==true) {
		 DBbean bean=new DBbean();
		  bean.setRn(RS.getInt("rn"));
		  bean.setSabun(RS.getInt("sabun"));
		  bean.setName(RS.getString("name"));
		  bean.setTitle(RS.getString("title"));
		  bean.setNalja(RS.getDate("nalja"));
		  bean.setPay(RS.getInt("pay"));
		  list.add(bean);
	  }//while end
   
  }catch(Exception ex){System.out.println("Error: "+ex);}
  return list;
 }//dbSelect(X) end
 
 public DBbean dbDetail(int data) {
	    DBbean bean = new DBbean( );	 
	  try {
	    msg="select * from guest where sabun = " + data;
	    ST=CN.createStatement();    		
	    RS=ST.executeQuery(msg);
	    if(RS.next()==true) {
	      bean.setSabun(RS.getInt("sabun"));
	      bean.setName(RS.getString("name"));
	      bean.setTitle(RS.getString("title"));
	      bean.setNalja(RS.getDate("nalja"));
	      bean.setPay(RS.getInt("pay"));
	    }//if end
	  }catch(Exception ex){System.out.println("Error: "+ex);}
	  return bean;
	 }//dbDetail(int data) end
 
 public void dbDelete(int data) {
   try {
	   msg="delete from guest where sabun = " + data ;
		ST=CN.createStatement();
		ST.executeUpdate(msg);
		System.out.println(data+ " delete OK!!! ");
   }catch(Exception ex){System.out.println("Error: "+ex);}
 }//end
 
 public void dbEdit(DBbean bean) {
	 try {
		msg="update guest set name=?,title=?,nalja=sysdate,pay=? where sabun=?";
		PST=CN.prepareStatement(msg);  	
	     	PST.setString(1, bean.getName());
	     	PST.setString(2, bean.getTitle());
	     	PST.setInt(3, bean.getPay());
	     	PST.setInt(4,bean.getSabun());
	     	PST.executeUpdate();
     	System.out.println("dbEdit(DBbean bean) 수정성공");
	 }catch(Exception ex){System.out.println("Error: "+ex);}
 }
 
 
 public int dbCount() {
  try {
	msg="select count(*) as cnt from guest ";
	ST=CN.createStatement();
	RS=ST.executeQuery(msg);
	RS.next() ;
	Gtotal=RS.getInt("cnt");
   }catch(Exception ex){System.out.println("Error: "+ex);}
  return Gtotal;
 }//end
 
 
  public void dbtest() {
	try {
      //틀=모형=복붙				   
	}catch(Exception ex){System.out.println("Error: "+ex);}	   
 }//end
 
}//DBDAO class END

