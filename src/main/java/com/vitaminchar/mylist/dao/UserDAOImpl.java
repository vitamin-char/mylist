package com.vitaminchar.mylist.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vitaminchar.mylist.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<UserVO> memberList() throws Exception {
		return sqlSession.selectList("user.userList");
	}

}
