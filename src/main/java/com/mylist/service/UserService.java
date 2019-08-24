package com.mylist.service;

import java.util.List;

import com.mylist.vo.UserVO;

public interface UserService {

	List<UserVO> userList() throws Exception;

	void insertUser(UserVO vo) throws Exception;

	int selectUserId(String userId) throws Exception;

	UserVO login(UserVO vo) throws Exception;

}