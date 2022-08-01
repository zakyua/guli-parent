package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ChenCheng
 * @create 2022-06-29 21:58
 */
@Api(description="讲师管理")
@RestController
@CrossOrigin
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public R findAllTeacher(){
        // 1.查询所有的讲师信息
        List<EduTeacher> list = teacherService.list(null);
        // 2.将查询结果返回
        return R.ok().data("items",list);
    }

    @ApiOperation(value = "根据id获取讲师信息")
    @GetMapping("getTeacher/{id}")
    public R findTeacherByid(@PathVariable("id") String id){
        EduTeacher teacher = teacherService.getById(id);
        if(teacher == null){
            String result = "查无此人";
            return R.ok().data("result",result);
        }
        return R.ok().data("teacher",teacher);
    }


    @ApiOperation(value = "逻辑删除讲师")
    @DeleteMapping("{id}")
    public R removeTeacher(@ApiParam(name = "id", value = "讲师ID", required = true)
                           @PathVariable("id") String id){
        // 1.逻辑删除讲师,将数据库中的is_deleted改为0
        boolean flag = teacherService.removeById(id);
        if(flag){
            return R.ok();
        }
        return R.error();
    }


    @ApiOperation(value = "分页查询讲师的信息")
    @GetMapping("pageTeacher/{pageNo}/{pageSize}")
    public R pageListTeacher(@ApiParam(value = "需要的页数") @PathVariable("pageNo") long pageNo,
                             @ApiParam(value = "需要的条数") @PathVariable("pageSize") long pageSize){

        // 1.创建page对象
        Page<EduTeacher> pageTeacher = new Page(pageNo,pageSize);

        // 2.调用方法时候，底层封装，把分页所有数据封装到pageTeacher对象里面
        teacherService.page(pageTeacher, null);

        // 3.获取总记录数
        long total = pageTeacher.getTotal();

        // 4.获取查询出来的数据
        List<EduTeacher> records = pageTeacher.getRecords();

        return R.ok().data("total",total).data("records",records);
    }


    @ApiOperation(value = "分页带条件查询讲师的方法")
    @PostMapping("pageTeacherCondition/{pageNo}/{pageSize}")
    public R pageTeacherCondition(
            @ApiParam(value = "当前的页数") @PathVariable("pageNo") long pageNo,
            @ApiParam(value = "每页的记录数") @PathVariable(value = "pageSize") long pageSize,
            @ApiParam(value = "需要查询的讲师") @RequestBody(required = false) TeacherQuery teacherQuery){

        // 1.创建page对象
        Page<EduTeacher> page = new Page(pageNo, pageSize);

        // 2.分页带条件查询出讲师
        IPage<EduTeacher> iPage = teacherService.getTeachersByOpr(page,teacherQuery);

        // 3.查询失败
        if(iPage == null ){
            String result = "查无此人";
            return R.error().data("result",result);
        }

        // 4.查询成功封装数据
            // 4.1 总记录数
        long total = iPage.getTotal();
            // 4.2查询的讲师结果
        List<EduTeacher> records = iPage.getRecords();

        return R.ok().data("total",total).data("records",records);
    }



    @ApiOperation(value = "添加讲师的方法")
    @PostMapping("addTeacher")
    public R addTeacher(@ApiParam(value = "需要添加的讲师") @RequestBody EduTeacher eduTeacher){

        // 1.判断发送的数据是否有效
        if(eduTeacher == null){
            return R.error();
        }

        boolean save = teacherService.save(eduTeacher);

         // 1.添加成功
        if(save){
            return R.ok();
        }
        // 2.添加失败
        return R.error();
    }

    @ApiOperation(value = "讲师修改功能")
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean update = teacherService.updateById(eduTeacher);
        // 1.更新成功
        if(update){
            return R.ok();
        }
        // 2.更新失败
        return R.error();
    }

}
