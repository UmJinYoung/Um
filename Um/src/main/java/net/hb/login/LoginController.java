package net.hb.login;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.hb.join.JoinDTO;

@Controller
public class LoginController {
	
	@Inject
	LoginServiceImpl service;
	
	//로그인 폼을 띄우는 부분
	@RequestMapping(value="/login.do")
	public String login() {
		return "catlogin";
	}//end
	
	//로그인 처리하는 부분
	@RequestMapping(value="/loginProcess.do",method=RequestMethod.POST)	
	public String loginProcess(HttpSession session,JoinDTO dto) {
		System.out.println(dto.getId());
		System.out.println(dto.getPwd());
		String returnURL = "";
		if(session.getAttribute("login") != null) {
			//기존에 login이란 세션 값이 존재한다면
			session.removeAttribute("login"); //기존 값을 제거
		}
		
		//로그인이 성공하면 JoinDTO 객체를 반환
		JoinDTO jo = service.login(dto);
		
		if(jo != null) { //로그인 성공
			session.setAttribute("login", jo.getId()); //세션에 login이란 이름으로 JoinDTO 객체를 저장함
			returnURL = "catmain";   
		}else { //로그인이 실패한 경우
			returnURL = "redirect:/login.do"; // 로그인 폼으로 다시 가도록 함
		
		}
		return returnURL; // 위에서 설정한 returnURL 을 반환해서 이동시킴		
	}//end
	
	//로그아웃 하는 부분
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate(); //세션 전체를 날려버림
		return "redirect:/login.do";
	}
	
}//calss end
