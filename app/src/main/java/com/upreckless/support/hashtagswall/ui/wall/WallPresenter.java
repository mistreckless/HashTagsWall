package com.upreckless.support.hashtagswall.ui.wall;

import android.util.Log;

import com.upreckless.support.hashtagswall.app.Injector;
import com.upreckless.support.hashtagswall.domain.repository.PostRepository;
import com.upreckless.support.hashtagswall.ui.BasePresenter;
import com.upreckless.support.hashtagswall.ui.lauch.MainActivityRouter;
import com.upreckless.support.hashtagswall.ui.wall.dagger.WallScope;
import com.upreckless.support.hashtagswall.util.Helper;
import com.upreckless.support.hashtagswall.util.Word;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by @mistreckless on 11.05.2017. !
 */
@WallScope
public class WallPresenter extends BasePresenter<WallView, MainActivityRouter> {

    private PostRepository postRepository;
    private Disposable disposable;

    @Inject
    WallPresenter(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void onStart() {
        if (disposable == null || disposable.isDisposed())
            disposable = Observable.just(postRepository.getPostsFromCache())
                    .flatMap(postEntities -> postEntities.size() > 0 ?
                            Observable.just(Helper.convertPostEntitiesToPostModels(postEntities)) : postRepository.getPostsFromNetwork()
                            .doOnNext(postRepository::savePosts)
                            .map(Helper::convertPostsToPostModels)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread()))
                    .subscribe(getView()::setPostModels, Throwable::printStackTrace);

    }

    @Override
    public void onDestroy() {
        if (disposable!=null)
            disposable.dispose();
        Injector.newInstance().clearWallComponent();
    }


    void wordClicked(Word word) {
        String tag=word.getText();
                Log.e("word", tag);
        if (!tag.isEmpty() && tag.length()>1 && tag.charAt(0)=='#' && tag.substring(1).matches("\\w+"))
            getRouter().navigateToSearch(tag);
    }
}
