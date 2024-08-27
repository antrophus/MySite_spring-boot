package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {

	//필드
	@Autowired
	private GuestbookService guestbookService;
	
	//생성자
	
	//메소드 -gs
	
	//메소드 일반
	/* 방명록폼 & 리스트 */
	@RequestMapping(value = "/guestbook/addlist", method = { RequestMethod.GET, RequestMethod.POST })
	public String guestbook(Model model) {
		
		System.out.println("GuestbookController.guestbook()");
		
		List<GuestbookVo> guestList = guestbookService.exeGetPersonList();

		model.addAttribute("guestList", guestList);
		
		return "guestbook/addList";
	}
	
	/* 방명록 쓰기 */
	@RequestMapping(value = "/guestbook/insert", method = { RequestMethod.GET, RequestMethod.POST })
	public String insert(@ModelAttribute GuestbookVo guestbookVo) {
		
		System.out.println("GuestbookController.insert()");
		
		guestbookService.exeWriteGuestbook(guestbookVo);
		
		return "redirect:/guestbook/addlist";
	}
	/* 삭제폼 이동 */
	@RequestMapping(value = "guestbook/deleteform", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteform() {
		
		System.out.println("GuestbookController.deleteform()");
//		삭제폼만 불러올거임. 파라미터의 no는 jsp에서 ${param.no}로 추출하면 됨.

		return "guestbook/deleteForm";
	}

	/* 삭제 */
	@RequestMapping(value = "guestbook/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam(value = "no") int no, @RequestParam(value = "password") String password) {
		
		boolean success = guestbookService.exeGuestbookDelete(no, password);
		
		System.out.println(success+ "삭제 컨트롤러 발동");
		
		if (success) {
			
			return "redirect:/guestbook/addlist";
			
		} else {
			
			return "redirect:/guestbook/deleteform?no=" + no + "&error=true";
			
		}
	}
}
