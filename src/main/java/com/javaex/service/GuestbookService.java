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
	/* 컨트롤러에서 삭제폼으로 포워딩. 서비스가 다오를 통해 받아올 정보는 필요없음.
	 * public GuestbookVo exeDeleteForm(int no) {
	 * 
	 * GuestbookVo guestbookVo = guestbookDao.getNo(no);
	 * System.out.println(guestbookVo + "서비스 삭제폼 작동 확인"); return guestbookVo; }
	 */

	/* 삭제 */
	public boolean exeGuestbookDelete(int no, String password) {
		// 삭제하려는 항목의 번호와 비밀번호를 사용하여 삭제 쿼리 실행
		int count = guestbookDao.deleteGuestbook(no, password);
		
		System.out.println(count + "삭제 서비스 발동");
		
		return count == 1; // 삭제 성공 시 true 반환
	}

}
