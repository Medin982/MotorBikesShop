package com.motorbikesshop.service;

import com.motorbikesshop.model.entity.Announcement;
import com.motorbikesshop.model.entity.Images;
import com.motorbikesshop.model.view.ImagesViewModel;
import com.motorbikesshop.repository.ImagesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImagesService {

    private final ImagesRepository imagesRepository;

    private final ModelMapper modelMapper;

    private final CloudinaryService cloudinaryService;

    public ImagesService(ImagesRepository imagesRepository, ModelMapper modelMapper, CloudinaryService cloudinaryService) {
        this.imagesRepository = imagesRepository;
        this.modelMapper = modelMapper;
        this.cloudinaryService = cloudinaryService;
    }

    public void createImages(List<MultipartFile> multipartFile, Announcement announcement) {
//TODO:To save images in project directory.

//        List<Images> imagesList = multipartFile.
//                stream().
//                map(img -> {
//                    Images images = new Images();
//                    String fileName = StringUtils.cleanPath(Objects.requireNonNull(img.getOriginalFilename()));
//                    images.setUrl(fileName);
//                    images.setAnnouncement(announcement);
//                    Images savedImage = this.imagesRepository.save(images);
//                    String uploadDir = "src/main/resources/static/images/announcement-photos/" + savedImage.getId();
//                    try {
//                        FileUploadUtilConfig.saveFile(uploadDir, fileName, img);
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return images;
//                }).toList();

//TODO: To save image in cloudinary

        multipartFile.
               forEach(file -> {
                   try {
                       Images images = createImages(file);
                       images.setAnnouncement(announcement);
                       this.imagesRepository.save(images);
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }
               });
    }

    private Images createImages(MultipartFile multipartFile) throws IOException {
        CloudinaryImage upload = this.cloudinaryService.upload(multipartFile);
        Images images = new Images();
        images.setUrl(upload.getUrl());
        images.setPublicId(upload.getPublicId());
        return images;
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

    public void deleteById(String id) {
        this.imagesRepository.deleteById(id);
    }
}
