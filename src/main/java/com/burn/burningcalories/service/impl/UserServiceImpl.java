package com.burn.burningcalories.service.impl;

import com.burn.burningcalories.common.Const;
import com.burn.burningcalories.common.ServerResponse;
import com.burn.burningcalories.dao.UserMapper;
import com.burn.burningcalories.service.IUserService;
import com.burn.burningcalories.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    private UserMapper userMapper;

    @Resource
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public ServerResponse register(User user) {
        ServerResponse validResponse = this.checkValid(user.getUsername(), Const.USERNAME);
        if (!validResponse.isSuccess()) {
            return validResponse;
        }

        validResponse = this.checkValid(user.getUsername(),Const.PHONE);
        if (!validResponse.isSuccess()) {
            return validResponse;
        }

        validResponse = this.checkValid(user.getUsername(),Const.EMAIL);
        if (!validResponse.isSuccess()) {
            return validResponse;
        }

        int resultCount = userMapper.insert(user);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("注册成功!");
        }
        return ServerResponse.createByErrorMessage("注册失败!");
    }


    @Override
    public ServerResponse<User> login(String username, String password) {
        User user = userMapper.login(username,password);
        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("登录失败!请检查用户名或密码");
    }

    private ServerResponse<String> checkValid(String data, String type) {
        //type: 1-用户名 2-手机号 3-邮箱

        if (StringUtils.isNotBlank(type)) {
            int resultCount = 0;
            if (StringUtils.equals(type,Const.USERNAME)) {
                resultCount = userMapper.checkUsername(data);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("该用户名已存在!");
                }
            }

            if (StringUtils.equals(type,Const.PHONE)) {
                resultCount = userMapper.checkPhone(data);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("该手机号已注册!");
                }
            }

            if (StringUtils.equals(type,Const.EMAIL)) {
                resultCount = userMapper.checkEmail(data);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("该邮箱已注册!");
                }
            }
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }
}
