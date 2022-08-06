package com.motorbikesshop.model.view;

import java.time.LocalDateTime;

public class CommentsViewModel {

    private String id;

    private String author;

    private String message;

    private LocalDateTime created;

    public CommentsViewModel() {
    }

    public CommentsViewModel(String id, String author, String message, LocalDateTime created) {
        this.id = id;
        this.author = author;
        this.message = message;
        this.created = created;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
