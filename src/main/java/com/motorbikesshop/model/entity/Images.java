package com.motorbikesshop.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Images extends BaseEntity{

    @Column(nullable = false, length = 64)
    private String url;

    @ManyToOne
    private Announcement announcement;

    @Transient
    public String getUrl() {
        if (url == null || getId() == null) return null;
        return "/announcement-photos/" + getId() + "/" + url;
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
