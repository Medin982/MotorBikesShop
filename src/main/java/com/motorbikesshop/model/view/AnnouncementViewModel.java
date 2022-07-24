package com.motorbikesshop.model.view;

import com.motorbikesshop.model.entity.Brand;
import com.motorbikesshop.model.enums.ColorType;
import com.motorbikesshop.model.enums.EngineType;
import com.motorbikesshop.model.enums.TransmissionType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementViewModel {

    private Brand brand;

    private String modification;

    private ImagesViewModel images;

    private ColorType color;

    private EngineType engine;

    private int mileage;

    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModification() {
        return modification;
    }

    public void setModification(String modification) {
        this.modification = modification;
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
