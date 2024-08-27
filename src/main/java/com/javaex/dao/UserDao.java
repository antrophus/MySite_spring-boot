package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	/* 회원가입 */
	public int insertUser(UserVo userVo) {

		int count = sqlSession.insert("user.insert", userVo);
		System.out.println("UserDao가 회원가입" + count + "건 service로 넘기기");
		return count;

	}

	/* 로그인 */
	public UserVo selectUser(UserVo userVo) {

		UserVo authUser = sqlSession.selectOne("user.selectByIdPw", userVo);
		System.out.println(authUser + "이것은 디비가 다오에게 주는 거");

		return authUser;

	}
	
	
	/*회원 정보 수정하기 */
	 public UserVo updateUser(UserVo userVo) {
	  
	 sqlSession.update("user.updateUser", userVo);
	  
	  return userVo; }
	 

}