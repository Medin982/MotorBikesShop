package com.motorbikesshop.model.entity;

import com.motorbikesshop.model.enums.MotorBikesType;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class Model extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private MotorBikesType category;

    @ManyToOne
    private Brand brand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MotorBikesType getCategory() {
        return category;
    }

    public void setCategory(MotorBikesType category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
