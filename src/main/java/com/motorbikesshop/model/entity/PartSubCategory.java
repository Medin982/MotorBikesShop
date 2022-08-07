package com.motorbikesshop.model.entity;

import com.motorbikesshop.model.enums.EngineSubCategoryType;

import javax.persistence.*;

@Entity
@Table(name = "parts_sub_categories")
public class PartSubCategory extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private PartCategory partCategory;

    public PartSubCategory() {
    }

    public PartSubCategory(String name) {
        this.name = name;
    }

    public PartCategory getPartCategory() {
        return partCategory;
    }

    public void setPartCategory(PartCategory partCategory) {
        this.partCategory = partCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
