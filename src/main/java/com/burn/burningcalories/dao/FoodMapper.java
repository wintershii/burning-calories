package com.burn.burningcalories.dao;

import com.burn.burningcalories.domain.Food;
import com.burn.burningcalories.vo.UserAvatar;

import java.util.List;

public interface FoodMapper {
    int insert(Food record);

    int insertSelective(Food record);

    List<Food> getFoodInfo(Integer userId);


}