package com.wcx.framework.mvpproject.component.base.baseview;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wcx.framework.mvpproject.component.base.basepresenter.BaseFragmentPresenter;
import com.wcx.framework.mvpproject.component.utils.MVPInstantiationUtils;

public abstract class BaseFragment<T extends BaseFragmentPresenter> extends Fragment {
    public T presenter;
    LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);

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
