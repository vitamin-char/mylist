package com.mylist.service;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	@Override
	public void userUpdate(UserVO vo) throws Exception{
		userDao.userUpdate(vo);
		
	}

	@Override
	public String pwUpdate(Map<String, String> map) throws Exception {		
		String reg = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[~`!@#$%\\^&*()-]).{8,20}$";
		Pattern p = Pattern.compile(reg);
		Matcher matcher = p.matcher(map.get("newPw"));
		 if(matcher.find()){
			 if(map.get("newPw").equals(map.get("rePw"))){
				 userDao.pwUpdate(map);
				 return "";
			 }
			 return "두 비밀번호가 일치하지 않습니다.";
			 
		 }
		return "패스워드는 8~20자의 영문 대소문자와 숫자, 특수문자를 혼합하여 입력하세요.";
	}

}
