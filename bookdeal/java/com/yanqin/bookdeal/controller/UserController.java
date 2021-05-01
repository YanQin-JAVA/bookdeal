package com.yanqin.bookdeal.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.yanqin.bookdeal.domain.BookCategory;
import com.yanqin.bookdeal.domain.User;
import com.yanqin.bookdeal.dto.UserDto;
import com.yanqin.bookdeal.service.BookCategoryService;
import com.yanqin.bookdeal.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @create 2021-04-03
 **/
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("/book")
	public String book(){
		return "book";
	}

	@RequestMapping("/bookdetail")
	public String bookdetail(Integer id, HttpServletRequest request){
		request.setAttribute("id",id);
		return "bookdetail";
	}

	@RequestMapping("/order")
	public String order(){
		return "order";
	}

	@RequestMapping("/add")
	@ResponseBody
	public R<String> add(@RequestBody @Valid UserDto userdto){
		if(!userdto.getPassword().equals(userdto.getPassword2())){
			return R.failed("密码和确认密码不一致");
		}

		User user = new User();
		Date date = new Date();
		user.setCreateDate(date);
		user.setUpdateDate(date);
		user.setUserid(userdto.getUserid());
		user.setUsername(userdto.getUsername());
		user.setPassword(userdto.getPassword());
		user.setAddress(userdto.getAddress());
		user.setMobile(userdto.getMobile());
		userService.save(user);
		return R.ok("保存成功");
	}

	@RequestMapping("/list")
	@ResponseBody
	public R<List<User>> list(){
		List<User> list = userService.list();
		return R.ok(list);
	}

}
