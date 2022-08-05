package com.motorbikesshop.repository;

import com.motorbikesshop.model.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, String> {
}
