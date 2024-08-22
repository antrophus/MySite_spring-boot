package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	public int insertUser(UserVo userVo) {

		int count = sqlSession.insert("user.insert", userVo);
		System.out.println(count + "건 등록");
		return count;

	}

}