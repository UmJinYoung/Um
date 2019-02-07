package net.hb.login;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.hb.join.JoinDTO;

	@Service
	public class LoginServiceImpl implements LoginService {
		
		@Inject
		LoginDAOImpl dao;
		
		@Override
		public JoinDTO login(JoinDTO dto) {		
			System.out.println(dto.getId());
			System.out.println(dto.getPwd());
			return dao.login(dto);				
		}
	}


