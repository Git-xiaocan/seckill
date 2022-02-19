package cn.xiaocan.seckill.vo;

import cn.xiaocan.seckill.bo.GoodsBo;
import cn.xiaocan.seckill.entity.OrderInfo;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class OrderDetailVo {
    private GoodsBo goods;
    private OrderInfo order;
}
