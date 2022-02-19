package cn.xiaocan.seckill.service;

import cn.xiaocan.seckill.bo.GoodsBo;
import cn.xiaocan.seckill.entity.OrderInfo;
import cn.xiaocan.seckill.entity.SeckillOrder;
import cn.xiaocan.seckill.entity.User;


public interface SeckillOrderService {

    SeckillOrder getSeckillOrderByUserIdGoodsId(long userId , long goodsId);


    OrderInfo insert(User user , GoodsBo goodsBo);

    OrderInfo getOrderInfo(long orderId);

    long getSeckillResult(Long userId, long goodsId);

    boolean checkPath(User user, long goodsId, String path);

    String createMiaoshaPath(User user, long goodsId);

}
