package com.vitaminchar.mylist;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vitaminchar.mylist.service.UserService;
import com.vitaminchar.mylist.vo.UserVO;

@Controller
public class UserController {
	@Inject
	UserService userService;
	
	@RequestMapping("/user/list")
	public String userList(Model model) throws Exception {
		List<UserVO> list = userService.userList();
		model.addAttribute("list", list);
		return "user/user_list";
	}
	
	//회원가입
	@RequestMapping(value = "/user/write")
	public String userWrite() {
		return "user/write";
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
			mav.addObject("msg", "아이디와 비밀번호를 확인해주세요");
			mav.setViewName("/login");
		}else {
			session.setAttribute("login", vo); 
			mav.setViewName("/home");
		}
         
		return mav;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}