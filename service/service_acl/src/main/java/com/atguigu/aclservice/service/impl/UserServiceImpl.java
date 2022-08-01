package com.atguigu.aclservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.aclservice.entity.User;
import com.atguigu.aclservice.service.UserService;
import com.atguigu.aclservice.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author chen
* @description 针对表【acl_user(用户表)】的数据库操作Service实现
* @createDate 2022-07-29 12:55:29
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




