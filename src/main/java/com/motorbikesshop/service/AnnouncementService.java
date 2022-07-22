package com.motorbikesshop.service;

import com.motorbikesshop.model.dtos.AddAnnouncementDTO;
import com.motorbikesshop.model.entity.*;
import com.motorbikesshop.model.view.AnnouncementViewModel;
import com.motorbikesshop.model.view.ImagesViewModel;
import com.motorbikesshop.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final AddressService addressService;
    private final CityService cityService;
    private final ImagesService imagesService;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public AnnouncementService(AnnouncementRepository announcementRepository, AddressService addressService,
                               CityService cityService, ImagesService imagesService,
                               UserRepository userRepository, ModelMapper modelMapper) {
        this.announcementRepository = announcementRepository;
        this.addressService = addressService;
        this.cityService = cityService;
        this.imagesService = imagesService;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void createAnnouncement(AddAnnouncementDTO announcementDTO, Principal principal,
                                   MultipartFile multipartFile) throws IOException {
        Optional<UserEntity> seller = this.userRepository.findByEmail(principal.getName());
        City city = this.cityService.createCity(announcementDTO.getCity(), announcementDTO.getPostCode());
        Address address = this.addressService.createAddresses(announcementDTO.getStreet(), announcementDTO.getStreetNumber(), city);
        Announcement announcement = initializerAnnouncement(announcementDTO, seller, address);
        this.imagesService.createImages(multipartFile, announcement);
    }

    private Announcement initializerAnnouncement(AddAnnouncementDTO announcementDTO, Optional<UserEntity> seller,
                                         Address address) {
        Announcement announcement = this.modelMapper.map(announcementDTO, Announcement.class);
        announcement.setCreated(LocalDateTime.now());
        announcement.setAddress(address);
        announcement.setSeller(seller.get());
        return this.announcementRepository.save(announcement);
    }





    public List<AnnouncementViewModel> getAll() {
        return this.announcementRepository.
                findAll().
                stream().
                map(announcement -> this.modelMapper.map(announcement, AnnouncementViewModel.class)).
                collect(Collectors.toList());
    }
}
