package com.mylist.controller;


import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

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
	@RequestMapping(value = "/join")
	public String userWrite() {
		return "user/joinForm";
	}
	
	@RequestMapping(value = "/userInsert")
	public String insert(@ModelAttribute UserVO vo) throws Exception{
		userService.insertUser(vo);
		return "redirect:/login";
	}
	
	//아이디 중복체크
	@RequestMapping(value = "/checkUserID")
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
	public ModelAndView loginCheck(@ModelAttribute UserVO vo, HttpSession session, 
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		UserVO user = userService.login(vo);
		if(user == null) {
			mav.addObject("msg", "아이디와 비밀번호를 확인해주세요");
			mav.setViewName("/login");
		}else {
			vo = userService.getUser(vo.getUserId());
			session.setAttribute("login", vo);
			
			Cookie cookie = new Cookie("loginCookie", vo.getUserId());
            cookie.setPath("/");
            int amount = 60 * 60 * 24 * 7; //7일 동안 쿠키 유지
            cookie.setMaxAge(amount);
            response.addCookie(cookie);

			mav.setViewName("redirect:/");
		}
         
		return mav;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response ) {
		session.invalidate();
		
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
        loginCookie.setPath("/");
        loginCookie.setMaxAge(0);
        response.addCookie(loginCookie);
        
		return "redirect:/";
	}
	
	@RequestMapping(value = "/userPage")
	public ModelAndView userPage(@RequestParam String userId, 
			@RequestParam(defaultValue="1") String srt, HttpSession session) throws Exception {
		UserVO login = (UserVO) session.getAttribute("login");
		
		ModelAndView mav = new ModelAndView("/user/userPage");
		
		UserVO user = userService.getUser(userId);
		mav.addObject("User",user);
		
		List<BoardVO> writeList = boardService.writeList(userId,login);
		mav.addObject("write_cnt",writeList.size());
		
		List<BoardVO> likeList = boardService.likeList(userId,login);
		mav.addObject("like_cnt",likeList.size());
		
		if(srt.equals("1")) {
			mav.addObject("list",writeList);
		}else {
			mav.addObject("list",likeList);
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/user/edit")
	public ModelAndView userEdit(HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("/user/editForm");
		UserVO user = (UserVO) session.getAttribute("login");
		
		mav.addObject("user",user);
		
		return mav;
	}
	
	@RequestMapping(value = "/user/update")
	public ModelAndView userUpdate(@ModelAttribute UserVO vo, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		userService.userUpdate(vo);
		session.setAttribute("login", vo);
		
		mav.setViewName("redirect:/user/edit");
		
         
		return mav;
	}
	
	@RequestMapping(value = "/user/passWord")
	public String pwEdit() throws Exception {
		return "user/pwForm";
	}
	
	@RequestMapping(value = "/user/pwUpdate")
	public ModelAndView pwUpdate(@RequestParam Map<String, String> map, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("user/pwForm");
		UserVO user = (UserVO) session.getAttribute("login");
		
		if(!map.get("userPw").equals(user.getUserPw())) {
			mav.addObject("msg","현재 비밀번호가 잘못 입력되었습니다.");
			return mav;			
		}
		
		map.put("userId", user.getUserId());
		
		String str = userService.pwUpdate(map);
		mav.addObject("warning",str);
		session.setAttribute("warning", str);
		
		
         
		return mav;
	}
}