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
	
	//�α��� ���� ���� �κ�
	@RequestMapping(value="/login.do")
	public String login() {
		return "catlogin";
	}//end
	
	//�α��� ó���ϴ� �κ�
	@RequestMapping(value="/loginProcess.do",method=RequestMethod.POST)	
	public String loginProcess(HttpSession session,JoinDTO dto) {
		System.out.println(dto.getId());
		System.out.println(dto.getPwd());
		String returnURL = "";
		if(session.getAttribute("login") != null) {
			//������ login�̶� ���� ���� �����Ѵٸ�
			session.removeAttribute("login"); //���� ���� ����
		}
		
		//�α����� �����ϸ� JoinDTO ��ü�� ��ȯ
		JoinDTO jo = service.login(dto);
		
		if(jo != null) { //�α��� ����
			session.setAttribute("login", jo.getId()); //���ǿ� login�̶� �̸����� JoinDTO ��ü�� ������
			returnURL = "catmain";   
		}else { //�α����� ������ ���
			returnURL = "redirect:/login.do"; // �α��� ������ �ٽ� ������ ��
		
		}
		return returnURL; // ������ ������ returnURL �� ��ȯ�ؼ� �̵���Ŵ		
	}//end
	
	//�α׾ƿ� �ϴ� �κ�
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate(); //���� ��ü�� ��������
		return "redirect:/login.do";
	}
	
}//calss end
