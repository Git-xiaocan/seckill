package cn.xiaocan.seckill.service;

import cn.xiaocan.seckill.entity.User;
import cn.xiaocan.seckill.param.LoginParam;
import cn.xiaocan.seckill.result.Result;


public interface UserService {
    Result<User> login(LoginParam loginParam);
}
