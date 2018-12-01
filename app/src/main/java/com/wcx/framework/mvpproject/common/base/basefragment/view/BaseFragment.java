package com.wcx.framework.mvpproject.common.base.basefragment.view;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wcx.framework.mvpproject.common.base.basefragment.presenter.BaseFragmentPresenter;
import com.wcx.framework.mvpproject.common.utils.MVPInstantiationUtils;

/**
 * @author wangchenxing
 * @data 30/11/2018 9:12 AM
 */
public abstract class BaseFragment<T extends BaseFragmentPresenter> extends Fragment {
    public T presenter;
    public Context context;
    LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = MVPInstantiationUtils.getInstantiation(this, MVPInstantiationUtils.FIRSTGENERICITY);
        presenter.bindViewAndModel(this);
        getLifecycle().addObserver(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }

    public abstract View initView();
}
