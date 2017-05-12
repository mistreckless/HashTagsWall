package com.upreckless.support.hashtagswall.app;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by @mistreckless on 11.05.2017. !
 */
@Singleton
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context){
        this.context=context;
    }

    @Singleton
    @Provides
    Context provideContext(){
        return context;
    }
}
