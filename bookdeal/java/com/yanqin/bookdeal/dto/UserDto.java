package com.yanqin.bookdeal.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Administrator
 * @create 2021-04-03
 **/
@Data
public class UserDto {
	@NotBlank(message = "用户名不能为空")
	@Size(min=5,max=20,message = "用户名的长度需要在5~20之间")
	private String userid;

	@NotBlank(message = "姓名不能为空")
	@Size(min=2,max=20,message = "姓名的长度需要在5~20之间")
	private String username;

	@NotBlank(message = "收货地址不能为空")
	@Size(min=5,max=50,message = "收货地址的长度需要在5~50之间")
	private String address;

	@NotBlank(message = "手机号不能为空")
	@Pattern(regexp = "1[3|4|5|7|8][0-9]\\d{8}",message = "手机号不符合规则")
	private String mobile;

	@NotBlank(message = "密码不能为空")
	@Size(min=5,max=20,message = "密码的长度需要在5~20之间")
	private String password;

	@NotBlank(message = "确认密码不能为空")
	@Size(min=5,max=20,message = "确认密码的长度需要在5~20之间")
	private String password2;
}
