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

	

}
