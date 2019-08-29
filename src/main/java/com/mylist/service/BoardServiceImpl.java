package com.mylist.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mylist.dao.BoardDAO;
import com.mylist.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> boardList() throws Exception {
		return boardDAO.boardList();
	}

	@Override
	public void boardInsert(BoardVO board) throws Exception {
		boardDAO.boardInsert(board);
		
		Map<String,Object> map;
		
		//해시태그 구분
		String str = board.getDescription();
		String regExp = "\\#([0-9a-zA-Z가-힣]*)";
		Pattern compiledPattern = Pattern.compile(regExp, Pattern.CASE_INSENSITIVE);
		Matcher matcher = compiledPattern.matcher(str);
		while (matcher.find()) {
			map = new HashMap<String,Object>();
			map.put("boardId", board.getBoardId());
			map.put("tag_name", matcher.group());
			boardDAO.tagInsert(map);
		}
		
		
		for(int i=0; i<board.getMusic_title().length; i++) {
			map = new HashMap<String,Object>();
			map.put("boardId", board.getBoardId());
			map.put("music_title", board.getMusic_title()[i]);
			map.put("music_singer", board.getMusic_singer()[i]);
			boardDAO.musicInsert(map);
			
		}
	}

	

}
