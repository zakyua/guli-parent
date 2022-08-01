package com.atguigu.aclservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.aclservice.entity.UserRole;
import com.atguigu.aclservice.service.UserRoleService;
import com.atguigu.aclservice.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author chen
* @description 针对表【acl_user_role】的数据库操作Service实现
* @createDate 2022-07-29 12:56:14
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




