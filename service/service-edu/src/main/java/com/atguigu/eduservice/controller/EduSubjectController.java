package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ChenCheng
 * @create 2022-07-06 20:05
 */
@Api(description = "课程管理")
@RestController
@RequestMapping("/eduservice/subject")
public class EduSubjectController {

    @Autowired
    private EduSubjectService eduSubjectService;


    @ApiOperation(value = "获取上传的文件，添加课程分类")
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file){
        // 1.获取前端发来的文件,进行读取
        eduSubjectService.saveSubject(file,eduSubjectService);
        return R.ok();
    }


    @ApiOperation(value = "查询课程分类列表")
    @GetMapping("getAllSubject")
    public R getAllSubject() {

        return R.ok();
    }





}
