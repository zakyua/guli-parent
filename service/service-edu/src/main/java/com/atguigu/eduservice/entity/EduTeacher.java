package com.atguigu.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 讲师
 * @TableName edu_teacher
 */
@TableName(value ="edu_teacher")
@Data
@ApiModel(value="EduTeacher对象", description="讲师")
public class EduTeacher implements Serializable {
    /**
     * 讲师ID
     */
    @ApiModelProperty(value = "讲师ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 讲师姓名
     */
    @ApiModelProperty(value = "讲师姓名")
    private String name;

    /**
     * 讲师简介
     */
    @ApiModelProperty(value = "讲师简介")
    private String intro;

    /**
     * 讲师资历,一句话说明讲师
     */
    @ApiModelProperty(value = "讲师资历,一句话说明讲师")
    private String career;

    /**
     * 头衔 1高级讲师 2首席讲师
     */
    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    /**
     * 讲师头像
     */
    @ApiModelProperty(value = "讲师头像")
    private String avatar;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableLogic
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}