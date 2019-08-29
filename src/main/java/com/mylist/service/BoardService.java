package com.mylist.service;

import java.util.List;

import com.mylist.vo.BoardVO;

public interface BoardService {
	
	List<BoardVO> boardList() throws Exception;

	void boardInsert(BoardVO board) throws Exception;

	

}
