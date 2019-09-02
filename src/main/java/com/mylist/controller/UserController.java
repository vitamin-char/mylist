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
import com.mylist.service.UserService;
import com.mylist.vo.BoardVO;
import com.mylist.vo.UserVO;

@Controller
public class UserController {
	@Inject
	UserService userService;
	@Inject
	BoardService boardService;
	
	//회원가입
	@RequestMapping(value = "/user/write")
	public String userWrite() {
		return "user/joinForm";
	}
	
	@RequestMapping(value = "/user/insert")
	public String insert(@ModelAttribute UserVO vo) throws Exception{
		userService.insertUser(vo);
		return "redirect:/login";
	}
	
	//아이디 중복체크
	@RequestMapping(value = "/user/checkUserID")
	@ResponseBody 
	public int idcheck(@RequestBody String userId) throws Exception {
		int check = userService.selectUserId(userId);
		return check;
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/loginCheck")
	public ModelAndView loginCheck(@ModelAttribute UserVO vo, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		UserVO user = userService.login(vo);
		if(user == null) {
			session.setAttribute("login", vo);
			
			mav.addObject("msg", "아이디와 비밀번호를 확인해주세요");
			mav.setViewName("/login");
		}else {
			session.setAttribute("login", vo); 
			mav.setViewName("redirect:/");
		}
         
		return mav;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "/userPage")
	public ModelAndView userPage(@RequestParam String userId, 
			@RequestParam(defaultValue="1") String srt, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("/user/userPage");
		
		UserVO user = userService.getUser(userId);
		mav.addObject("User",user);
		
		List<BoardVO> writeList = boardService.writeList(userId);
		mav.addObject("write_cnt",writeList.size());
		
		List<BoardVO> likeList = boardService.likeList(userId);
		mav.addObject("like_cnt",likeList.size());
		
		if(srt.equals("1")) {
			mav.addObject("list",writeList);
		}else {
			mav.addObject("list",likeList);
		}
		
		return mav;
	}

}