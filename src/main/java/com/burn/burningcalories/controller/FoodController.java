package com.burn.burningcalories.controller;

import com.burn.burningcalories.common.Const;
import com.burn.burningcalories.common.ServerResponse;
import com.burn.burningcalories.domain.Food;
import com.burn.burningcalories.domain.Material;
import com.burn.burningcalories.domain.User;
import com.burn.burningcalories.service.IFileService;
import com.burn.burningcalories.service.IFoodService;
import com.burn.burningcalories.vo.FoodVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    private IFileService fileService;

    private IFoodService foodService;

    @Autowired
    public void setFileService(IFileService fileService) {
        this.fileService = fileService;
    }

    @Autowired
    public void setFoodService(IFoodService foodService) {
        this.foodService = foodService;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ServerResponse<Material> getMaterialInfo(String enName) {
        if (StringUtils.isBlank(enName)) {
            return ServerResponse.createByErrorMessage("参数错误!");
        }
        enName = enName.trim();
        return foodService.getMaterialInfo(enName);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ServerResponse uploadFood(HttpSession  session, Integer userId, String foodname, Integer updateMethod,
                                     MultipartFile foodImage, Integer calories, Integer type, Date foodTime) {
        if (userId == null || foodname == null || updateMethod == null || foodImage == null || calories == null || type == null || foodTime == null) {

            if (foodImage == null) {
                System.out.println("文件为空");
            }

            return ServerResponse.createByErrorMessage("参数错误!");
        }
        Integer realId = ((User)(session.getAttribute(Const.CURRENT_USER))).getId();
        if (realId.intValue() != userId) {
            return ServerResponse.createByErrorMessage("登录用户信息有误,权限错误!");
        }

        String url = fileService.upload(foodImage);

        Food food = new Food(userId,foodname,updateMethod,url,calories,type,foodTime);

        return foodService.uploadFood(food);
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ServerResponse<List<FoodVo>> getFoodInfo(HttpSession session) {
        Integer userId = ((User)(session.getAttribute(Const.CURRENT_USER))).getId();
        if (userId == null) {
            return ServerResponse.createByErrorMessage("请先登录!");
        }
        return foodService.getFoodInfo(userId);
    }


}
