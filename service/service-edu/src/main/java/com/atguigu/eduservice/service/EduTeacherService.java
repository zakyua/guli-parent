package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author chen
* @description 针对表【edu_teacher(讲师)】的数据库操作Service
* @createDate 2022-06-29 21:44:05
*/
public interface EduTeacherService extends IService<EduTeacher> {

    IPage<EduTeacher> getTeachersByOpr(Page<EduTeacher> page, TeacherQuery teacherQuery);
}
