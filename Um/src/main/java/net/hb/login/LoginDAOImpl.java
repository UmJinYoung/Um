package net.hb.login;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import net.hb.join.JoinDTO;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	@Inject
    SqlSession sqlSession;
	
	@Override
	public JoinDTO login(JoinDTO dto) {		
		System.out.println(dto.getId());
		System.out.println(dto.getPwd());
		return sqlSession.selectOne("join.login", dto);				
	}// end
}//class END
