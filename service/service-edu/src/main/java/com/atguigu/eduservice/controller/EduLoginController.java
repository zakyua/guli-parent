package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author ChenCheng
 * @create 2022-07-05 13:48
 */
@Api(description="登录请求")
@RequestMapping("/eduservice/user")
@RestController
@CrossOrigin      // 解决跨域问题的注解
public class EduLoginController {


    @ApiOperation("登录的请求")
    @PostMapping("login")
    public R login() {
        return R.ok().data("token","admin");
    }

    @ApiOperation("登录请求数据")
    @GetMapping("info")
    public R info() {
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }



}
