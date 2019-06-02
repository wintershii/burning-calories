package com.burn.burningcalories.dao;

import com.burn.burningcalories.domain.Material;

public interface MaterialMapper {
    int insert(Material record);

    int insertSelective(Material record);

    Material getMaterialByEnName(String enName);

}