package com.mylist.dao;

import java.util.List;
import java.util.Map;

import com.mylist.vo.BoardVO;
import com.mylist.vo.MusicVO;

public interface BoardDAO {
	
	List<BoardVO> boardList() throws Exception;

	void boardInsert(BoardVO board) throws Exception;

	void tagInsert(Map<String, Object> map) throws Exception;

	void musicInsert(MusicVO musicVO) throws Exception;
	
	int checkLike(Map<String, Object> map) throws Exception;

	void dislike(Map<String, Object> map) throws Exception;
	
	void like(Map<String, Object> map) throws Exception;

	void updateLike(String boardId) throws Exception;

	int selectCnt(String boardId) throws Exception;

	List<BoardVO> writeList(String userId) throws Exception;

	List<BoardVO> likeList(String userId) throws Exception;

	BoardVO listView(int boardId) throws Exception;

	void boardUpdate(BoardVO board) throws Exception;

	void tagDelete(int boardId) throws Exception;

	void musicDelete(int boardId) throws Exception;

}
