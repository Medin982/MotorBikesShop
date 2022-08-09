package com.motorbikesshop.repository;

import com.motorbikesshop.model.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartsRepository extends JpaRepository<Part, String> {
    Part findByName(String tyres);
}
