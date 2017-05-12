package com.upreckless.support.hashtagswall.domain.data;

/**
 * Created by @mistreckless on 12.05.2017. !
 */

public class Author {
    private int id;
    private String name;
    private String photoRef;

    public Author(){}

    public Author(int id, String name, String photoRef) {
        this.id = id;
        this.name = name;
        this.photoRef = photoRef;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoRef() {
        return photoRef;
    }

    public void setPhotoRef(String photoRef) {
        this.photoRef = photoRef;
    }
}
