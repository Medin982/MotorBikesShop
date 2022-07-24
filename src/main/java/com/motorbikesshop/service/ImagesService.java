package com.motorbikesshop.service;

import com.motorbikesshop.Config.FileUploadUtilConfig;
import com.motorbikesshop.model.entity.Announcement;
import com.motorbikesshop.model.entity.Images;
import com.motorbikesshop.model.view.ImagesViewModel;
import com.motorbikesshop.repository.ImagesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ImagesService {

    private final ImagesRepository imagesRepository;

    private final ModelMapper modelMapper;

    public ImagesService(ImagesRepository imagesRepository, ModelMapper modelMapper) {
        this.imagesRepository = imagesRepository;
        this.modelMapper = modelMapper;
    }

    public void createImages(List<MultipartFile> multipartFile, Announcement announcement) {

        List<Images> imagesList = multipartFile.
                stream().
                map(img -> {
                    Images images = new Images();
                    String fileName = StringUtils.cleanPath(Objects.requireNonNull(img.getOriginalFilename()));
                    images.setUrl(fileName);
                    images.setAnnouncement(announcement);
                    Images savedImage = this.imagesRepository.save(images);
                    String uploadDir = "announcement-photos/" + savedImage.getId();
                    try {
                        FileUploadUtilConfig.saveFile(uploadDir, fileName, img);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    return images;
                }).toList();
    }

    public List<ImagesViewModel> getAllImages() {
       return this.imagesRepository.findAll().
                stream().
                map(img -> this.modelMapper.map(img, ImagesViewModel.class)).
                toList();
    }

    public ImagesViewModel getImage(String id) {
        Optional<Images> firstByAnnouncementId = this.imagesRepository.
                findFirstByAnnouncementId(id);
        return this.modelMapper.map(firstByAnnouncementId.get(), ImagesViewModel.class);
    }
}
