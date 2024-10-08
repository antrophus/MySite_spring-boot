package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	/* 회원가입 */
	public int exeJoin(UserVo userVo) {
		int count = userDao.insertUser(userVo);
		System.out.println("가입정보: " + userVo);

		return count;
	}

	/* 로그인 */
	public UserVo exeLogin(UserVo userVo) {

		UserVo authUser = userDao.selectUser(userVo);

		System.out.println("UserService.exeLogin()");
		System.out.println("로그인정보: " + userVo);

		return authUser;
	}

	
	/* 회원정보수정 */
	public UserVo exeModify(UserVo userVo) {

		userDao.updateUser(userVo);

		return userVo;
	}

}