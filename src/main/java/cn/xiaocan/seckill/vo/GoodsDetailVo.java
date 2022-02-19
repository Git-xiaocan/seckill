package cn.xiaocan.seckill.vo;

import cn.xiaocan.seckill.bo.GoodsBo;
import cn.xiaocan.seckill.entity.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GoodsDetailVo {
    private int miaoshaStatus = 0;
    private int remainSeconds = 0;
    private GoodsBo goods ;
    private User user;
}
