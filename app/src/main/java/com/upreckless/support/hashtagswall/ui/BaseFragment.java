package com.upreckless.support.hashtagswall.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.upreckless.support.hashtagswall.ui.lauch.MainActivity;

import java.lang.annotation.Annotation;

import butterknife.ButterKnife;

/**
 * Created by @mistreckless on 11.05.2017. !
 */
@SuppressWarnings("unchecked")
public abstract class BaseFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        setRetainInstance(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        getPresenter().setView(this);
        getPresenter().setRouter(getRouter());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Class cls=getClass();
        if (!cls.isAnnotationPresent(Layout.class)) return null;
        Annotation annotation=cls.getAnnotation(Layout.class);
        Layout layout=(Layout) annotation;
        View view=inflater.inflate(layout.id(),null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getPresenter().setView(this);
        getPresenter().setRouter(getRouter());
        if (getActivity() instanceof MainActivity)
            ((MainActivity) getActivity()).setToolbar(getToolbar(), isAddedToBackStack());
    }

    @Override
    public void onStart() {
        super.onStart();
        getPresenter().onStart();
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        getPresenter().setView(null);
        getPresenter().setRouter(null);
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenter().onDestroy();
    }

    protected boolean isAddedToBackStack() {
        return false;
    }

    protected abstract Toolbar getToolbar();

    protected abstract Object getRouter();

    protected abstract BasePresenter getPresenter();

    protected abstract void inject();
}
