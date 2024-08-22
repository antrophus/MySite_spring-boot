package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public int exeInsert(UserVo userVo) {
		int count = userDao.insertUser(userVo);
		System.out.println("가입정보: " + userVo);

		return count;
	}

}