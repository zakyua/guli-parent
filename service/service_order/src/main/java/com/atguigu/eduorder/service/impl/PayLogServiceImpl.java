package com.atguigu.eduorder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.eduorder.entity.PayLog;
import com.atguigu.eduorder.service.PayLogService;
import com.atguigu.eduorder.mapper.PayLogMapper;
import org.springframework.stereotype.Service;

/**
* @author chen
* @description 针对表【t_pay_log(支付日志表)】的数据库操作Service实现
* @createDate 2022-07-18 20:46:49
*/
@Service
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper, PayLog>
    implements PayLogService{

}




