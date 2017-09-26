package com.codetrack.bscitians.model;

public class Subjects {
    private String title, thumbnailUrl,description,id , link;

    public Subjects() {
    }

    public Subjects(String name, String thumbnailUrl, String description, String id, String link) {
        this.title = name;
        this.thumbnailUrl = thumbnailUrl;
        this.description = description;
        this.id = id;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}