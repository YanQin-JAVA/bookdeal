package com.yanqin.bookdeal.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Administrator
 * @create 2021-04-03
 **/
@Data
public class LoginUserDto {
	@NotBlank(message = "用户不能为空")
	private String userid;
	@NotBlank(message = "密码不能为空")
	private String password;
}
