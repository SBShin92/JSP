package myhome.dao;

import java.util.List;

import myhome.vo.UserVO;

public interface UsersDAO {
	public List<UserVO> getList();
	public UserVO get(Long userNo);
	public boolean insert(UserVO vo);
	public boolean update(UserVO vo);
	public boolean delete(UserVO vo);
	public UserVO getUserIdAndPassword(Long userNo, String inputPassword);
}
