package com.burn.burningcalories.controller;

import com.burn.burningcalories.common.Const;
import com.burn.burningcalories.common.ServerResponse;
import com.burn.burningcalories.domain.User;
import com.burn.burningcalories.service.IUserService;
import com.burn.burningcalories.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ServerResponse register(User user) {
        user.setAvatarUrl(Const.default_avatar_url);
        user.setBackgurandUrl(Const.default_backgurand_url);
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        user.setRole(0);
        return userService.register(user);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ServerResponse<User> login(String username, String password) {
        return userService.login(username,MD5Util.MD5EncodeUtf8(password));
    }

}
