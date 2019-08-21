package com.vitaminchar.mylist.service;

import java.util.List;

import com.vitaminchar.mylist.vo.UserVO;

public interface UserService {

	List<UserVO> userList() throws Exception;

	void insertUser(UserVO vo) throws Exception;

	int selectUserId(String userId) throws Exception;

}
