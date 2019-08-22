package com.vitaminchar.mylist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	

	//메인
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	

	
}
