package com.motorbikesshop.model.entity;

import com.motorbikesshop.model.enums.UserRoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "users_roles")
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRoleEnum name;

    public Role (UserRoleEnum role) {
        this.name = role;
    }

    public Role() {
    }

    public UserRoleEnum getName() {
        return name;
    }

    public void setName(UserRoleEnum name) {
        this.name = name;
    }
}
