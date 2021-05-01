package com.yanqin.bookdeal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 * @create 2021-04-03
 **/
@RequestMapping("/page")
@Controller
public class PageController {

	@RequestMapping("/index")
	public String index(){
		return "index";
	}

	@RequestMapping("/login")
	public String login(){
		return "login";
	}

	@RequestMapping("/adminlogin")
	public String adminlogin(){
		return "adminlogin";
	}

	@RequestMapping("/register")
	public String register(){
		return "register";
	}


}
