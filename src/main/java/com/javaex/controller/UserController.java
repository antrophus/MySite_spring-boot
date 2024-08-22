package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// 회원가입폼
	@RequestMapping(value = "user/joinform", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinform() {

		System.out.println("joinform 실행: 폼만 보여주기");

		return "user/joinForm";
	}
	// 회원가입
	@RequestMapping(value = "user/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(@ModelAttribute UserVo uservo) {

		System.out.println("join 실행: 진짜 가입은 여기서");

		userService.exeInsert(uservo);

		return "user/joinOk";
	}

}