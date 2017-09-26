package com.codetrack.bscitians.model;


import android.content.Context;

public class Papers {
    private String title , link,year;

    public Papers() {
    }

    public Papers(String name, String link , String year) {
        this.title = name;
        this.link = link;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void getContextppr(Context context){}



    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}