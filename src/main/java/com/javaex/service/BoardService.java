package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	/* 리스트 */
	public List<BoardVo> exeGetBoardList(){
		System.out.println("BoardService.exeGetBoardList()");
		
		List<BoardVo> boardList = boardDao.getBoardList();
		
		return boardList;
		
	}
	/* 읽기 */
	public BoardVo exeBoardRead(int no){
		System.out.println("BoardService.exeBoardRead()");
		
		BoardVo boardRead = boardDao.getBoardRead(no);
		System.out.println(boardRead + "서비스는 받았다 게시글의 번호");
		return boardRead;
	}
	/* 삭제 */
	public void deleteBoard(int no) {
		//컨트롤러가 준 no를 다오한테 넘겨주고 다오의 게시글 삭제 메소드 발동!
		boardDao.deleteBoard(no);
	}

}
