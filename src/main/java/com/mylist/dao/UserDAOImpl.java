package com.mylist.dao;
	
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mylist.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public void insertUser(UserVO vo) throws Exception {
		sqlSession.insert("user.insertUser",vo);
	}

	@Override
	public int selectUserId(String userId) throws Exception {
		return sqlSession.selectOne("user.selectUserId",userId);
	}

	@Override
	public UserVO login(UserVO vo) throws Exception {
		return sqlSession.selectOne("user.login",vo);
	}

	@Override
	public UserVO getUser(String userId) throws Exception {
		return sqlSession.selectOne("user.getUser",userId);
	}

}
