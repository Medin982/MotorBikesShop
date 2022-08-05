package com.motorbikesshop.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "comments")
public class Comments extends BaseEntity{

    @Column(nullable = false, columnDefinition = "TEXT")
    private String comment;

    @Column(nullable = false)
    private LocalDateTime created;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private Discussion discussions;

    public Discussion getDiscussions() {
        return discussions;
    }

    public void setDiscussions(Discussion discussions) {
        this.discussions = discussions;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }
}
