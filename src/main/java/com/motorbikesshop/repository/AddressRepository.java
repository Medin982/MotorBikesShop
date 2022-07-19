package com.motorbikesshop.repository;

import com.motorbikesshop.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    Optional<Address> findByStreet(String street);

    Optional<Address> findByStreetAndStreetNumber(String street, int streetNumber);
}
