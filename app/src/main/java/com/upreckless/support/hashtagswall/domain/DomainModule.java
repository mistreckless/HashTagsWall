package com.upreckless.support.hashtagswall.domain;

import com.upreckless.support.hashtagswall.domain.repository.PostRepository;
import com.upreckless.support.hashtagswall.domain.repository.PostRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by @mistreckless on 11.05.2017. !
 */
@Singleton
@Module
public class DomainModule {

    @Singleton
    @Provides
    RestApi provideRestApi(){
        return new RestApiMock();
    }

    @Singleton
    @Provides
    Realm provideRealm(){
        return Realm.getDefaultInstance();
    }

    @Singleton
    @Provides
    PostRepository providePostRepository(RestApi restApi, Realm realm){
        return new PostRepositoryImpl(restApi, realm);
    }
}
