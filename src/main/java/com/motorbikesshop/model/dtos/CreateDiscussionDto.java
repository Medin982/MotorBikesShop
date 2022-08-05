package com.motorbikesshop.model.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateDiscussionDto {

    @Size(min = 6)
    @NotBlank
    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
