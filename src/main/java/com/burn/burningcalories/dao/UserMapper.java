package com.burn.burningcalories.dao;

import com.burn.burningcalories.domain.User;
import com.burn.burningcalories.vo.UserAvatar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    int checkUsername(String username);
    int checkPhone(String phone);
    int checkEmail(String email);

    User login(@Param("username") String username, @Param("password") String password);

    int updateAvatar(@Param("url") String url, @Param("userId") Integer userId);

    int updateBackgurand(@Param("url") String url, @Param("userId") Integer userId);

    UserAvatar getAvatarInfo(Integer userId);
}