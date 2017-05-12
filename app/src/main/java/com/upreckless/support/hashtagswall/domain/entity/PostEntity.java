package com.upreckless.support.hashtagswall.domain.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by @mistreckless on 11.05.2017. !
 */

public class PostEntity extends RealmObject {
    @PrimaryKey
    private int id;
    private String authorName;
    private String authorThumb;
    private String title;
    private String text;
    private long date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorThumb() {
        return authorThumb;
    }

    public void setAuthorThumb(String authorThumb) {
        this.authorThumb = authorThumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
