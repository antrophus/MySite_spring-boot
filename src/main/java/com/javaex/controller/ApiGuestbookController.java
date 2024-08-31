package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class ApiGuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	//방명록 읽기(전체 리스트 가져오기)
	@ResponseBody //return에 있는 데이터를 json으로 바꿔서 응답 문서의 body에 넣어줘
	@RequestMapping(value ="/api/guestbook/list")
	public List<GuestbookVo> list() { // 자료형은 항상 String은 아니다. 확인※
		System.out.println("ApiGuestbookController.list()");
		
		List<GuestbookVo> guestList = guestbookService.exeGetPersonList();
		System.out.println(guestList + "이건 자료형");
		
		return guestList;
	}
	
	//방명록 쓰기(등록)
	@ResponseBody
	@RequestMapping(value ="/api/guestbook/write", method = {RequestMethod.GET, RequestMethod.POST} )
	public String write(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("ApiGuestbookController.write()");
		
		System.out.println(guestbookVo);
		
		guestbookService.exeWriteGuestbook(guestbookVo);
		
		return "/api/guestbook/list";
	}

}
