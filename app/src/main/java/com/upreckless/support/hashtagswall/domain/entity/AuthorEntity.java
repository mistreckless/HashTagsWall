package com.upreckless.support.hashtagswall.domain.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by @mistreckless on 12.05.2017. !
 */

public class AuthorEntity extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private String photoRef;

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
