package com.yanqin.bookdeal.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.yanqin.bookdeal.common.util.GsonUtils;
import com.yanqin.bookdeal.domain.User;
import com.yanqin.bookdeal.dto.LoginUserDto;
import com.yanqin.bookdeal.dto.UserDto;
import com.yanqin.bookdeal.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

/**
 * @author Administrator
 * @create 2021-04-03
 **/
@RequestMapping("/login")
@RestController
@Slf4j
public class LoginController {

	@Resource
	private UserService userService;

	@PostMapping("/register")
	public R<String> register(@Valid @RequestBody UserDto userdto){
		log.info(GsonUtils.toJson(userdto));
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
		return R.ok(null);
	}

	@PostMapping("/login")
	public R<String> login(@Valid @RequestBody LoginUserDto userdto, HttpSession session){
		LambdaQueryWrapper<User> qw = Wrappers.<User>query()
				.lambda()
				.eq(User::getUserid, userdto.getUserid())
				.eq(User::getPassword, userdto.getPassword());
		User user = userService.getOne(qw);
		if(user == null){
			return R.failed("账号密码错误");
		}else{
			session.setAttribute("user",user);
			return R.ok("登录成功");
		}
	}

	@PostMapping("/adminlogin")
	public R<String> adminlogin(@Valid @RequestBody LoginUserDto userdto,HttpSession session){
		if(userdto.getUserid().equals("admin") && userdto.getPassword().equals("admin")){
			User user = new User();
			user.setUserid("admin");
			session.setAttribute("user",user);
			return R.ok("登录成功");
		}else{
			return R.failed("账号密码错误");
		}
	}
}
