package com.burn.burningcalories.domain;

import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private String password;

    private Integer gender;

    private Integer role;

    private String phone;

    private String email;

    private Integer height;

    private Integer weight;

    private Date birth;

    private String avatarUrl;

    private String backgurandUrl;

    private Date createTime;

    private Date updateTime;

    public User(Integer id, String username, String password, Integer gender, Integer role, String phone, String email, Integer height, Integer weight, Date birth, String avatarUrl, String backgurandUrl, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.role = role;
        this.phone = phone;
        this.email = email;
        this.height = height;
        this.weight = weight;
        this.birth = birth;
        this.avatarUrl = avatarUrl;
        this.backgurandUrl = backgurandUrl;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public String getBackgurandUrl() {
        return backgurandUrl;
    }

    public void setBackgurandUrl(String backgurandUrl) {
        this.backgurandUrl = backgurandUrl == null ? null : backgurandUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}