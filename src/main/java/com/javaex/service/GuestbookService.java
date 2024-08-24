package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDao guestbookDao;
	
	
	/* 방명록폼 & 리스트 */
	public List<GuestbookVo> exeGetPersonList() {

		List<GuestbookVo> guestList = guestbookDao.getGuestlist();

		return guestList;
	}
	
	/* 방명록 쓰기 */
	public int exeWriteGuestbook(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.exeWriteGuestbook");
		
		int count = guestbookDao.insertGuestbook(guestbookVo);
		
		return count;
	}

}
