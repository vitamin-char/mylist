package com.vitaminchar.mylist.service;

import java.util.List;

import com.vitaminchar.mylist.vo.UserVO;

public interface UserService {

	List<UserVO> memberList() throws Exception;

}
