package com.burn.burningcalories.service;

import com.burn.burningcalories.common.ServerResponse;

public interface IFoodService {
    ServerResponse getMaterialInfo(String enName);
}
