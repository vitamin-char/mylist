package com.mylist.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mylist.service.BoardService;
import com.mylist.vo.BoardVO;


@Controller
public class BoardController {
	
	@RequestMapping(value = "/board/write")
	public String boardWrite() {
		return "board/boardWrite";
	}
	
}
