package com.upreckless.support.hashtagswall.ui.wall;

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
import com.upreckless.support.hashtagswall.ui.wall.dagger.WallModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by @mistreckless on 11.05.2017. !
 */
@Layout(id=R.layout.fragment_wall)
public class Wall extends BaseFragment implements WallView {

    @Inject
    WallPresenter presenter;

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    private PostAdapter postAdapter;

    public static Wall newInstance(){
        return new Wall();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postAdapter=new PostAdapter(getContext(),presenter::wordClicked);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(postAdapter);
    }

    @Override
    protected Toolbar getToolbar() {
        toolbar.setTitle("Wall");
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
        Injector.newInstance().plusWallComponent(new WallModule()).inject(this);
    }

    @Override
    public void setPostModels(List<PostModel> postModels) {
        postAdapter.setPostModels(postModels);
        postAdapter.notifyDataSetChanged();
    }
}
