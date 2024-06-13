package myhome.dao;

import java.util.List;

import myhome.vo.GuestBookVO;

public interface GuestBookDAO {

	List<GuestBookVO> getList();
	GuestBookVO get(Long no);
	boolean insert(GuestBookVO vo);
	boolean delete(GuestBookVO vo);
}
