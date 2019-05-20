package com.burn.burningcalories.service.impl;

import com.burn.burningcalories.common.ServerResponse;
import com.burn.burningcalories.dao.MaterialMapper;
import com.burn.burningcalories.domain.Material;
import com.burn.burningcalories.service.IFoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FoodServiceImpl implements IFoodService {

    private MaterialMapper materialMapper;

    @Resource
    public void setMaterialMapper(MaterialMapper materialMapper) {
        this.materialMapper = materialMapper;
    }

    @Override
    public ServerResponse getMaterialInfo(String enName) {
        Material material = materialMapper.getMaterialByEnName(enName);
        if (material != null) {
            return ServerResponse.createBySuccess(material);
        }
        return ServerResponse.createByErrorMessage("查找食材失败!");
    }
}
