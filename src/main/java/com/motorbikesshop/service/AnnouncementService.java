package com.motorbikesshop.service;

import com.motorbikesshop.model.dtos.AddAnnouncementDTO;
import com.motorbikesshop.model.dtos.SearchAnnouncementDTO;
import com.motorbikesshop.model.entity.*;
import com.motorbikesshop.model.view.AnnouncementDetailsViewModel;
import com.motorbikesshop.model.view.AnnouncementViewModel;
import com.motorbikesshop.repository.*;
import com.motorbikesshop.repository.specification.AnnouncementSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public AnnouncementService(AnnouncementRepository announcementRepository, AddressService addressService,
                               CityService cityService, ImagesService imagesService,
                               ModelRepository modelRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.announcementRepository = announcementRepository;
        this.addressService = addressService;
        this.cityService = cityService;
        this.imagesService = imagesService;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void createAnnouncement(AddAnnouncementDTO announcementDTO, Principal principal) throws IOException {
        Optional<UserEntity> seller = this.userRepository.findByEmail(principal.getName());
        City city = this.cityService.createCity(announcementDTO.getCity(), announcementDTO.getPostCode());
        Address address = this.addressService.createAddresses(announcementDTO.getStreet(), announcementDTO.getStreetNumber(), city);
        Optional<Model> model = this.modelRepository.findById(announcementDTO.getModelId());
        Announcement announcement = initializerAnnouncement(announcementDTO, seller, address, model.get());
        this.imagesService.createImages(announcementDTO.getImages(), announcement);
    }

    private Announcement initializerAnnouncement(AddAnnouncementDTO announcementDTO, Optional<UserEntity> seller,
                                                 Address address, Model model) {
        Announcement announcement = this.modelMapper.map(announcementDTO, Announcement.class);
        announcement.setCreated(LocalDateTime.now());
        announcement.setModel(model);
        announcement.setAddress(address);
        announcement.setSeller(seller.get());
        return this.announcementRepository.save(announcement);
    }

    public List<AnnouncementViewModel> searchAnnouncements(SearchAnnouncementDTO dto) {
        return this.announcementRepository.findAll(new AnnouncementSpecification(dto)).
                stream()
                .map(announcement -> {
                    AnnouncementViewModel current = this.modelMapper.map(announcement, AnnouncementViewModel.class);
                    current.setImages(this.imagesService.getImage(announcement.getId()));
                    return current;
                }).collect(Collectors.toList());
    }

    public Page<AnnouncementViewModel> getAll(Pageable pageable) {
        return this.announcementRepository.
                findAll(pageable).
                map(announcement -> {
                    AnnouncementViewModel current = this.modelMapper.map(announcement, AnnouncementViewModel.class);
                    current.setImages(this.imagesService.getImage(announcement.getId()));
                    return current;
                });
    }

    public AnnouncementDetailsViewModel getAnnouncement(String id) {
        return this.announcementRepository.findById(id).
        map(announcement -> this.modelMapper.map(announcement, AnnouncementDetailsViewModel.class)).
                orElseThrow();
    }

    public List<AnnouncementViewModel> getLatest(LocalDateTime now) {
        return this.announcementRepository.
                findTop5ByCreatedLessThanOrderByCreatedDesc(now).
                stream().
                map(announcement -> {
                    AnnouncementViewModel current = this.modelMapper.map(announcement, AnnouncementViewModel.class);
                    current.setImages(this.imagesService.getImage(announcement.getId()));
                    return current;
                }).
                collect(Collectors.toList());
    }
}
