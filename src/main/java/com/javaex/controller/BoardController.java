package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;



@Controller
public class BoardController {
	
	//필드
	@Autowired
	private BoardService boardService;
	//생성자
	
	//메소드 -gs
	
	//메소드 일반
	/* 리스트 */ //- 조회수는 카운트+
	@RequestMapping(value = "/board/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("BoardController.list()");
		
		List<BoardVo>boardList = boardService.exeGetBoardList();
		model.addAttribute("boardList", boardList);
		return "board/list";
	}
	
	/* 게시글 읽기 */
	@RequestMapping(value = "/board/read", method = { RequestMethod.GET, RequestMethod.POST })
	public String read(@RequestParam(value = "no") int no, Model model) {
		System.out.println("BoardController.read");
		
		BoardVo boardRead = boardService.exeBoardRead(no);
		model.addAttribute("boardVo", boardRead);
		
		return "board/read";
	
	}
	
	/* 삭제 */
	@RequestMapping(value = "/board/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteBoard(@RequestParam(value = "no") int no) {
		//파라미터에 뜬 no(로그인 한 사용자만 자신의 게시글을 지울 수 있음
		//jsp에 세션정보 있는 유저만 볼 수 있게 설정)를 서비스에게 넘기고 턴을 종료!
		boardService.deleteBoard(no);
		System.out.println(no+" 삭제 ");
		//삭제 시퀀스 발동 후 게시글 리스트로 리다이렉트!
		return "redirect:/board/list";
		
	}
	
	/* 게시글 쓰기 */
	@RequestMapping(value = "/board/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("BoardController.writeForm");

		return "board/writeForm";
	}
	
	
}
