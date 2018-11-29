package com.wcx.framework.mvpproject.component.base.baseview;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.wcx.framework.mvpproject.component.base.basepresenter.BasePresenter;
import com.wcx.framework.mvpproject.component.utils.MVPInstantiationUtils;

public abstract class BaseActivity<T extends BasePresenter> extends Activity implements LifecycleOwner {
    public T presenter;
    LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = MVPInstantiationUtils.getInstantiation(this, MVPInstantiationUtils.FIRSTGENERICITY);
        presenter.bindViewAndModel(this);
        getLifecycle().addObserver(presenter);

        setContentView(getLayoutResourceID());
        initView();
        loadData();
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }

    public abstract int getLayoutResourceID();

    public abstract void initView();

    public abstract void loadData();
}
