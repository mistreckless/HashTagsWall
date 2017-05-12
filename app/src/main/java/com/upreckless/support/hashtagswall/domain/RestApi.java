package com.upreckless.support.hashtagswall.domain;

import com.upreckless.support.hashtagswall.domain.data.Post;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by @mistreckless on 11.05.2017. !
 */
public interface RestApi {
    Observable<List<Post>> getPosts();
}
