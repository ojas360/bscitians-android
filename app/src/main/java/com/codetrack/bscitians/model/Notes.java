package com.codetrack.bscitians.model;

public class Notes {
    private String title , link,year;

    public Notes() {
    }

    public Notes(String name, String link) {
        this.title = name;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


}