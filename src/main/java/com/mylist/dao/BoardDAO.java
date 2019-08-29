package com.mylist.dao;

import java.util.List;
import java.util.Map;

import com.mylist.vo.BoardVO;

public interface BoardDAO {
	
	List<BoardVO> boardList() throws Exception;

	void boardInsert(BoardVO board) throws Exception;

	void tagInsert(Map<String, Object> map) throws Exception;

	void musicInsert(Map<String, Object> map) throws Exception;

	

}
