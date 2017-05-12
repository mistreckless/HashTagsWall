package com.upreckless.support.hashtagswall.ui;

/**
 * Created by @mistreckless on 11.05.2017. !
 */

public abstract class BasePresenter<V,R> {
    private V view;
    private R router;

    public abstract void onStart();

    public abstract void onDestroy();

    public V getView() {
        return view;
    }

    public void setView(V view) {
        this.view = view;
    }

    public R getRouter() {
        return router;
    }

    public void setRouter(R router) {
        this.router = router;
    }
}
