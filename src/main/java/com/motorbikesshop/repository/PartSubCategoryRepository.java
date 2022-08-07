package com.motorbikesshop.repository;

import com.motorbikesshop.model.entity.PartSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartSubCategoryRepository extends JpaRepository<PartSubCategory, String> {
}
