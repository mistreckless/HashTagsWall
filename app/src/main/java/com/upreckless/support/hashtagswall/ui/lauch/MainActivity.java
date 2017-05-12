package com.upreckless.support.hashtagswall.ui.lauch;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.upreckless.support.hashtagswall.R;
import com.upreckless.support.hashtagswall.app.Injector;
import com.upreckless.support.hashtagswall.ui.lauch.dagger.MainActivityModule;
import com.upreckless.support.hashtagswall.ui.search.Search;
import com.upreckless.support.hashtagswall.ui.wall.Wall;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityView, MainActivityRouter {
    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Injector.newInstance().plusMainComponent(new MainActivityModule()).inject(this);
        presenter.setView(this);
        presenter.setRouter(this);
        presenter.create(savedInstanceState);
    }

    @Override
    public void init() {
        Wall wall = Wall.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, wall, wall.getTag())
                .commitAllowingStateLoss();
    }

    public void setToolbar(Toolbar toolbar, boolean isAddedToBackStack) {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null && isAddedToBackStack) {
            toolbar.setNavigationIcon(ContextCompat.getDrawable(this, android.support.design.R.drawable.abc_ic_ab_back_material));
            toolbar.setNavigationOnClickListener(v -> onBackPressed());
        }
    }

    @Override
    public void navigateToSearch(String tag) {
        Search search = Search.newInstance(tag);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, search, search.getTag())
                .addToBackStack(null)
                .commit();
    }


}
