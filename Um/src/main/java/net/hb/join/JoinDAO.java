package net.hb.join;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class JoinDAO {
	
	boolean flag = false;
	
	
	@Autowired	
	SqlSessionTemplate temp;
	
	public boolean dbInsert(JoinDTO dto) {
		System.out.println("다오"+dto.getId());	
		System.out.println("다오"+dto.getPwd());
		System.out.println("다오"+dto.getBirth());
		System.out.println("다오"+dto.getEmail());	
		System.out.println("다오"+dto.getPhone());	
		System.out.println("다오"+dto.getName());	
		System.out.println("다오"+dto.getJuso1());
		System.out.println("다오"+dto.getJuso2());
		int cnt = temp.insert("join.insert",dto);
		if(cnt>0) {
			flag=true;
		}else {
			flag=false;
		}
			return flag;
	}//end
	
	
	public boolean dbIdcheck(String data) {
		System.out.println(data);
		int cnt = temp.selectOne("join.idcheck",data);		
		if(cnt>0) {
			flag=true;
		}else {
			flag=false;
		}
			return flag;
	}//end
	
	
}//class END
