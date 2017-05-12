package com.upreckless.support.hashtagswall.ui.search;

import android.util.Log;

import com.upreckless.support.hashtagswall.app.Injector;
import com.upreckless.support.hashtagswall.domain.repository.PostRepository;
import com.upreckless.support.hashtagswall.ui.BasePresenter;
import com.upreckless.support.hashtagswall.ui.lauch.MainActivityRouter;
import com.upreckless.support.hashtagswall.ui.search.dagger.SearchScope;
import com.upreckless.support.hashtagswall.util.Helper;
import com.upreckless.support.hashtagswall.util.Word;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by @mistreckless on 11.05.2017. !
 */
@SearchScope
class SearchPresenter extends BasePresenter<SearchView, MainActivityRouter> {
    private PostRepository postRepository;
    private Disposable disposable;
    private String tag;

    @Inject
    SearchPresenter(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void onStart() {
        if (disposable == null || disposable.isDisposed())
            disposable = Observable.just(postRepository.getPostsByTag(tag))
                    .map(Helper::convertPostEntitiesToPostModels)
                    .subscribe(getView()::setPosts);

    }

    @Override
    public void onDestroy() {
        if (disposable!=null)
            disposable.dispose();
        Injector.newInstance().clearSearchComponent();
    }


    void wordClicked(Word word) {
        String tag = word.getText();
        Log.e("word", tag);
        if (!tag.isEmpty() && tag.length() > 1 && tag.charAt(0) == '#' && tag.substring(1).matches("\\w+") && !tag.equals(this.tag))
            getRouter().navigateToSearch(tag);
    }

    void setTag(String tag) {
        this.tag = tag;
    }
}
