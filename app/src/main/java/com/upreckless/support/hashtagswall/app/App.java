package com.upreckless.support.hashtagswall.app;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.upreckless.support.hashtagswall.domain.DomainModule;

import io.realm.Realm;

/**
 * Created by @mistreckless on 11.05.2017. !
 */

public class App extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        appComponent=buildComponent();
        appComponent.inject(this);
        Realm.init(this);
    }
    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .domainModule(new DomainModule())
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
