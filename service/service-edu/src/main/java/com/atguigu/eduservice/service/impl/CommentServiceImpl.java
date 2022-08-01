package com.atguigu.eduservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.eduservice.entity.Comment;
import com.atguigu.eduservice.service.CommentService;
import com.atguigu.eduservice.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author chen
* @description 针对表【edu_comment(评论)】的数据库操作Service实现
* @createDate 2022-07-18 21:02:12
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




