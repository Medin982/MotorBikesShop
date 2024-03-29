package com.motorbikesshop.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Images extends BaseEntity {

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String publicId;

    @ManyToOne
    private Announcement announcement;

    @Transient
    public String getUrl() {
        return url;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }
}
