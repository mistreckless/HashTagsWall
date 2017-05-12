package com.upreckless.support.hashtagswall.domain.repository;

import android.util.Log;

import com.upreckless.support.hashtagswall.domain.RestApi;
import com.upreckless.support.hashtagswall.domain.data.Post;
import com.upreckless.support.hashtagswall.domain.entity.PostEntity;
import com.upreckless.support.hashtagswall.domain.entity.TagEntity;
import com.upreckless.support.hashtagswall.util.Helper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by @mistreckless on 11.05.2017. !
 */

public class PostRepositoryImpl implements PostRepository {
    private RestApi restApi;
    private Realm realm;

    @Inject
    public PostRepositoryImpl(RestApi restApi, Realm realm) {
        this.restApi = restApi;
        this.realm = realm;
    }

    @Override
    public Observable<List<Post>> getPostsFromNetwork() {
        return restApi.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void savePosts(List<Post> posts) {
        for (Post post :
                posts) {
            realm.executeTransaction(realm1 -> {
                PostEntity postEntity = realm1.createObject(PostEntity.class, post.getId());
                postEntity.setTitle(post.getTitle());
                postEntity.setAuthorName(post.getAuthorName());
                postEntity.setAuthorThumb(post.getAuthorThumbRef());
                postEntity.setDate(post.getTime());
                postEntity.setText(post.getText());
            });
            for (String word :
                    Helper.getTagsFromText(post.getText())) {
                realm.executeTransaction(realm1 -> {
                    TagEntity tagEntity = realm1.where(TagEntity.class).equalTo("tag", word).findFirst();
                    if (tagEntity == null)
                        tagEntity = realm1.createObject(TagEntity.class, word);
                    PostEntity postEntity = realm1.where(PostEntity.class).equalTo("id", post.getId()).findFirst();
                    tagEntity.getPostEntities().add(postEntity);
                });
            }

        }
        RealmResults<TagEntity> tagEntities = realm.where(TagEntity.class).findAll();
        for (TagEntity tagEntity :
                tagEntities) {
            Log.e(tagEntity.getTag(), String.valueOf(tagEntity.getPostEntities().size()));
        }
    }

    @Override
    public List<PostEntity> getPostsFromCache() {
        return realm.where(PostEntity.class).findAll();
    }

    @Override
    public List<PostEntity> getPostsByTag(String tag) {
        Log.e("thead",Thread.currentThread().getName());
        TagEntity tagEntity = realm.where(TagEntity.class).equalTo("tag", tag).findFirst();
        return tagEntity == null ? null : tagEntity.getPostEntities();
    }
}
