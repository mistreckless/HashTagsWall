package com.upreckless.support.hashtagswall.domain;

import com.upreckless.support.hashtagswall.domain.data.Post;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by @mistreckless on 11.05.2017. !
 */

public class RestApiMock implements RestApi {
    @Override
    public Observable<List<Post>> getPosts() {
        List<Post> posts=new ArrayList<>();
        posts.add(new Post(1,"СуперВася","//","Какой большой заголовок",System.currentTimeMillis(),"Много какого-то #aga текста, #prostotak просто вода, #vape можно не читать. "));
        posts.add(new Post(2,"СуперВася","//","Еще один заголовок",System.currentTimeMillis(),"Много какого-то #aga текста, #etotrabotat'nebudet просто вода, можно #prostotak не читать. "));
        posts.add(new Post(3,"СуперВася","//","Привет",System.currentTimeMillis(),"Много какого-то #aga текста, просто вода, #vape можно не читать. #prostotak "));
        posts.add(new Post(4,"СуперВася","//","И еще",System.currentTimeMillis(),"Много какого-то #aga текста, просто вода, можно не читать. "));
        return Observable.just(posts);
    }
}
