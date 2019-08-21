package com.vitaminchar.mylist.dao;

import java.util.List;

import com.vitaminchar.mylist.vo.UserVO;

public interface UserDAO {

	List<UserVO> memberList() throws Exception;

}
