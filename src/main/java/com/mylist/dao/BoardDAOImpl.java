package com.mylist.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mylist.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<BoardVO> boardList() throws Exception {
		return  sqlSession.selectList("board.boardList");
	}
	
	@Override
	public void boardInsert(BoardVO board) throws Exception {
		sqlSession.insert("board.boardInsert",board);
	}

	@Override
	public void tagInsert(Map<String, Object> map) throws Exception {
		sqlSession.insert("board.tagInsert",map);
	}

	@Override
	public void musicInsert(Map<String, Object> map) throws Exception {
		sqlSession.insert("board.musicInsert",map);
		
	}


}
