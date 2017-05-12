package com.upreckless.support.hashtagswall.ui.model;

import java.util.List;

/**
 * Created by @mistreckless on 12.05.2017. !
 */

public class PostModel {
    private String authorName;
    private String authorThumb;
    private long date;
    private String title;
    private List<String> text;

    public PostModel(){}

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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }
}
