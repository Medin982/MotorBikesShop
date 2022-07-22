package com.motorbikesshop.service;

import com.motorbikesshop.Config.FileUploadUtilConfig;
import com.motorbikesshop.model.entity.Announcement;
import com.motorbikesshop.model.entity.Images;
import com.motorbikesshop.repository.ImagesRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
public class ImagesService {

    private final ImagesRepository imagesRepository;

    public ImagesService(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    public Images createImages(MultipartFile multipartFile, Announcement announcement) throws IOException {
        Images images = new Images();
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        images.setUrl(fileName);
        images.setAnnouncement(announcement);
        Images savedImage = this.imagesRepository.save(images);
        String uploadDir = "announcement-photos/" + savedImage.getId();
        FileUploadUtilConfig.saveFile(uploadDir, fileName, multipartFile);
        return images;
    }
}
