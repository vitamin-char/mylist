package com.vitaminchar.mylist.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.vitaminchar.mylist.dao.UserDAO;
import com.vitaminchar.mylist.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	@Inject
	UserDAO userDao;

	@Override
	public List<UserVO> memberList() throws Exception {
		return userDao.memberList();
	}

}
