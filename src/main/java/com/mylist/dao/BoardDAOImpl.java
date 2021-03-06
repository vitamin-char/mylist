package com.mylist.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mylist.vo.BoardVO;
import com.mylist.vo.MusicVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Inject
	SqlSession sqlSession;

	@Override
	public List<BoardVO> boardList(Map<String, Object> option) throws Exception {
		return  sqlSession.selectList("board.boardList",option);
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
	public void musicInsert(MusicVO musicVO) throws Exception {
		sqlSession.insert("board.musicInsert",musicVO);
		
	}
	
	@Override
	public int checkLike(Map<String, Object> map) throws Exception {
		return sqlSession.selectOne("board.checkLike", map);
	}
	
	@Override
	public void like(Map<String, Object> map) throws Exception {
		sqlSession.insert("board.like",map);
	}
	
	@Override
	public void dislike(Map<String, Object> map) throws Exception {
		sqlSession.delete("board.dislike",map);
	}
	
	@Override
	public void updateLike(String boardId) throws Exception {
		sqlSession.update("board.updateLike",boardId);
	}

	@Override
	public int selectCnt(String boardId) throws Exception {
		return sqlSession.selectOne("board.selectCnt",boardId);
	}

	@Override
	public List<BoardVO> writeList(String userId) throws Exception {
		return  sqlSession.selectList("board.writeList",userId);
	}

	@Override
	public List<BoardVO> likeList(String userId) throws Exception {
		return  sqlSession.selectList("board.likeList",userId);
	}

	@Override
	public BoardVO listView(int boardId) throws Exception {
		return sqlSession.selectOne("board.listView", boardId);
	}

	@Override
	public void boardUpdate(BoardVO board) throws Exception {
		sqlSession.update("board.boardUpdate", board);
	}

	@Override
	public void tagDelete(int boardId) throws Exception {
		sqlSession.delete("board.tagDelete", boardId);
	}

	@Override
	public void musicDelete(int boardId) throws Exception {
		sqlSession.delete("board.musicDelete", boardId);
	}

	@Override
	public void boardDelete(int boardId) throws Exception {
		sqlSession.delete("board.boardDelete", boardId);
	}

	@Override
	public List<BoardVO> searchTag(Map<String, Object> option) throws Exception {
		return  sqlSession.selectList("board.searchTag",option);
	}

	@Override
	public List<BoardVO> search(Map<String, Object> option) throws Exception {
		return  sqlSession.selectList("board.search",option);
	}

}
