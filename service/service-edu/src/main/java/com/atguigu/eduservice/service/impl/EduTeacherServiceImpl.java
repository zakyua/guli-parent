package com.atguigu.eduservice.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.eduservice.mapper.EduTeacherMapper;
import org.springframework.stereotype.Service;

/**
* @author chen
* @description 针对表【edu_teacher(讲师)】的数据库操作Service实现
* @createDate 2022-06-29 21:44:05
*/
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher>
    implements EduTeacherService{



    @Override
    public IPage<EduTeacher> getTeachersByOpr(Page<EduTeacher> page, TeacherQuery teacherQuery) {

        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();

        if(teacherQuery == null){
           return null;
        }

   // 一.封装查询的条件
        // 获取姓名
        String name = teacherQuery.getName();
        if(!StringUtils.isEmpty(name)){
            queryWrapper.like("name",name);
        }
        // 获取头衔
        Integer level = teacherQuery.getLevel();
        if(null != level){
            queryWrapper.eq("level",level);
        }
        // 获取创建时间
        String begin = teacherQuery.getBegin();
        if(! StringUtils.isEmpty(begin)){
            // 大于等于 >= 封装在这个时间之前的讲师信息
            queryWrapper.ge("gmt_create",begin);
        }
        // 获取结束时间
        String end = teacherQuery.getEnd();
        if(! StringUtils.isEmpty(end)){
            // 小于等于 <= 封装在这个时间之后的讲师信息
            queryWrapper.le("gmt_modified",end);
        }

        // 利用创建时间
        queryWrapper.orderByDesc("gmt_create");


        IPage<EduTeacher> iPage = baseMapper.selectPage(page, queryWrapper);
        return iPage;
    }
}




