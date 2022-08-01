package com.atguigu.aclservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.aclservice.entity.Role;
import com.atguigu.aclservice.service.RoleService;
import com.atguigu.aclservice.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author chen
* @description 针对表【acl_role】的数据库操作Service实现
* @createDate 2022-07-29 12:54:10
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




