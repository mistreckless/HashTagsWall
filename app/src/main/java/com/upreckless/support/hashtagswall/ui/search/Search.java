package com.upreckless.support.hashtagswall.ui.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.upreckless.support.hashtagswall.R;
import com.upreckless.support.hashtagswall.app.Injector;
import com.upreckless.support.hashtagswall.ui.BaseFragment;
import com.upreckless.support.hashtagswall.ui.BasePresenter;
import com.upreckless.support.hashtagswall.ui.Layout;
import com.upreckless.support.hashtagswall.ui.adapter.PostAdapter;
import com.upreckless.support.hashtagswall.ui.model.PostModel;
import com.upreckless.support.hashtagswall.ui.search.dagger.SearchModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by @mistreckless on 11.05.2017. !
 */
@Layout(id=R.layout.fragment_search)
public class Search extends BaseFragment implements SearchView {

    @Inject
    SearchPresenter presenter;
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    private PostAdapter postAdapter;

    public static Search newInstance(String tag){
        Search search=new Search();
        Bundle args=new Bundle();
        args.putString("tag",tag);
        search.setArguments(args);
        return search;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postAdapter=new PostAdapter(getContext(),presenter::wordClicked);
        presenter.setTag(getArguments().getString("tag"));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(postAdapter);
    }

    @Override
    protected Toolbar getToolbar() {
        toolbar.setTitle(getArguments().getString("tag"));
        return toolbar;
    }

    @Override
    protected Object getRouter() {
        return getActivity();
    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void inject() {
        Injector.newInstance().plusSearchComponent(new SearchModule()).inject(this);
    }

    @Override
    protected boolean isAddedToBackStack() {
        return true;
    }

    @Override
    public void setPosts(List<PostModel> postModels) {
        postAdapter.setPostModels(postModels);
        postAdapter.notifyDataSetChanged();
    }
}
