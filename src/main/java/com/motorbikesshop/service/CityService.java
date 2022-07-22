package com.motorbikesshop.service;

import com.motorbikesshop.model.dtos.AddAnnouncementDTO;
import com.motorbikesshop.model.entity.City;
import com.motorbikesshop.repository.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City createCity(String cityName, int postCode) {
        if (this.cityRepository.findByName(cityName).isPresent()) {
            return this.cityRepository.findByName(cityName).get();
        }
        City city = new City();
        city.setName(cityName);
        city.setPostCode(postCode);
        this.cityRepository.save(city);
        return city;
    }
}
