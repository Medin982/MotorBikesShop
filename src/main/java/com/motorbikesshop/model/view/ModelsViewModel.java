package com.motorbikesshop.model.view;

public class ModelsViewModel {

    private String id;

    private String name;

    private BrandViewModel brand;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BrandViewModel getBrand() {
        return brand;
    }

    public void setBrand(BrandViewModel brand) {
        this.brand = brand;
    }
}
