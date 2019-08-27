package com.mylist.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mylist.service.BoardService;
import com.mylist.vo.BoardVO;
import com.mylist.vo.UserVO;


@Controller
public class BoardController {
	@Inject
	BoardService boardService;
	
	@RequestMapping(value = "/board/write")
	public String boardWrite() {
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "/board/insert")
	public String boardInsert(@ModelAttribute BoardVO board, HttpSession session) throws Exception {
		UserVO user = (UserVO) session.getAttribute("login");
		
		board.setUserId(user.getUserId());
		
		boardService.boardInsert(board);

		return "redirect:/";
	}
	
}
