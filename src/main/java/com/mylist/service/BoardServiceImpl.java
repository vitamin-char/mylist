package com.mylist.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.mylist.dao.BoardDAO;
import com.mylist.vo.BoardVO;
import com.mylist.vo.UserVO;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> boardList(String keyword, HttpSession session) throws Exception {
		UserVO user = (UserVO) session.getAttribute("login");
		List<BoardVO> boardList = null;
		
		if(keyword == "" || keyword == null) {
			boardList = boardDAO.boardList(keyword);
		}
		else if(keyword.charAt(0)=='#') {
			boardList = boardDAO.searchTag(keyword);
		}
		else {
			boardList = boardDAO.search(keyword);
		}
		
		if(user == null) {
			return boardList;
		}
		
		BoardVO board;
		Map<String,Object> map;
		
		
		for(int i=0; i<boardList.size(); i++) {
			board = boardList.get(i);
			
			map = new HashMap<String,Object>();
			map.put("userId", user.getUserId());
			map.put("boardId", board.getBoardId());
			
			int plag= boardDAO.checkLike(map);
			board.setLike_plag(plag);
		}
		
		return boardList;
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
		
		
		for(int i=0; i<board.getMusic().size(); i++) {
			board.getMusic().get(i).setBoardId(board.getBoardId());
			boardDAO.musicInsert(board.getMusic().get(i));
			
		}
	}
	
	@Override
	public int like(String boardId, HttpSession session) throws Exception {
		UserVO user = (UserVO) session.getAttribute("login");
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", user.getUserId());
		map.put("boardId", boardId);
		
		boardDAO.like(map);
		boardDAO.updateLike(boardId);
		
		return boardDAO.selectCnt(boardId);
	}

	@Override
	public int dislike(String boardId, HttpSession session) throws Exception {
		UserVO user = (UserVO) session.getAttribute("login");
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", user.getUserId());
		map.put("boardId", boardId);
		
		boardDAO.dislike(map);
		
		boardDAO.updateLike(boardId);
		
		return boardDAO.selectCnt(boardId);
	}

	@Override
	public List<BoardVO> writeList(String userId,HttpSession session) throws Exception {
		UserVO user = (UserVO) session.getAttribute("login");
		List<BoardVO> boardList = boardDAO.writeList(userId);
		if(user == null) {
			return boardList;
		}
		
		BoardVO board;
		Map<String,Object> map;
		
		for(int i=0; i<boardList.size(); i++) {
			board = boardList.get(i);
			
			map = new HashMap<String,Object>();
			map.put("userId", user.getUserId());
			map.put("boardId", board.getBoardId());
			
			int plag= boardDAO.checkLike(map);
			board.setLike_plag(plag);
		}
		
		return boardList;
	}

	@Override
	public List<BoardVO> likeList(String userId,HttpSession session) throws Exception {
		UserVO user = (UserVO) session.getAttribute("login");
		List<BoardVO> boardList = boardDAO.likeList(userId);
		if(user == null) {
			return boardList;
		}
				
		BoardVO board;
		Map<String,Object> map;
		
		for(int i=0; i<boardList.size(); i++) {
			board = boardList.get(i);
			
			map = new HashMap<String,Object>();
			map.put("userId", user.getUserId());
			map.put("boardId", board.getBoardId());
			
			int plag= boardDAO.checkLike(map);
			board.setLike_plag(plag);
		}
		
		return boardList;
	}

	@Override
	public BoardVO listView(int boardId) throws Exception {
		return boardDAO.listView(boardId);
	}

	@Override
	public void boardUpdate(BoardVO board) throws Exception {
		boardDAO.boardUpdate(board);
		
		Map<String,Object> map;
		
		boardDAO.tagDelete(board.getBoardId());
		boardDAO.musicDelete(board.getBoardId());
		
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
		
		
		for(int i=0; i<board.getMusic().size(); i++) {	
			board.getMusic().get(i).setBoardId(board.getBoardId());
			boardDAO.musicInsert(board.getMusic().get(i));
			
		}
	}

	@Override
	public void boardDelete(int boardId) throws Exception {
		boardDAO.boardDelete(boardId); //DB 외래키 설정 시 제약 조건 추가함
	}

}
