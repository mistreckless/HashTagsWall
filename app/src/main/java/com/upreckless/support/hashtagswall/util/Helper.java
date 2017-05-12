package com.upreckless.support.hashtagswall.util;

import android.util.Log;

import com.upreckless.support.hashtagswall.domain.data.Post;
import com.upreckless.support.hashtagswall.domain.entity.PostEntity;
import com.upreckless.support.hashtagswall.ui.model.PostModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by @mistreckless on 12.05.2017. !
 */

public class Helper {
    public static List<PostModel> convertPostsToPostModels(List<Post> posts) {
        List<PostModel> postModels = new ArrayList<>(posts.size());
        for (Post post :
                posts) {
            postModels.add(convertPostToPostModel(post));
        }
        return postModels;
    }

    public static PostModel convertPostToPostModel(Post post) {
        PostModel postModel = new PostModel();
        postModel.setAuthorName(post.getAuthorName());
        postModel.setAuthorThumb(post.getAuthorThumbRef());
        postModel.setDate(post.getTime());
        postModel.setTitle(post.getTitle());
        postModel.setText(Arrays.asList(post.getText().split(" ")));
        return postModel;
    }

    public static List<String> getTagsFromText(String text) {
        List<String> lines = new ArrayList<>();
        for (String word :
                text.split(" ")) {
            if (!word.isEmpty() && word.length() > 1 &&word.charAt(0)=='#' && word.substring(1).matches("\\w+") && !lines.contains(word))
                lines.add(word);
        }
        return lines;
    }

    public static List<PostModel> convertPostEntitiesToPostModels(List<PostEntity> postEntities){

        List<PostModel> postModels=new ArrayList<>(postEntities.size());
        for (PostEntity postEntity :
                postEntities) {
            postModels.add(convertPostEntityToPostModel(postEntity));
        }
        return postModels;
    }
    public static PostModel convertPostEntityToPostModel(PostEntity postEntity){
        PostModel postModel=new PostModel();
        postModel.setAuthorName(postEntity.getAuthorName());
        postModel.setDate(postEntity.getDate());
        postModel.setText(Arrays.asList(postEntity.getText().split(" ")));
        postModel.setTitle(postEntity.getTitle());
        postModel.setAuthorThumb(postEntity.getAuthorThumb());
        return postModel;
    }
}
