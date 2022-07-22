package com.motorbikesshop.service;

import com.motorbikesshop.model.dtos.AddAnnouncementDTO;
import com.motorbikesshop.model.entity.Address;
import com.motorbikesshop.model.entity.City;
import com.motorbikesshop.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address createAddresses(String street, int streetNumber , City city) {
        if (this.addressRepository.findByStreetAndStreetNumber
                (street, streetNumber).isPresent()) {
            return this.addressRepository.findByStreetAndStreetNumber
                    (street, streetNumber).get();
        }
        Address address = new Address();
        address.setCity(city);
        address.setStreet(street);
        address.setStreetNumber(streetNumber);
        this.addressRepository.save(address);
        return address;
    }
}
