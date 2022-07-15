package com.motorbikesshop.repository;

import com.motorbikesshop.model.entity.Role;
import com.motorbikesshop.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {


    Optional<Role> findByName(UserRoleEnum nameRole);
}
