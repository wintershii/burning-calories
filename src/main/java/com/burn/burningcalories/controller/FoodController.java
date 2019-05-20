package com.burn.burningcalories.controller;

import com.burn.burningcalories.common.ServerResponse;
import com.burn.burningcalories.domain.Material;
import com.burn.burningcalories.service.IFoodService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodController {

    private IFoodService foodService;

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


}
