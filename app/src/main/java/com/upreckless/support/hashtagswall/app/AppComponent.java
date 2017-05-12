package com.upreckless.support.hashtagswall.app;

import com.upreckless.support.hashtagswall.domain.DomainModule;
import com.upreckless.support.hashtagswall.ui.lauch.dagger.MainActivityComponent;
import com.upreckless.support.hashtagswall.ui.lauch.dagger.MainActivityModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by @mistreckless on 11.05.2017. !
 */
@Singleton
@Component(modules = {AppModule.class, DomainModule.class})
public interface AppComponent {
    void inject(App app);
    MainActivityComponent plus(MainActivityModule module);
}
