package com.burn.burningcalories.controller;

import com.burn.burningcalories.common.Const;
import com.burn.burningcalories.common.ServerResponse;
import com.burn.burningcalories.domain.User;
import com.burn.burningcalories.service.IFileService;
import com.burn.burningcalories.service.IUserService;
import com.burn.burningcalories.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    private IUserService userService;

    private IFileService fileService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setFileService(IFileService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ServerResponse register(User user) {
        if (user.getUsername() == null || user.getPassword() == null || user.getBirth() == null || user.getGender() == null
        || user.getEmail() == null || user.getPhone() == null) {
            return ServerResponse.createByErrorMessage("参数错误!");
        }
        user.setAvatarUrl(Const.default_avatar_url);
        user.setBackgurandUrl(Const.default_backgurand_url);
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        user.setRole(0);
        return userService.register(user);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ServerResponse<User> login(String username, String password, HttpSession session) {
        ServerResponse response = userService.login(username,MD5Util.MD5EncodeUtf8(password));
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public ServerResponse<User> getUserInfo(HttpSession session) {
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户未登录!");
    }

    @RequestMapping(value = "/avatar",method = RequestMethod.POST)
    public ServerResponse updateAvatar(MultipartFile avatar, HttpSession session) {
        if (avatar == null) {
            return ServerResponse.createByErrorMessage("参数错误!");
        }
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户未登录!");
        }
        Integer userId = user.getId();

        String url = fileService.upload(avatar);
        return userService.updateAvatar(url,userId);
    }


    @RequestMapping(value = "/backgurand",method = RequestMethod.POST)
    public ServerResponse updateBackgurand(MultipartFile backgurand, HttpSession session) {
        if (backgurand == null) {
            return ServerResponse.createByErrorMessage("参数错误!");
        }
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户未登录!");
        }
        Integer userId = user.getId();

        String url = fileService.upload(backgurand);
        return userService.updateBackgurand(url,userId);
    }

}
