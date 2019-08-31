package com.mylist.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mylist.dao.UserDAO;
import com.mylist.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	@Inject
	UserDAO userDao;

	@Override
	public void insertUser(UserVO vo) throws Exception {
		userDao.insertUser(vo);
	}

	@Override
	public int selectUserId(String userId) throws Exception {
		return userDao.selectUserId(userId);
	}

	@Override
	public UserVO login(UserVO vo) throws Exception {
		return userDao.login(vo);
	}

	@Override
	public UserVO getUser(String userId) throws Exception {
		return userDao.getUser(userId);
	}

}
