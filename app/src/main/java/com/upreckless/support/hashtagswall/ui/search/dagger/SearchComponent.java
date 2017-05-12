package com.upreckless.support.hashtagswall.ui.search.dagger;

import com.upreckless.support.hashtagswall.ui.search.Search;

import dagger.Subcomponent;

/**
 * Created by @mistreckless on 11.05.2017. !
 */
@SearchScope
@Subcomponent(modules = SearchModule.class)
public interface SearchComponent {
    void inject(Search search);
}
