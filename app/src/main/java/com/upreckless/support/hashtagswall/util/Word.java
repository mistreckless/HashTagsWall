package com.upreckless.support.hashtagswall.util;

import android.support.annotation.IntegerRes;

/**
 * Created by @mistreckless on 11.05.2017. !
 */

public class Word {
    private String text;
    private @IntegerRes int color;

    public Word(String text, int color) {
        this.text = text;
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public int getColor() {
        return color;
    }
}
