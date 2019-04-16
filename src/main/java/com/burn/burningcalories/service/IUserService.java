package com.burn.burningcalories.service;

import com.burn.burningcalories.common.ServerResponse;
import com.burn.burningcalories.domain.User;


public interface IUserService {
    ServerResponse register(User user);
    ServerResponse<User> login(String username, String password);

    ServerResponse updateAvatar(String url, Integer userId);

    ServerResponse updateBackgurand(String url, Integer userId);
}
