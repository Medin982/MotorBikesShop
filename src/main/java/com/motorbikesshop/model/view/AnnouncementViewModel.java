package com.motorbikesshop.model.view;

import com.motorbikesshop.model.entity.Brand;
import com.motorbikesshop.model.enums.EngineType;
import com.motorbikesshop.model.enums.TransmissionType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementViewModel {

    private Brand brand;

    private String modification;

    private List<ImagesViewModel> images = new ArrayList<>();

    private TransmissionType transmission;

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

    public List<ImagesViewModel> getImages() {
        return images;
    }

    public void setImages(List<ImagesViewModel> images) {
        this.images = images;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
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
