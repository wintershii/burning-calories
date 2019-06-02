package com.burn.burningcalories.domain;

public class Material {
    private Integer id;

    private String cnName;

    private String enName;

    private Integer calories;

    private Integer type;

    private String ingredient;

    private Integer quality;

    private String unit;

    public Material(Integer id, String cnName, String enName, Integer calories, Integer type, String ingredient, Integer quality, String unit) {
        this.id = id;
        this.cnName = cnName;
        this.enName = enName;
        this.calories = calories;
        this.type = type;
        this.ingredient = ingredient;
        this.quality = quality;
        this.unit = unit;
    }

    public Material() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName == null ? null : cnName.trim();
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
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

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient == null ? null : ingredient.trim();
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }
}