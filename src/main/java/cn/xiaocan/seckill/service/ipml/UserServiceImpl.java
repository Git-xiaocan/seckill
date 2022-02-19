package cn.xiaocan.seckill.service.ipml;

import cn.xiaocan.seckill.entity.User;
import cn.xiaocan.seckill.dao.UserMapper;
import cn.xiaocan.seckill.param.LoginParam;
import cn.xiaocan.seckill.result.CodeMsg;
import cn.xiaocan.seckill.result.Result;
import cn.xiaocan.seckill.service.UserService;
import cn.xiaocan.seckill.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;
    @Override
    public Result<User> login(LoginParam loginParam) {

        User user = userMapper.checkPhone(loginParam.getMobile());
        if(user == null){
            return Result.error(CodeMsg.MOBILE_NOT_EXIST);
        }
        String dbPwd= user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(loginParam.getPassword(), saltDB);
        if(!StringUtils.equals(dbPwd , calcPass)){
            return Result.error(CodeMsg.PASSWORD_ERROR);
        }
        user.setPassword(StringUtils.EMPTY);
        return Result.success(user);
    }
}
