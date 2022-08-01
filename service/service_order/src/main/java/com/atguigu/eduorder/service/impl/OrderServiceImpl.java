package com.atguigu.eduorder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.eduorder.entity.Order;
import com.atguigu.eduorder.service.OrderService;
import com.atguigu.eduorder.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author chen
* @description 针对表【t_order(订单)】的数据库操作Service实现
* @createDate 2022-07-18 20:46:35
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




