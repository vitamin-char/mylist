package com.mylist.dao;

import java.util.Map;

import com.mylist.vo.UserVO;

public interface UserDAO {
	
	void insertUser(UserVO vo) throws Exception;

	int selectUserId(String userId) throws Exception;

	UserVO login(UserVO vo) throws Exception;

	UserVO getUser(String userId) throws Exception;

	void userUpdate(UserVO vo) throws Exception;

	void pwUpdate(Map<String, String> map) throws Exception;

	

}
