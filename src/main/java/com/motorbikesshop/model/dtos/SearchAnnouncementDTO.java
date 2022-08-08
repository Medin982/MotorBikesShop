package com.motorbikesshop.model.dtos;

import com.motorbikesshop.model.enums.MotorBikesType;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SearchAnnouncementDTO {

    private String modelId;

    private BigDecimal minPrice;

    private BigDecimal maxPrice;

    private Integer minMileage;

    private Integer maxMileage;

    private MotorBikesType category;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate after;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate before;


    public LocalDate getAfter() {
        return after;
    }

    public void setAfter(LocalDate after) {
        this.after = after;
    }

    public LocalDate getBefore() {
        return before;
    }

    public void setBefore(LocalDate before) {
        this.before = before;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getMinMileage() {
        return minMileage;
    }

    public void setMinMileage(Integer minMileage) {
        this.minMileage = minMileage;
    }

    public Integer getMaxMileage() {
        return maxMileage;
    }

    public void setMaxMileage(Integer maxMileage) {
        this.maxMileage = maxMileage;
    }

    public MotorBikesType getCategory() {
        return category;
    }

    public void setCategory(MotorBikesType category) {
        this.category = category;
    }

    public boolean isEmpty() {
        return (modelId == null || modelId.isEmpty()) &&
                minPrice == null && maxPrice == null &&
                minMileage == null && maxMileage == null &&
                category == null && after == null && before == null;
    }
}
