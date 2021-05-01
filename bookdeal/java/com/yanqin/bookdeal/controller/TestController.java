package com.yanqin.bookdeal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 * @create 2021-04-03
 **/
@RequestMapping("/test")
@Controller
public class TestController {

	@GetMapping("/s")
	@ResponseBody
	public String s(){
		return "s";
	}
	@GetMapping("/jsp")
	public String jsp(){
		return "test";
	}
}
