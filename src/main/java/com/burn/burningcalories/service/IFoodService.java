package com.burn.burningcalories.service;

import com.burn.burningcalories.common.ServerResponse;
import com.burn.burningcalories.domain.Food;
import com.burn.burningcalories.domain.Material;
import com.burn.burningcalories.vo.FoodVo;

import java.util.List;

public interface IFoodService {
    ServerResponse<Material> getMaterialInfo(String enName);

    ServerResponse uploadFood(Food food);

    ServerResponse<List<FoodVo>> getFoodInfo(Integer userId);
}
