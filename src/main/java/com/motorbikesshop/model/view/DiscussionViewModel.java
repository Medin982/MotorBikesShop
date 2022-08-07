package com.motorbikesshop.model.view;

public class DiscussionViewModel {

    private String id;

    private String name;

    private String description;

    private UserViewModel creator;

    private String created;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public UserViewModel getCreator() {
        return creator;
    }

    public void setCreator(UserViewModel creator) {
        this.creator = creator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
