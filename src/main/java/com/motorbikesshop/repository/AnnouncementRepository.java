package com.motorbikesshop.repository;

import com.motorbikesshop.model.entity.Announcement;
import com.motorbikesshop.model.enums.ColorType;
import com.motorbikesshop.model.view.AnnouncementViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, String> {
    List<Announcement> findTop5ByCreatedLessThanOrderByCreatedDesc(LocalDateTime now);
}
