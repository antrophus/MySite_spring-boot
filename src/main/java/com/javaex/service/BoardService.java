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
		//조회수 증가
		boardDao.updateHit(no);
		//게시글 가져오기
		BoardVo boardRead = boardDao.getBoardRead(no);
		System.out.println(boardRead + "서비스는 받았다 게시글의 번호");
		return boardRead;
	}
	
	
	
	/* 삭제 */
	public void deleteBoard(int no) {
		//컨트롤러가 준 no를 다오한테 넘겨주고 다오의 게시글 삭제 메소드 발동!
		boardDao.deleteBoard(no);
	}
	/* 글 작성 */
	public int exeBoardWrite(BoardVo boardVo) {
		System.out.println("BoardService.exeBoardWrite.exeBoardWrite()");
		
		int count = boardDao.insertBoard(boardVo);
		
		return count;
	}

	/* 글 수정폼 */
	public BoardVo exeModifyForm(int no) {
		//다오 호출해서 게시글 정보 가져와
		return boardDao.getModifyForm(no);
	}
}
