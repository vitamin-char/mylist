package com.mylist.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mylist.vo.BoardVO;

public interface BoardService {
	
	List<BoardVO> boardList(HttpSession session) throws Exception;

	void boardInsert(BoardVO board) throws Exception;
	
	int like(String boardId, HttpSession session) throws Exception;

	int dislike(String boardId, HttpSession session) throws Exception;

	List<BoardVO> writeList(String userId) throws Exception;

	List<BoardVO> likeList(String userId) throws Exception;

}
