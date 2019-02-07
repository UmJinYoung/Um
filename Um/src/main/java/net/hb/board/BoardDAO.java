package net.hb.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class BoardDAO {
	
	@Autowired
	SqlSessionTemplate temp;
	
	public void dbInsert(BoardDTO dto) {
		temp.insert("board.insert", dto);
	}//end
	
	public List<BoardDTO> dbselect(int start, int end, String skey, String sval) {
		@SuppressWarnings("unchecked")
		BoardDTO dto = new BoardDTO();
		dto.setStart(start);
		dto.setEnd(end);
		dto.setSkey(skey);
		dto.setSval(sval);
		List<BoardDTO> list = temp.selectList("board.selectAll", dto);
		return list;
	}//end
	
	public int dbCountSearch(String skey, String sval) { //°Ë»ö °¹¼ö
		BoardDTO dto = new BoardDTO();
			dto.setSkey(skey);
			dto.setSval(sval);
		int cnt = (Integer)temp.selectOne("board.countAllSearch", dto);
		return cnt;		
	}//end
	
	public int dbCount() { //ÀüÃ¼ °¹¼ö
		int cnt = (Integer)temp.selectOne("board.countAll");
		return cnt;
	}//end
	
	public BoardDTO dbDetail(int data) {
		BoardDTO dto = (BoardDTO)temp.selectOne("board.detail",data);
		return dto;
	}//end
	
	public void dbDelete(int data) {
		temp.delete("board.delete", data);
	}//end
	
	public BoardDTO dbpreEdit(int data) {
		BoardDTO dto = (BoardDTO)temp.selectOne("board.preEdit", data);
		return dto;
	}//end
	
	public void dbEdit(BoardDTO dto) {
		System.out.println(dto.getIdx());
		System.out.println(dto.getTitle());
		System.out.println(dto.getContent());
		temp.update("board.edit", dto);		
	}//end

}//class END
