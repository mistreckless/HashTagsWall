package com.upreckless.support.hashtagswall.ui.wall.dagger;

import com.upreckless.support.hashtagswall.ui.wall.Wall;

import dagger.Subcomponent;

/**
 * Created by @mistreckless on 11.05.2017. !
 */
@WallScope
@Subcomponent(modules = WallModule.class)
public interface WallComponent {
    void inject(Wall wall);
}
