package com.mylist.service;

import java.util.List;

import com.mylist.vo.BoardVO;
import com.mylist.vo.UserVO;

public interface BoardService {
	
	List<BoardVO> boardList(String keyword, String order, UserVO user) throws Exception;

	void boardInsert(BoardVO board) throws Exception;
	
	int like(String boardId, UserVO user) throws Exception;

	int dislike(String boardId, UserVO user) throws Exception;

	List<BoardVO> writeList(String userId, UserVO user) throws Exception;

	List<BoardVO> likeList(String userId, UserVO user) throws Exception;

	BoardVO listView(int boardId) throws Exception;

	void boardUpdate(BoardVO board) throws Exception;

	void boardDelete(int boardId) throws Exception;

}
