package com.upreckless.support.hashtagswall.ui.lauch;

import android.os.Bundle;

import com.upreckless.support.hashtagswall.app.Injector;
import com.upreckless.support.hashtagswall.ui.BasePresenter;
import com.upreckless.support.hashtagswall.ui.lauch.dagger.MainActivityScope;

import javax.inject.Inject;

/**
 * Created by @mistreckless on 11.05.2017. !
 */
@MainActivityScope
class MainActivityPresenter extends BasePresenter<MainActivityView,MainActivityRouter> {
    @Inject
    MainActivityPresenter(){}

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {
        Injector.newInstance().clearMainActivityComponent();
    }

    public void create(Bundle savedInstanceState) {
        if (savedInstanceState==null)
            getView().init();
    }
}
