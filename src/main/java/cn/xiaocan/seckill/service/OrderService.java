package cn.xiaocan.seckill.service;

import cn.xiaocan.seckill.entity.OrderInfo;

public interface OrderService {

    long addOrder(OrderInfo orderInfo);

    OrderInfo getOrderInfo(long rderId);
}
