package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;

	/* 방명록 읽기 */
	public List<GuestbookVo> getGuestlist() {
		//guestbook.xml 에서 db로부터 리스트를 받아오도록 시켜서 guestList에 담는다.
		List<GuestbookVo> guestList = sqlSession.selectList("guestbook.selectList");
		return guestList;
	}

	/* 방명록 등록 */
	public int insertGuestbook(GuestbookVo guestbookVo) {

		int count = sqlSession.insert("guestbook.insert", guestbookVo);
		System.out.println(count);
		return count;
	}

	// 특정 방명록 항목 가져오기 (no로 조회) - 삭제폼에서 디비자료 필요한줄 알았는데, 컨트롤러가 no받아 포워딩 해서 jsp로 넘김. 여기까지 오지도 않음.
//	public GuestbookVo getNo(int no) {
//
//		GuestbookVo guestbookVo = sqlSession.selectOne("guestbook.selectOne", no);
//		System.out.println(guestbookVo + "dao에서 가져온 삭제할 방명록 정보");
//		return guestbookVo;
//
//	}

	/* 방명록 항목 삭제 */
	public int deleteGuestbook(int no, String password) {
		Map<String, Object> params = new HashMap<>();
		
		params.put("no", no);
		params.put("password", password);

		return sqlSession.delete("guestbook.delete", params);
	}

}
