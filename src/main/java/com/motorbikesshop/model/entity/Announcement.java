package com.motorbikesshop.model.entity;

import com.motorbikesshop.model.enums.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="announcements")
public class Announcement extends BaseEntity{

    @ManyToOne(optional = false)
    private Brand brand;

    @Column(nullable = false)
    private int horsePower;

    @Column(nullable = false)
    private String modification;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EngineType engine;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransmissionType transmission;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private LocalDate dateOfManufacture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MotorBikesType category;

    @Column(nullable = false)
    private int mileage;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConditionType conditions;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ColorType color;

    @ManyToOne(optional = false)
    private Address address;

    @ManyToOne(optional = false)
    private UserEntity seller;

    @CreatedDate
    private LocalDateTime created;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "announcement", targetEntity = Images.class, fetch = FetchType.EAGER)
    private List<Images> images = new ArrayList<>();

    public ConditionType getConditions() {
        return conditions;
    }

    public void setConditions(ConditionType conditions) {
        this.conditions = conditions;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getModification() {
        return modification;
    }

    public void setModification(String modification) {
        this.modification = modification;
    }

    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public MotorBikesType getCategory() {
        return category;
    }

    public void setCategory(MotorBikesType category) {
        this.category = category;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public ConditionType getCondition() {
        return conditions;
    }

    public void setCondition(ConditionType condition) {
        this.conditions = condition;
    }

    public ColorType getColor() {
        return color;
    }

    public void setColor(ColorType color) {
        this.color = color;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}

