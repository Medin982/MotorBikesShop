package com.motorbikesshop.model.entity;

import com.motorbikesshop.model.enums.PartCategoryType;

import javax.persistence.*;

@Entity
@Table(name = "parts_categories")
public class PartCategory extends BaseEntity{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PartCategoryType name;


    public PartCategory() {
    }

    public PartCategory(PartCategoryType name) {
        this.name = name;
    }

    public PartCategoryType getName() {
        return name;
    }

    public void setName(PartCategoryType name) {
        this.name = name;
    }
}
