package com.motorbikesshop.model.view;

import com.motorbikesshop.model.enums.PartCategoryType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class CategoryViewModel {

    @Enumerated(EnumType.STRING)
    private PartCategoryType name;

    public PartCategoryType getName() {
        return name;
    }

    public void setName(PartCategoryType name) {
        this.name = name;
    }
}
