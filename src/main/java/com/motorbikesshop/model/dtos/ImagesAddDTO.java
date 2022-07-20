package com.motorbikesshop.model.dtos;

import org.springframework.web.multipart.MultipartFile;

public class ImagesAddDTO {
    private MultipartFile imagesFile;

    public MultipartFile getImagesFile() {
        return imagesFile;
    }

    public void setImagesFile(MultipartFile imagesFile) {
        this.imagesFile = imagesFile;
    }
}
