package com.motorbikesshop.model.view;

import com.motorbikesshop.model.entity.Brand;
import com.motorbikesshop.model.entity.Model;
import com.motorbikesshop.model.enums.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class AnnouncementDetailsViewModel {

    private Model model;

    private String modification;

    private List<ImagesViewModel> images;

    private ColorType color;

    private EngineType engine;

    private int mileage;

    private BigDecimal price;

    private TransmissionType transmission;

    private LocalDate dateOfManufacture;

    private MotorBikesType category;

    private ConditionType conditions;

    private AddressesViewModel address;

    private UserViewModel seller;

    private String description;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
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

    public AddressesViewModel getAddress() {
        return address;
    }

    public void setAddress(AddressesViewModel address) {
        this.address = address;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public MotorBikesType getCategory() {
        return category;
    }

    public void setCategory(MotorBikesType category) {
        this.category = category;
    }

    public ConditionType getConditions() {
        return conditions;
    }

    public void setConditions(ConditionType conditions) {
        this.conditions = conditions;
    }

    public UserViewModel getSeller() {
        return seller;
    }

    public void setSeller(UserViewModel seller) {
        this.seller = seller;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
