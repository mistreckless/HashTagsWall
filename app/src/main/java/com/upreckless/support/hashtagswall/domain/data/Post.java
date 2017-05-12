package com.upreckless.support.hashtagswall.domain.data;

/**
 * Created by @mistreckless on 11.05.2017. !
 */

public class Post {
    private int id;
    private String authorName;
    private String authorThumbRef;
    private String title;
    private long time;
    private String text;

    public Post(){}

    public Post(int id, String authorName, String authorThumbRef, String title, long time, String text) {
        this.id = id;
        this.authorName = authorName;
        this.authorThumbRef = authorThumbRef;
        this.title = title;
        this.time = time;
        this.text = text;
    }

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

    public String getAuthorThumbRef() {
        return authorThumbRef;
    }

    public void setAuthorThumbRef(String authorThumbRef) {
        this.authorThumbRef = authorThumbRef;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
