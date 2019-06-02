package com.burn.burningcalories.service.impl;

import com.burn.burningcalories.common.ServerResponse;
import com.burn.burningcalories.dao.FoodMapper;
import com.burn.burningcalories.dao.MaterialMapper;
import com.burn.burningcalories.dao.UserMapper;
import com.burn.burningcalories.domain.Food;
import com.burn.burningcalories.domain.Material;
import com.burn.burningcalories.service.IFoodService;
import com.burn.burningcalories.vo.FoodVo;
import com.burn.burningcalories.vo.UserAvatar;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class FoodServiceImpl implements IFoodService {

    private MaterialMapper materialMapper;

    private FoodMapper foodMapper;

    private UserMapper userMapper;

    @Resource
    public void setMaterialMapper(MaterialMapper materialMapper) {
        this.materialMapper = materialMapper;
    }

    @Resource
    public void setFoodMapper(FoodMapper foodMapper) {
        this.foodMapper = foodMapper;
    }

    @Resource
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public ServerResponse<Material> getMaterialInfo(String enName) {
        Material material = materialMapper.getMaterialByEnName(enName);
        if (material != null) {
            return ServerResponse.createBySuccess(material);
        }
        return ServerResponse.createByErrorMessage("查找食材失败!");
    }

    @Override
    public ServerResponse uploadFood(Food food) {
        int resultCount = foodMapper.insert(food);
        if (resultCount  > 0) {
            return ServerResponse.createBySuccess("上传成功!");
        }
        return ServerResponse.createByErrorMessage("上传失败!");
    }

    @Override
    public ServerResponse<List<FoodVo>> getFoodInfo(Integer userId) {
        List<Food> foodList = foodMapper.getFoodInfo(userId);
        List<FoodVo> foodVos = new ArrayList<>();
        for (Food food : foodList) {
            foodVos.add(foodToVo(food));
        }
        return ServerResponse.createBySuccess(foodVos);
    }

    private FoodVo foodToVo(Food food) {
        FoodVo foodVo = new FoodVo();
        foodVo.setId(food.getId());
        foodVo.setCalories(food.getCalories());
        foodVo.setCreateTime(food.getCreateTime());
        foodVo.setFoodImage(food.getFoodImage());
        foodVo.setFoodname(food.getFoodname());
        foodVo.setFoodTime(food.getFoodTime());
        foodVo.setType(food.getType());
        foodVo.setUpdateMethod(food.getUpdateMethod());
        foodVo.setUserId(food.getUserId());
        UserAvatar userAvatar = userMapper.getAvatarInfo(food.getUserId());
        foodVo.setUserAvatar(userAvatar);
        return foodVo;
    }
}
