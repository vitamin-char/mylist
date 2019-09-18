package com.mylist.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mylist.service.BoardService;
import com.mylist.vo.BoardVO;
import com.mylist.vo.UserVO;


@Controller
public class BoardController {
	@Inject
	BoardService boardService;
	
	//메인
	@RequestMapping(value = "/")
	public ModelAndView  home(@RequestParam(value="keyword", defaultValue="") String keyword,
			@RequestParam(value="order", defaultValue="new") String order, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("/home");
		
		UserVO user = (UserVO) session.getAttribute("login");
		List<BoardVO> list = boardService.boardList(keyword, order, user);
		
		mav.addObject("list",list);
		mav.addObject("keyword",keyword);
		return mav;
	}
	
	//리스트 상세보기
	@RequestMapping(value = "/listView")
	@ResponseBody
	public BoardVO  listView(@RequestBody int boardId) throws Exception {
		BoardVO board = boardService.listView(boardId);
		return board;
	}
	
	//리스트 입력 폼
	@RequestMapping(value = "/board/write")
	public String boardWrite() {
		return "board/boardWrite";
	}
	
	//리스트 입력
	@RequestMapping(value = "/board/insert")
	public String boardInsert(@ModelAttribute BoardVO board, HttpSession session) throws Exception {
		UserVO user = (UserVO) session.getAttribute("login");
		
		board.setUserId(user.getUserId());
		
		boardService.boardInsert(board);

		return "redirect:/";
	}
	
	//좋아요
	@RequestMapping(value = "/board/like")
	@ResponseBody 
	public int like(@RequestBody String boardId, HttpSession session) throws Exception {
		UserVO user = (UserVO) session.getAttribute("login");
		int check = boardService.like(boardId,user);
		return check;
	}
	
	//좋아요 취소
	@RequestMapping(value = "/board/dislike")
	@ResponseBody 
	public int dislike(@RequestBody String boardId, HttpSession session) throws Exception {
		UserVO user = (UserVO) session.getAttribute("login");
		int check = boardService.dislike(boardId,user);
		return check;
	}
	
	
	@RequestMapping(value = "/board/edit")
	public ModelAndView boardEdit(@RequestParam int boardId) throws Exception {
		ModelAndView mav = new ModelAndView("/board/edit");

		BoardVO board = boardService.listView(boardId);
		
		mav.addObject("board",board);
		return mav;
	}
	@RequestMapping(value = "/board/update")
	public String boardUpdate(@ModelAttribute BoardVO board) throws Exception {
		boardService.boardUpdate(board);

		return "redirect:/";
	}
	
	@RequestMapping(value = "/board/delete")
	public String boardDelete(@RequestParam int boardId) throws Exception {
		boardService.boardDelete(boardId);

		return "redirect:/";
	}
}
