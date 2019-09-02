package com.mylist.service;

import com.mylist.vo.UserVO;

public interface UserService {

	void insertUser(UserVO vo) throws Exception;

	int selectUserId(String userId) throws Exception;

	UserVO login(UserVO vo) throws Exception;

	UserVO getUser(String userId) throws Exception;

}
