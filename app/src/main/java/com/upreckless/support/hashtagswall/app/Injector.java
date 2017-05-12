package com.upreckless.support.hashtagswall.app;

import com.upreckless.support.hashtagswall.ui.lauch.dagger.MainActivityComponent;
import com.upreckless.support.hashtagswall.ui.lauch.dagger.MainActivityModule;
import com.upreckless.support.hashtagswall.ui.search.dagger.SearchComponent;
import com.upreckless.support.hashtagswall.ui.search.dagger.SearchModule;
import com.upreckless.support.hashtagswall.ui.wall.dagger.WallComponent;
import com.upreckless.support.hashtagswall.ui.wall.dagger.WallModule;

/**
 * Created by @mistreckless on 11.05.2017. !
 */

public class Injector {
    private static Injector instance;
    private MainActivityComponent mainActivityComponent;
    private WallComponent wallComponent;
    private SearchComponent searchComponent;

    private Injector() {
    }

    public static Injector newInstance() {
        if (instance == null)
            instance = new Injector();
        return instance;
    }

    public MainActivityComponent plusMainComponent(MainActivityModule module){
        if (mainActivityComponent==null) mainActivityComponent=App.getAppComponent().plus(module);
        return mainActivityComponent;
    }

    public void clearMainActivityComponent(){
        mainActivityComponent=null;
    }

    public WallComponent plusWallComponent(WallModule wallModule){
        if (wallComponent==null) wallComponent=mainActivityComponent.plus(wallModule);
        return wallComponent;
    }

    public void clearWallComponent(){
        wallComponent=null;
    }

    public SearchComponent plusSearchComponent(SearchModule searchModule) {
        if (searchComponent == null) searchComponent = mainActivityComponent.plus(searchModule);
        return searchComponent;
    }
    public void clearSearchComponent(){
        searchComponent=null;
    }
}
