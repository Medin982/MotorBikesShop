package com.motorbikesshop.service;

import com.motorbikesshop.Config.FileUploadUtilConfig;
import com.motorbikesshop.model.dtos.AddAnnouncementDTO;
import com.motorbikesshop.model.entity.*;
import com.motorbikesshop.model.view.AnnouncementViewModel;
import com.motorbikesshop.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final UserRepository userRepository;
    private final BrandRepository brandRepository;
    private final CityRepository cityRepository;
    private final AddressRepository addressRepository;
    private final ImagesRepository imagesRepository;
    private final ModelMapper modelMapper;

    public AnnouncementService(AnnouncementRepository announcementRepository, UserRepository userRepository,
                               BrandRepository brandRepository, CityRepository cityRepository,
                               AddressRepository addressRepository, ImagesRepository imagesRepository, ModelMapper modelMapper) {
        this.announcementRepository = announcementRepository;
        this.userRepository = userRepository;
        this.brandRepository = brandRepository;
        this.cityRepository = cityRepository;
        this.addressRepository = addressRepository;
        this.imagesRepository = imagesRepository;
        this.modelMapper = modelMapper;
    }
//TODO: Need to optimize all methods
    public void createAnnouncement(AddAnnouncementDTO announcementDTO, Principal principal,
                                   MultipartFile multipartFile) throws IOException {
        Optional<UserEntity> seller = this.userRepository.findByEmail(principal.getName());
        City city = initializerCIty(announcementDTO);
        Address address = initializerAddresses(announcementDTO, city);
        Images images = new Images();
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        images.setUrl(fileName);
        images.setName("1");
        Images savedImage = this.imagesRepository.save(images);

        String uploadDir = "announcement-photos/" + savedImage.getId();

        FileUploadUtilConfig.saveFile(uploadDir, fileName, multipartFile);

        initializerAnnouncement(announcementDTO, seller, address, List.of(images));
    }

    private void initializerAnnouncement(AddAnnouncementDTO announcementDTO, Optional<UserEntity> seller,
                                         Address address, List<Images> images) {
        Announcement announcement = this.modelMapper.map(announcementDTO, Announcement.class);
        announcement.setCreated(LocalDateTime.now());
        announcement.setAddress(address);
        announcement.setSeller(seller.get());
        announcement.setImages(images);
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

    public List<AnnouncementViewModel> getAll() {
        //TODO: Find how to present image from dataBase in page
        return this.announcementRepository.
                findAll().
                stream().
                map(announcement -> this.modelMapper.map(announcement, AnnouncementViewModel.class)).
                collect(Collectors.toList());
    }
}
