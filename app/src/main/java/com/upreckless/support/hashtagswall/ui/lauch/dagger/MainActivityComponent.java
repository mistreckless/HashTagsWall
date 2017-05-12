package com.upreckless.support.hashtagswall.ui.lauch.dagger;

import com.upreckless.support.hashtagswall.ui.lauch.MainActivity;
import com.upreckless.support.hashtagswall.ui.search.dagger.SearchComponent;
import com.upreckless.support.hashtagswall.ui.search.dagger.SearchModule;
import com.upreckless.support.hashtagswall.ui.wall.dagger.WallComponent;
import com.upreckless.support.hashtagswall.ui.wall.dagger.WallModule;

import dagger.Subcomponent;

/**
 * Created by @mistreckless on 11.05.2017. !
 */
@MainActivityScope
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
    WallComponent plus(WallModule wallModule);
    SearchComponent plus(SearchModule searchModule);
}
