package com.atguigu.aclservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.aclservice.entity.Permission;
import com.atguigu.aclservice.service.PermissionService;
import com.atguigu.aclservice.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author chen
* @description 针对表【acl_permission(权限)】的数据库操作Service实现
* @createDate 2022-07-29 12:53:17
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService{

}




