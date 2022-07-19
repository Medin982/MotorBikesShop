package com.motorbikesshop.service;

import com.motorbikesshop.model.dtos.AddAnnouncementDTO;
import com.motorbikesshop.model.entity.Address;
import com.motorbikesshop.model.entity.Announcement;
import com.motorbikesshop.model.entity.City;
import com.motorbikesshop.model.entity.UserEntity;
import com.motorbikesshop.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    private final UserRepository userRepository;

    private final BrandRepository brandRepository;

    private final CityRepository cityRepository;

    private final AddressRepository addressRepository;

    private final ModelMapper modelMapper;

    public AnnouncementService(AnnouncementRepository announcementRepository, UserRepository userRepository,
                               BrandRepository brandRepository, CityRepository cityRepository,
                               AddressRepository addressRepository, ModelMapper modelMapper) {
        this.announcementRepository = announcementRepository;
        this.userRepository = userRepository;
        this.brandRepository = brandRepository;
        this.cityRepository = cityRepository;
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    public void createAnnouncement(AddAnnouncementDTO announcementDTO, Principal principal) {
        Optional<UserEntity> seller = this.userRepository.findByEmail(principal.getName());
        City city = initializerCIty(announcementDTO);
        Address address = initializerAddresses(announcementDTO, city);
        initializerAnnouncement(announcementDTO, seller, address);
    }

    private void initializerAnnouncement(AddAnnouncementDTO announcementDTO, Optional<UserEntity> seller, Address address) {
        Announcement announcement = this.modelMapper.map(announcementDTO, Announcement.class);
        announcement.setCreated(LocalDateTime.now());
        announcement.setAddress(address);
        announcement.setSeller(seller.get());
        this.announcementRepository.save(announcement);
    }

    private Address initializerAddresses(AddAnnouncementDTO announcementDTO, City city) {
        if (this.addressRepository.findByStreetAndStreetNumber
                (announcementDTO.getStreet(), announcementDTO.getStreetNumber()).isPresent()) {
            return this.addressRepository.findByStreetAndStreetNumber
                    (announcementDTO.getStreet(), announcementDTO.getStreetNumber()).get();
        }
        Address address = new Address();
        address.setCity(city);
        address.setStreet(announcementDTO.getStreet());
        address.setStreetNumber(announcementDTO.getStreetNumber());
        this.addressRepository.save(address);
        return address;
    }

    private City initializerCIty(AddAnnouncementDTO announcementDTO) {
        if (this.cityRepository.findByName(announcementDTO.getCity()).isPresent()) {
            return this.cityRepository.findByName(announcementDTO.getCity()).get();
        }
        City city = new City();
        city.setName(announcementDTO.getCity());
        city.setPostCode(announcementDTO.getPostCode());
        this.cityRepository.save(city);
        return city;
    }
}
