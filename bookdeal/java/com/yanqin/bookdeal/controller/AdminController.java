package com.yanqin.bookdeal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 * @create 2021-04-03
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		request.setAttribute("now",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return "admin/index";
	}

	@RequestMapping("/bookCategory")
	public String bookCategory(){
		return "admin/bookCategory";
	}

	@RequestMapping("/bookCategoryAdd")
	public String bookCategoryAdd(){
		return "admin/bookCategoryAdd";
	}


	@RequestMapping("/book")
	public String book(){
		return "admin/book";
	}

	@RequestMapping("/bookAdd")
	public String bookAdd(){
		return "admin/bookAdd";
	}


	@RequestMapping("/user")
	public String user(){
		return "admin/user";
	}

	@RequestMapping("/userAdd")
	public String userAdd(){
		return "admin/userAdd";
	}

	@RequestMapping("/order")
	public String order(){
		return "admin/order";
	}
}
