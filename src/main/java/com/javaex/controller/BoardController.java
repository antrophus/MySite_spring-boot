package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	/* 리스트 */
	@RequestMapping(value = "/board/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("BoardController.list()");
		
		List<BoardVo>boardList = boardService.exeGetBoardList();
		model.addAttribute("boardList", boardList);

		return "board/list";
	}
	
}
