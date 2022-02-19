package cn.xiaocan.seckill.controller;

import cn.xiaocan.seckill.bo.GoodsBo;
import cn.xiaocan.seckill.entity.OrderInfo;
import cn.xiaocan.seckill.entity.User;
import cn.xiaocan.seckill.redis.RedisService;
import cn.xiaocan.seckill.redis.UserKey;
import cn.xiaocan.seckill.result.CodeMsg;
import cn.xiaocan.seckill.result.Result;
import cn.xiaocan.seckill.service.SeckillGoodsService;
import cn.xiaocan.seckill.service.SeckillOrderService;
import cn.xiaocan.seckill.util.CookieUtil;
import cn.xiaocan.seckill.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/order")
public class SeckillOrderController {
    @Autowired
    RedisService redisService;
    @Autowired
    SeckillOrderService seckillOrderService;
    @Autowired
    SeckillGoodsService seckillGoodsService;

    @RequestMapping("/detail")
    @ResponseBody
    public Result<OrderDetailVo> info(Model model,
                                      @RequestParam("orderId") long orderId , HttpServletRequest request) {
        String loginToken = CookieUtil.readLoginToken(request);
        User user = redisService.get(UserKey.getByName, loginToken, User.class);
        if(user == null) {
            return Result.error(CodeMsg.USER_NO_LOGIN);
        }
        OrderInfo order = seckillOrderService.getOrderInfo(orderId);
        if(order == null) {
            return Result.error(CodeMsg.ORDER_NOT_EXIST);
        }
        long goodsId = order.getGoodsId();
        GoodsBo goods = seckillGoodsService.getseckillGoodsBoByGoodsId(goodsId);
        OrderDetailVo vo = new OrderDetailVo();
        vo.setOrder(order);
        vo.setGoods(goods);
        return Result.success(vo);
    }
}
