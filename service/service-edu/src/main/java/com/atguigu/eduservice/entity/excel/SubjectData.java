package com.atguigu.eduservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ChenCheng
 * @create 2022-07-06 20:42
 */
@Data
public class SubjectData {

    @ApiModelProperty(value = "一级标题")
    @ExcelProperty(index = 0)
    private String oneSubjectName;

    @ApiModelProperty(value = "二级标题")
    @ExcelProperty(index = 1)
    private String twoSubjectName;
}
