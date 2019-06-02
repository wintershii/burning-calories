package com.burn.burningcalories.domain;

import java.util.Date;

public class Food {
    private Integer id;

    private Integer userId;

    private String foodname;

    private Integer updateMethod;

    private String foodImage;

    private Integer calories;

    private Integer type;

    private Date foodTime;

    private Date createTime;

    public Food(Integer id, Integer userId, String foodname, Integer updateMethod, String foodImage, Integer calories, Integer type, Date foodTime, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.foodname = foodname;
        this.updateMethod = updateMethod;
        this.foodImage = foodImage;
        this.calories = calories;
        this.type = type;
        this.foodTime = foodTime;
        this.createTime = createTime;
    }

    public Food(Integer userId, String foodname, Integer updateMethod, String foodImage, Integer calories, Integer type, Date foodTime) {
        this.userId = userId;
        this.foodname = foodname;
        this.updateMethod = updateMethod;
        this.foodImage = foodImage;
        this.calories = calories;
        this.type = type;
        this.foodTime = foodTime;
    }

    public Food() {
        super();
    }

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

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname == null ? null : foodname.trim();
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
        this.foodImage = foodImage == null ? null : foodImage.trim();
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