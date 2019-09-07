package com.mylist.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mylist.vo.BoardVO;

public interface BoardService {
	
	List<BoardVO> boardList(HttpSession session) throws Exception;

	void boardInsert(BoardVO board) throws Exception;
	
	int like(String boardId, HttpSession session) throws Exception;

	int dislike(String boardId, HttpSession session) throws Exception;

	List<BoardVO> writeList(String userId,HttpSession session) throws Exception;

	List<BoardVO> likeList(String userId,HttpSession session) throws Exception;

	BoardVO listView(int boardId) throws Exception;

	void boardUpdate(BoardVO board) throws Exception;

	void boardDelete(int boardId) throws Exception;

}
