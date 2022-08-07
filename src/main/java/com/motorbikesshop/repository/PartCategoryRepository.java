package com.motorbikesshop.repository;

import com.motorbikesshop.model.entity.PartCategory;
import com.motorbikesshop.model.enums.PartCategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartCategoryRepository extends JpaRepository<PartCategory, String> {
    Optional<PartCategory> findByName(PartCategoryType engine);
}
