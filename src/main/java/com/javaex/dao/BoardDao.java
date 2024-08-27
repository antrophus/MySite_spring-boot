package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {

	// 필드
	@Autowired
	private SqlSession sqlSession;
	// 생성자

	// 메소드 -gs

	// 메소드 일반

	/* 리스트가져오기 */
	public List<BoardVo> getBoardList() {

		List<BoardVo> boardList = sqlSession.selectList("board.selectList");

		return boardList;
	}

	/* 게시글 읽기 */
	public BoardVo getBoardRead(int no) {
		//하나의 게시물에 여러 종류의 데이터가 있을때 게시물 번호 하나만 불러오면 된다.
		BoardVo boardRead = sqlSession.selectOne("board.selectOne", no);
		System.out.println(boardRead + "다오는 읽었다. 디비에서");
		
		return boardRead;
	}
	
	/* 삭제 */
	
	public int deleteBoard(int no) {
		//xml에 게시글 번호 주고 삭제하라고 시키자
		int count = sqlSession.delete("board.delete", no);
		
		return count;
		
	}

}
