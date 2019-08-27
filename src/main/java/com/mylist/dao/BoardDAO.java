package com.mylist.dao;

import java.util.Map;

import com.mylist.vo.BoardVO;

public interface BoardDAO {

	void boardInsert(BoardVO board) throws Exception;

	void tagInsert(Map<String, Object> map) throws Exception;

	void musicInsert(Map<String, Object> map) throws Exception;

}
