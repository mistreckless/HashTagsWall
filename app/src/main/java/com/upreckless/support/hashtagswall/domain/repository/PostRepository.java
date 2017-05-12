package com.upreckless.support.hashtagswall.domain.repository;

import com.upreckless.support.hashtagswall.domain.data.Post;
import com.upreckless.support.hashtagswall.domain.entity.PostEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by @mistreckless on 11.05.2017. !
 */
public interface PostRepository {
    Observable<List<Post>> getPostsFromNetwork();

    void savePosts(List<Post> posts);

    List<PostEntity> getPostsFromCache();

    List<PostEntity> getPostsByTag(String tag);
}
