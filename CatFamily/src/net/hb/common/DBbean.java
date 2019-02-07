package net.hb.common;

public class DBbean {
 
 //회원가입 정보 변수
 private String id;
 private String pw;
 private String name;
 private String birth;
 private String email;
 private String phone;
 private String add1;
 private String add2;
 private String cat;
  
 //페이징, QA게시판 변수
 private int rn, start, end, vi;
 private String title, content;
 private java.util.Date nalja;
 private int num;
 private int replycnt;
  
 //QA게시판 댓글 변수
 private int comment_num;        // 댓글 글번호
 private int comment_qanum;		//게시글 번호
 private String comment_id;        // 댓글 작성자
 private java.util.Date comment_date; // 댓글 작성일
 private int comment_parent;        // 부모글
 private String comment_content;    // 댓글 내용
 
 //CAT게시판 변수
 private String Cat_name;
 private int Cat_num;
 private String Cat_title;
 private String Cat_img1;
 private String Cat_img2;
 private String Cat_img3;
 private String Cat_img4;
 private int Cat_rn;
  
 //페이징, QA게시판 BEAN
 public int getRn() {return rn;}
 public void setRn(int rn) {this.rn = rn;}
 public int getStart() {return start;}
 public void setStart(int start) {this.start=start;}
 public int getEnd() {return end;}
 public void setEnd(int end) {this.end=end;}
 public String gettitle() {return title;}
 public void settitle(String title) {this.title = title;}
 public String getcontent() {return content;}
 public void setcontent(String content) {this.content = content;}
 public java.util.Date getnalja() {return nalja;	}
 public void setnalja(java.util.Date nalja) {this.nalja = nalja;}
 public int getvi() {return vi;}
 public void setvi(int vi) {this.vi = vi;}
 public int getnum() {return num;}
 public void setnum(int num) {this.num = num;}
 public int getreplycnt() {return replycnt;}
 public void setreplycnt(int replycnt) {this.replycnt=replycnt;}

 //회원가입 정보 BEAN
 public String getid() {return id;}
 public void setid(String id) {this.id = id;}
 public String getpw() {return pw;}
 public void setpw(String pw) {this.pw = pw;}
 public String getname() {return name;}
 public void setname(String name) {this.name = name;}    
 public String getbirth() {return birth;   }
 public void setbirth(String birth) {this.birth = birth;   }
 public String getemail() {return email;   }
 public void setemail(String email) {this.email = email;   }
 public String getphone() {return phone;   }
 public void setphone(String phone) {this.phone = phone;   }   
 public String getadd1() {return add1;}
 public void setadd1(String add1) {this.add1 = add1;   }
 public String getadd2() {return add2;}
 public void setadd2(String add2) {this.add2 = add2; }
 public String getcat() {return cat;}
 public void setcat(String cat) {this.cat = cat; }
 
 //QA게시판 댓글 BEAN
 public int getComment_num() {return comment_num;}
 public void setComment_num(int comment_num) {this.comment_num = comment_num;}
 public int getComment_qanum() {return comment_qanum;}
 public void setComment_qanum(int comment_qanum) {this.comment_qanum = comment_qanum;}
 public String getComment_id() {return comment_id;}
 public void setComment_id(String comment_id) {this.comment_id = comment_id;}
 public java.util.Date getComment_date() {return comment_date;}
 public void setComment_date(java.util.Date comment_date) {this.comment_date = comment_date;}
 public int getComment_parent() {return comment_parent;}
 public void setComment_parent(int comment_parent) {this.comment_parent = comment_parent;}
 public String getComment_content() {return comment_content;}
 public void setComment_content(String comment_content) {this.comment_content = comment_content;}
 
 //CAT게시판 BEAN
 public int getCat_rn() {return Cat_rn;}
 public void setCat_rn(int Cat_rn) {this.Cat_rn = Cat_rn;} 
 public String getCat_name() {return Cat_name;} 
 public void setCat_name(String Cat_name) {this.Cat_name = Cat_name;}
 public int getCat_num() {return Cat_num;}
 public void setCat_num(int Cat_num) {this.Cat_num = Cat_num;}
 public String getCat_title() {return Cat_title;} 
 public void setCat_title(String Cat_title) {this.Cat_title = Cat_title;}
 public String getCat_img1() {return Cat_img1;} 
 public void setCat_img1(String Cat_img1) {this.Cat_img1 = Cat_img1;}
 public String getCat_img2() {return Cat_img2;} 
 public void setCat_img2(String Cat_img2) {this.Cat_img2 = Cat_img2;}
 public String getCat_img3() {return Cat_img3;} 
 public void setCat_img3(String Cat_img3) {this.Cat_img3 = Cat_img3;}
 public String getCat_img4() {return Cat_img4;} 
 public void setCat_img4(String Cat_img4) {this.Cat_img4 = Cat_img4;}
	
}//DBbean class END
