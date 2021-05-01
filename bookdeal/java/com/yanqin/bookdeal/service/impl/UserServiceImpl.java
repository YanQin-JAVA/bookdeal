package com.yanqin.bookdeal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanqin.bookdeal.domain.User;
import com.yanqin.bookdeal.service.UserService;
import com.yanqin.bookdeal.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService{

}




