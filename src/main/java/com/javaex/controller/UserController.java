package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	//필드
	@Autowired
	private UserService userService;
	
	//생성자
	
	//메소드 -gs
	
	//메소드 일반
	/* 회원가입폼 */
	@RequestMapping(value = "/user/joinform", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinform() {

		System.out.println("joinform 실행: 폼만 보여주기");

		return "user/joinForm";
	}

	/* 회원가입 */
	@RequestMapping(value = "/user/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(@ModelAttribute UserVo uservo) {

		System.out.println("join 실행: 회원 가입 실행");

		userService.exeJoin(uservo);

		return "user/joinOk";
	}

	/* 로그인폼 */
	@RequestMapping(value = "/user/loginform", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginform() {
		
		return "user/loginForm";
	}

	/* 로그인 */
	@RequestMapping(value = "/user/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.login()");
		
		UserVo authUser = userService.exeLogin(userVo);
		System.out.println("세션에서 'no'와 '이름'을 잘 가져왔나" + authUser);
		
		//로그인
		session.setAttribute("authUser", authUser);
		System.out.println(authUser + "이것은 로그인한 회원의 세션정보");
		
		//메인페이지로 리다이렉트
		return "redirect:/main";
	}

	/* 로그아웃 */
	@RequestMapping(value = "/user/logout", method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("UserController.logout()");
		
//		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/main";
	}

	/* 회원정보수정폼 */
	@RequestMapping(value = "/user/modifyform", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyform(HttpSession session, Model model) {
	    System.out.println("UserController.modifyform()");
	    
	    //세션에서 로그인된 사용자 정보 가져와서 authUser에 담음
	    UserVo authUser = (UserVo) session.getAttribute("authUser");
	    
	    if (authUser == null) {
	        return "redirect:/user/login"; // 로그인하지 않은 경우 로그인 페이지로 리다이렉트
	    }
	    // authUser 정보를 model에 추가해서 뷰에서 사용할 수 있게 함
	    model.addAttribute("userVo", authUser);
	    System.out.println("잘 담겼나 확인" + authUser);
	    System.out.println("-----여기 까지는 수정폼-----");
	    
	    return "user/modifyForm";
	}

	/* 회원정보수정 */
	@RequestMapping(value = "/user/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.modify()");
		
		//로그인된 회원 정보를 session에서 가져오기
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		//이름을 가져와서 메인 화면에 출력
//		authUser.setName(userVo.getName());

		//authUser의 ID를 유지하고 수정된 정보를 적용
		userVo.setId(authUser.getId());
		userService.exeModify(userVo);
//		
		//세션의 사용자 정보 수정 내용 업데이트
		session.setAttribute("authUser", userVo);
		
		return "redirect:/main";
	}
}