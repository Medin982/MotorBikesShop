package com.motorbikesshop.repository;

import com.motorbikesshop.model.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImagesRepository extends JpaRepository<Images, String> {

    Optional<Images> findFirstByAnnouncementId(String id);
}
