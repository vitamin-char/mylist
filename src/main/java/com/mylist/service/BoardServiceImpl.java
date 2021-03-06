package com.mylist.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mylist.dao.BoardDAO;
import com.mylist.vo.BoardVO;
import com.mylist.vo.UserVO;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	BoardDAO boardDAO;
	
	@Inject
	TagService tagService;
	
	@Override
	public List<BoardVO> boardList(String keyword, String order, UserVO user) throws Exception {
		List<BoardVO> boardList = null;
		Map<String,Object> option = new HashMap<String,Object>();
		option.put("keyword", keyword);
		option.put("order", order);
		
		if(keyword.equals("") || keyword == null) {
			boardList = boardDAO.boardList(option);
		}
		else if(keyword.charAt(0)=='#') {
			boardList = boardDAO.searchTag(option);
		}
		else {
			boardList = boardDAO.search(option);
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
		
		String str = tagService.toTag(board.getDescription());
		board.setDescription(str);
		boardDAO.boardInsert(board);
		
		tagService.inserTag(board.getDescription(), board.getBoardId());
		
		for(int i=0; i<board.getMusic().size(); i++) {
			board.getMusic().get(i).setBoardId(board.getBoardId());
			boardDAO.musicInsert(board.getMusic().get(i));
		}
	}
	
	@Override
	public int like(String boardId, UserVO user) throws Exception {		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", user.getUserId());
		map.put("boardId", boardId);
		
		boardDAO.like(map);
		boardDAO.updateLike(boardId);
		
		return boardDAO.selectCnt(boardId);
	}

	@Override
	public int dislike(String boardId, UserVO user) throws Exception {		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", user.getUserId());
		map.put("boardId", boardId);
		
		boardDAO.dislike(map);
		
		boardDAO.updateLike(boardId);
		
		return boardDAO.selectCnt(boardId);
	}

	@Override
	public List<BoardVO> writeList(String userId, UserVO user) throws Exception {
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
	public List<BoardVO> likeList(String userId, UserVO user) throws Exception {
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
		board.setDescription(tagService.toTag(board.getDescription()));
		boardDAO.boardUpdate(board);
		
		boardDAO.tagDelete(board.getBoardId());
		boardDAO.musicDelete(board.getBoardId());
		
		tagService.inserTag(board.getDescription(), board.getBoardId());
		
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
