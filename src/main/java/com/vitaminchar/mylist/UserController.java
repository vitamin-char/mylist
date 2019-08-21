package com.vitaminchar.mylist;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vitaminchar.mylist.service.UserService;
import com.vitaminchar.mylist.vo.UserVO;

@Controller
public class UserController {
	@Inject
	UserService userService;
	
	@RequestMapping("user/list")
	public String userList(Model model) throws Exception {
		List<UserVO> list = userService.memberList();
		model.addAttribute("list", list);
		return "user/user_list";
	}

}
