package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

import jakarta.servlet.http.HttpSession;



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
		/*파라미터에 뜬 no(로그인 한 사용자만 자신의 게시글을 지울 수 있음
		  jsp에 세션정보 있는 유저만 볼 수 있게 설정)를 서비스에게 넘기고 턴을 종료!*/
		boardService.deleteBoard(no);
		System.out.println(no + " 삭제 ");
		//삭제 시퀀스 발동 후 게시글 리스트로 리다이렉트!
		return "redirect:/board/list";
	}
	
	/* 게시글 작성폼 */
	@RequestMapping(value = "/board/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("BoardController.writeForm");

		return "board/writeForm";
	}
	
	/* 게시글 작성 */
	@RequestMapping(value = "/board/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@RequestParam(value = "no") int no, @ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController.write" + no + " 번 회원이 글작성을 누름");
		
		boardService.exeBoardWrite(boardVo);
		
		return "redirect:/board/list";
	}
	
	/* 게시글 수정폼 */
	@RequestMapping(value = "/board/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam(value = "no") int no, Model model, HttpSession session) {
		System.out.println("BoardController.modifyForm()");
		//다오가 주고 서비스가 받아온 게시글 정보를 담아.
		BoardVo boardVo = boardService.exeModifyForm(no);
		System.out.println("컨트롤러 수정폼 제목 확인: " + boardVo.getTitle());
		//담은 게시글 정보를 어트리뷰트에 담아서 화면에 뿌려.
		model.addAttribute("boardVo", boardVo);
		//포워딩해.
		return "board/modifyForm";
	}
	
	/* 게시글 수정 */
	@RequestMapping(value ="/board/modify", method = {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute BoardVo boardVo) {
		System.out.println("수정 잘 되나 확인좀 : BoardController.modify()");
		System.out.println("수정할 게시글 번호: " + boardVo.getNo());
		System.out.println("수정된 제목: " + boardVo.getTitle());
		System.out.println("수정된 내용: " + boardVo.getContent());
		boardService.exeModifyBoard(boardVo);
		
		return "redirect:/board/list";
	}
	
}
