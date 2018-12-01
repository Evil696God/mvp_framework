package com.wcx.framework.mvpproject.common.base.baseactivity.view;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import com.wcx.framework.mvpproject.common.base.baseactivity.presenter.BasePresenter;
import com.wcx.framework.mvpproject.common.utils.MVPInstantiationUtils;

/**
 * @author wangchenxing
 * @data 30/11/2018 9:12 AM
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements LifecycleOwner {
    public T presenter;
    LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = MVPInstantiationUtils.getInstantiation(this, MVPInstantiationUtils.FIRSTGENERICITY);
        presenter.bindViewAndModel(this);
        getLifecycle().addObserver(presenter);

        setContentView(getLayoutResourceID());
        initView(savedInstanceState);
        loadData();
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }

    public abstract int getLayoutResourceID();

    public abstract void initView(Bundle savedInstanceState);

    public abstract void loadData();
}
