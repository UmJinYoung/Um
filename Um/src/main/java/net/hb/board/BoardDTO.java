package net.hb.board;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
	
	private int idx;
	private String id;
	private String title;	
	private java.util.Date nalja;
	private String content;
	private String img_file_name;
	private MultipartFile upload_f ;
	
	//페이징 행번호, 페이지 시작행, 페이지 끝행
	private int rn;
	private int start;
	private int end;
	
	public int getRn() { return rn; }
	public void setRn(int rn) { this.rn = rn; }
	public int getStart() { return start; }
	public void setStart(int start) { this.start = start; }
	public int getEnd() { return end; }
	public void setEnd(int end) { this.end = end; }
	
	
	//검색 필드, 검색 키워드
	private String skey;
	private String sval;	
	
	public String getSkey() { return skey; }
	public void setSkey(String skey) { this.skey = skey; }
	public String getSval() { return sval; }
	public void setSval(String sval) { this.sval = sval; }
	
	
	public int getIdx() { return idx; }
	public void setIdx(int idx) { this.idx = idx; }
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public java.util.Date getNalja() { return nalja; }
	public void setNalja(java.util.Date nalja) { this.nalja = nalja; }
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }
	public String getImg_file_name() { return img_file_name; }
	public void setImg_file_name(String img_file_name) { this.img_file_name = img_file_name; }
	public MultipartFile getUpload_f() { return upload_f; }
	public void setUpload_f(MultipartFile upload_f) { this.upload_f = upload_f; }	

}
