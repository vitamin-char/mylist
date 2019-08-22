package com.vitaminchar.mylist.dao;

import java.util.List;

import com.vitaminchar.mylist.vo.UserVO;

public interface UserDAO {

	List<UserVO> userList() throws Exception;
	
	void insertUser(UserVO vo) throws Exception;

	int selectUserId(String userId) throws Exception;

	UserVO login(UserVO vo) throws Exception;

	

}
