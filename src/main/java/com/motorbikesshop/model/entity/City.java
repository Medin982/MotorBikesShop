package com.motorbikesshop.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="cities")
public class City extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private int postCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }
}
