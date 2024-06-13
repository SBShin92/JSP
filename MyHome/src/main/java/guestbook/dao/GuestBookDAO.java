package guestbook.dao;

import java.util.List;

import guestbook.vo.GuestBookVO;

public interface GuestBookDAO {

	List<GuestBookVO> getList();
	GuestBookVO get(Long no);
	boolean insert(GuestBookVO vo);
	boolean delete(GuestBookVO vo);
}
