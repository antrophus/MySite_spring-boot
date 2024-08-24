package com.javaex.dao;

import java.util.List;

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

		List<GuestbookVo> guestList = sqlSession.selectList("guestbook.selectList");

		return guestList;
	}

	/* 방명록 등록 */
	public int insertGuestbook(GuestbookVo guestbookVo) {

		int count = sqlSession.insert("guestbook.insert", guestbookVo);
		System.out.println(count);
		return count;
	}

}
