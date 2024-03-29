package com.motorbikesshop.model.view;

import com.motorbikesshop.model.entity.Model;
import com.motorbikesshop.model.enums.ColorType;
import com.motorbikesshop.model.enums.EngineType;


import java.math.BigDecimal;

public class AnnouncementViewModel {

    private String id;

    private ModelsViewModel model;

    private ImagesViewModel images;

    private ColorType color;

    private EngineType engine;

    private int mileage;

    private BigDecimal price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ModelsViewModel getModel() {
        return model;
    }

    public void setModel(ModelsViewModel model) {
        this.model = model;
    }

    public ImagesViewModel getImages() {
        return images;
    }

    public void setImages(ImagesViewModel images) {
        this.images = images;
    }

    public ColorType getColor() {
        return color;
    }

    public void setColor(ColorType color) {
        this.color = color;
    }

    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }


}
