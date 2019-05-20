package com.burn.burningcalories.domain;

public class Material {
    private Integer id;

    private String cnName;

    private String enName;

    private Integer colores;

    private Integer type;

    private String ingredient;

    public Material(Integer id, String cnName, String enName, Integer colores, Integer type, String ingredient) {
        this.id = id;
        this.cnName = cnName;
        this.enName = enName;
        this.colores = colores;
        this.type = type;
        this.ingredient = ingredient;
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

    public Integer getColores() {
        return colores;
    }

    public void setColores(Integer colores) {
        this.colores = colores;
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
}