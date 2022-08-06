package com.motorbikesshop.repository;

import com.motorbikesshop.model.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, String> {
    List<Comments> findAllByDiscussionsId(String id);
}
