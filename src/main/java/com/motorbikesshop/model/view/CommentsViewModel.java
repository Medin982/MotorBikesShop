package com.motorbikesshop.model.view;

public class CommentsViewModel {

    private String id;

    private String author;

    private String message;

    private String created;

    public CommentsViewModel() {
    }

    public CommentsViewModel(String id, String author, String message, String created) {
        this.id = id;
        this.author = author;
        this.message = message;
        this.created = created;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
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
