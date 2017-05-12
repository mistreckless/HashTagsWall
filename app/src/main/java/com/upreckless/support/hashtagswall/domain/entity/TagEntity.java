package com.upreckless.support.hashtagswall.domain.entity;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by @mistreckless on 11.05.2017. !
 */

public class TagEntity  extends RealmObject{

    @PrimaryKey
    private String tag;
    private RealmList<PostEntity> postEntities;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public RealmList<PostEntity> getPostEntities() {
        return postEntities;
    }

    public void setPostEntities(RealmList<PostEntity> postEntities) {
        this.postEntities = postEntities;
    }
}
