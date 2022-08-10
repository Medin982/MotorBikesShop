package com.motorbikesshop.repository;

import com.motorbikesshop.model.entity.Part;
import com.motorbikesshop.model.enums.PartCategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartsRepository extends JpaRepository<Part, String> {

    List<Part> findAllByCategory_Name(PartCategoryType engine);
}
