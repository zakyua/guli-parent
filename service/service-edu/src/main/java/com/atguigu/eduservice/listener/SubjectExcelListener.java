package com.atguigu.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.excel.SubjectData;
import com.atguigu.eduservice.service.EduSubjectService;
import com.atguigu.servicebase.Exception.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * @author ChenCheng
 * @create 2022-07-06 20:44
 */
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    /**
     *  SubjectExcelListener 这个监听器不能交给spring来管理，所以我们需要在这个将EduSubjectService手动的传进来
     *  ,才能实现对数据库的操作
     *
     */

    public EduSubjectService subjectService;

    public SubjectExcelListener() {

    }

    public SubjectExcelListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    /**
     *   读取excel内容，一行一行进行读取
     * @param subjectData
     * @param analysisContext
     */
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {

        // 1.判断subjectData是否有效
        if(subjectData == null){
            throw new GuliException(20001,"文件数据为空");
        }
        // 每次都是一行一行读取，每次读取有两个值，第一个值一级分类，第二个值二级分类
        // 2.判断一级分类是否有效,获取一级分类的名称
        String oneSubjectName = subjectData.getOneSubjectName();

        // 2.1 根据一级分类的特性和一级分类名称查出EduSubject对象
        EduSubject eduSubject = this.existOneSubject(subjectService,oneSubjectName);

        // 2.2判断eduSubject是否有效
        if(eduSubject == null){
            // 当前一级分类没有重复,正常添加
            // 2.3准备一个 EduSubject
            eduSubject = new EduSubject();

            // 2.4这是一个一级标题,没有父节点
            eduSubject.setParentId("0");

            // 2.5设置eduSubject的课程类别的名称
            eduSubject.setTitle(subjectData.getOneSubjectName());

            // 2.6保存数据库
            subjectService.save(eduSubject);
        }


        // 3.将一级分类eduSubject保存到数据库后,或者是数据库本身就有这个一级分类eduSubject,那我们一定可以得到他的id
        String pid = eduSubject.getId();

        // 4.判断二级分类是否有效,获取二级分类的名称
        String twoSubjectName = subjectData.getTwoSubjectName();

        // 4.1根据二级分类的特性,在数据库中判断二级分类是否重复
        EduSubject eduTwoSubject = this.existTwoSubject(subjectService, twoSubjectName, pid);

        // 4.2判断eduTwoSubject是否有效
        if(eduTwoSubject == null){
            // 当前二级分类没有重复,正常添加
            // 4.3准备一个 EduSubject
            eduTwoSubject = new EduSubject();
            // 4.4设置二级标题的名称
            eduTwoSubject.setTitle(subjectData.getTwoSubjectName());
            // 4.5设置父节点
            eduTwoSubject.setParentId(pid);
            // 4.6保存数据库
            subjectService.save(eduTwoSubject);
        }



    }


    @ApiModelProperty("查询一级分类是否重复")
    private EduSubject existOneSubject(
            @ApiParam(value = "进行数据库操作") EduSubjectService eduSubjectService,
            @ApiParam(value = "一级分类的名称") String name){
        // 1.封装查询的条件
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        // 2.封装课程类别名称
        queryWrapper.eq("title",name);
        // 3.当前为一级标题,没有父节点
        queryWrapper.eq("parent_id","0");

        return eduSubjectService.getOne(queryWrapper);
    }


    @ApiModelProperty(value = "查询二级分类是否重复")
    private EduSubject existTwoSubject(
            @ApiParam(value = "进行数据库操作") EduSubjectService subjectService,
            @ApiParam(value = "二级分类的名称") String name,
            @ApiParam(value = "父节点") String pid){
        // 1.封装查询的条件
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        // 2.封装课程类别名称
        queryWrapper.eq("title",name);
        // 3.当前为二级标题,父节点为pid
        queryWrapper.eq("parent_id",pid);

       return subjectService.getOne(queryWrapper);
    }



    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
