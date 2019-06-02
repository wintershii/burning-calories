package com.burn.burningcalories.vo;

import java.util.Date;

public class FoodVo {
    private Integer id;

    private Integer userId;

    private UserAvatar userAvatar;

    private String foodname;

    private Integer updateMethod;

    private String foodImage;

    private Integer calories;

    private Integer type;

    private Date foodTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserAvatar getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(UserAvatar userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public Integer getUpdateMethod() {
        return updateMethod;
    }

    public void setUpdateMethod(Integer updateMethod) {
        this.updateMethod = updateMethod;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getFoodTime() {
        return foodTime;
    }

    public void setFoodTime(Date foodTime) {
        this.foodTime = foodTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
