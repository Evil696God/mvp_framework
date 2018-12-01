package com.wcx.framework.mvpproject.common.base.basefragment.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import com.wcx.framework.mvpproject.common.base.basefragment.model.BaseFragmentModel;
import com.wcx.framework.mvpproject.common.base.basefragment.view.BaseFragment;
import com.wcx.framework.mvpproject.common.utils.MVPInstantiationUtils;
import io.reactivex.disposables.Disposable;
import org.jetbrains.annotations.NotNull;

/**
 * @author wangchenxing
 * @data 30/11/2018 9:12 AM
 */
public class BaseFragmentPresenter<T extends BaseFragmentModel, E extends BaseFragment> implements LifecycleObserver {
    public T model;
    public E context;
    public Disposable disposable;

    public void bindViewAndModel(E context) {
        this.context = context;
        model = MVPInstantiationUtils.getInstantiation(this, MVPInstantiationUtils.FIRSTGENERICITY);
        model.setPresenter(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected void onCreate(@NotNull LifecycleOwner owner) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onDestroy(@NotNull LifecycleOwner owner) {
        if (disposable != null && disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
