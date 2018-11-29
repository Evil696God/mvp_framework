package com.wcx.framework.mvpproject.component.base.basepresenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import com.wcx.framework.mvpproject.component.base.basemodel.BaseFragmentModel;
import com.wcx.framework.mvpproject.component.base.baseview.BaseFragment;
import com.wcx.framework.mvpproject.component.utils.MVPInstantiationUtils;
import io.reactivex.disposables.Disposable;
import org.jetbrains.annotations.NotNull;

public class BaseFragmentPresenter<T extends BaseFragmentModel, E extends BaseFragment> implements LifecycleObserver {
    public T model;
    public E context;
    public Disposable disposable;

    public void bindViewAndModel(E context) {
        this.context = context;
        model = MVPInstantiationUtils.getInstantiation(this, MVPInstantiationUtils.FIRSTGENERICITY);
        model.setPresenter(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onDestroy(@NotNull LifecycleOwner owner) {
        if (disposable != null && disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
