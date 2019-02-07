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
		System.out.println("�ٿ�"+dto.getId());	
		System.out.println("�ٿ�"+dto.getPwd());
		System.out.println("�ٿ�"+dto.getBirth());
		System.out.println("�ٿ�"+dto.getEmail());	
		System.out.println("�ٿ�"+dto.getPhone());	
		System.out.println("�ٿ�"+dto.getName());	
		System.out.println("�ٿ�"+dto.getJuso1());
		System.out.println("�ٿ�"+dto.getJuso2());
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
