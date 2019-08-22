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
	public List<UserVO> userList() throws Exception {
		return userDao.userList();
	}

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

}
