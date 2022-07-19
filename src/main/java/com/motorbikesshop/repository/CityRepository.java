package com.motorbikesshop.repository;

import com.motorbikesshop.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, String>{
    Optional<City> findByName(String city);
}
