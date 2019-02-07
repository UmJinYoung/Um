package net.hb.join;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSON;
import net.sf.json.JSONObject;


@Controller
public class JoinController {	
	
	@Inject
	@Autowired
	JoinDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(JoinController.class);	
	
	@RequestMapping("/join.do")
	public String join_join() {
		return "catjoin";		
	}//end
	
	@RequestMapping("/main.do")
	public String cat_main() {
		return "catmain";
	}//end
	
	@RequestMapping("/insert.do")
	public @ResponseBody JSONObject join_insert(JoinDTO dto) {
		JSONObject json = new JSONObject();
		String birth = dto.getBirth1()+"년"+dto.getBirth2()+"월"+dto.getBirth3()+"일";
		String email = dto.getEmail1()+dto.getEmail2();
		String phone = dto.getPhone1()+dto.getPhone2()+dto.getPhone3();
		dto.setBirth(birth);
		dto.setEmail(email);
		dto.setPhone(phone);
		System.out.println("컨트롤"+dto.getId());	
		System.out.println("컨트롤"+dto.getPwd());
		System.out.println("컨트롤"+dto.getBirth());
		System.out.println("컨트롤"+dto.getEmail());	
		System.out.println("컨트롤"+dto.getPhone());	
		System.out.println("컨트롤"+dto.getName());	
		System.out.println("컨트롤"+dto.getJuso1());
		System.out.println("컨트롤"+dto.getJuso2());		
		boolean f = dao.dbInsert(dto);
		json.put("p", f);
		return json;
	}//end	
	
	@RequestMapping("/check.do")
	public @ResponseBody JSONObject join_check(@RequestParam("userid") String data) {
		JSONObject json = new JSONObject();
		JoinDTO dto = new JoinDTO();
		dto.setId(data);
		System.out.println(data);
		boolean f = dao.dbIdcheck(data);		
		json.put("t", f);
		return json;
	}//end

}//class END
