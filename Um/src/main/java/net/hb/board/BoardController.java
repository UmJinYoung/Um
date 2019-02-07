package net.hb.board;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	@Inject
	@Autowired
	BoardDAO dao;
	
	@Autowired
	private ServletContext  application;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping("/write.do")
	public String board_write() {
		return "Boardwrite";
	}//end
	
	@RequestMapping(value="/boardinsert.do", method = RequestMethod.POST)
	public String board_insert(@RequestParam("id") String id,BoardDTO dto) {
		System.out.println("??");
		dto.setId(id);
		System.out.println(dto.getId());
		String path = application.getRealPath("/resources/upload");
		System.out.println(path);
		String img = dto.getUpload_f().getOriginalFilename();
		File file = new File(path, img); // 자바 기초 io패키지 File화

		try {
			dto.getUpload_f().transferTo(file);
		} catch (Exception ex) {
			System.out.println("파일에러:" + ex);
		}

		dto.setImg_file_name(img);
		System.out.println("컨트롤 넘어온파일=" + dto.getImg_file_name());
		System.out.println(dto.getUpload_f());
		dao.dbInsert(dto);
		return "redirect:/boardlist.do";
	}// end
	
	@RequestMapping("/boardlist.do")
	public ModelAndView board_select(HttpServletRequest requset) {
		ModelAndView mav = new ModelAndView();
		int startpage=1, endpage=10;
		String pnum="";
		int pageNUM=1, start=1, end=10;
		int pagecount=1, temp=0;
		String skey="", sval="", returnpage="";
		String AA="", BB="";
		
		skey=requset.getParameter("keyfield");
		sval=requset.getParameter("keyword");
		
		if(skey==null || skey=="" || sval==null || sval=="") {
			skey="title"; sval="";
		}
		
		returnpage="&keyfield="+skey+"&keyword="+sval;
		if(skey.equals("id")) {
			AA=skey;
		}else if(skey.equals("title")) {
			BB=skey;
		}
		
		int Stotal=dao.dbCountSearch(skey, sval); //조회한 갯수
		
		pnum=requset.getParameter("pageNUM");
		if(pnum==""|| pnum==null) {
			pageNUM=1;
		}else {
			pageNUM=Integer.parseInt(pnum);
		}
		
		
		
		int Gtotal = dao.dbCount(); //레코드 전체 갯수
		
		if(Gtotal%10==0) {
			pagecount=Stotal/10;
		}else {
			pagecount=(Stotal/10)+1;
		}
		
		start=(pageNUM-1)*10+1;
		end=(pageNUM)*10;
		
		temp=(pageNUM-1)%10;
		
		startpage=pageNUM-(pageNUM-1)%10;
		endpage=startpage+9;
		
		
		if(endpage>pagecount) {
			endpage=pagecount;
		}
		
		List<BoardDTO> list = dao.dbselect(start,end,skey,sval);
		mav.addObject("list", list);
		mav.addObject("Gtotal", Gtotal);
		mav.addObject("Stotal", Stotal);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("pagecount", pagecount);
		mav.addObject("pageNUM", pageNUM);
		mav.addObject("returnpage", returnpage);
		mav.addObject("AA", AA);
		mav.addObject("BB", BB);
		mav.addObject("sval", sval);
		mav.setViewName("BoardList");
		return mav;		
	}//end
	
	@RequestMapping("/detail.do")
	public ModelAndView board_detail(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		int data = Integer.parseInt(request.getParameter("idx"));
		BoardDTO dto = dao.dbDetail(data);
		mav.addObject("bean", dto);
		mav.setViewName("BoardDetail");
		return mav;
	}
	
	@RequestMapping("/boarddelete.do")
	public String board_delete(@RequestParam("idx") int data) {
		dao.dbDelete(data);
		return "redirect:/boardlist.do";
	}
	
	@RequestMapping("/boardpreEdit.do")
	public ModelAndView board_preEdit(@RequestParam("idx") int data) {
		ModelAndView mav = new ModelAndView();
		BoardDTO dto = dao.dbpreEdit(data);
		mav.addObject("bean",dto);
		mav.setViewName("BoardEdit");
		return mav;
	}//end
	
	@RequestMapping(value="/boardedit.do", method = RequestMethod.POST)
	public String board_edit(BoardDTO dto) {
		
		System.out.println(dto.getIdx());
		System.out.println(dto.getTitle());
		System.out.println(dto.getContent());
		
		String path=application.getRealPath("/resources/upload");
		System.out.println(path);
		MultipartFile mf=dto.getUpload_f();
		String img=mf.getOriginalFilename();
		
		File file=new File(path, img);
		try{
	    //dto.getUpload_f().transferTo(file);  
	  	//FileCopyUtils클래스사용
	    FileCopyUtils.copy(dto.getUpload_f().getBytes(), file);
		}catch(Exception ex){ }
		dto.setImg_file_name(img);
		System.out.println(dto.getImg_file_name());
		dao.dbEdit(dto);
		return "redirect:/boardlist.do";
	}
	
	
	
}//class END
