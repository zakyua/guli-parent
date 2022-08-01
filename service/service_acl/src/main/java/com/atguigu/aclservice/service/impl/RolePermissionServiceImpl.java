package com.atguigu.aclservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.aclservice.entity.RolePermission;
import com.atguigu.aclservice.service.RolePermissionService;
import com.atguigu.aclservice.mapper.RolePermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author chen
* @description 针对表【acl_role_permission(角色权限)】的数据库操作Service实现
* @createDate 2022-07-29 12:54:51
*/
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission>
    implements RolePermissionService{

}




