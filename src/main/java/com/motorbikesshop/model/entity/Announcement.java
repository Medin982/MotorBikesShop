package com.motorbikesshop.model.entity;

import com.motorbikesshop.model.enums.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name ="announcements")
public class Announcement extends BaseEntity{

    @ManyToOne(optional = false)
    private Brand brand;

    @ManyToOne(optional = false)
    private Model model;

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
    private LocalDate dateОfМanufacturе;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MotorBikesType category;

    @Column(nullable = false)
    private int mileage;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConditionType condition;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ColorType color;

    @ManyToOne(optional = false)
    private Address address;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime created;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
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

    public LocalDate getDateОfМanufacturе() {
        return dateОfМanufacturе;
    }

    public void setDateОfМanufacturе(LocalDate dateОfМanufacturе) {
        this.dateОfМanufacturе = dateОfМanufacturе;
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
        return condition;
    }

    public void setCondition(ConditionType condition) {
        this.condition = condition;
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

