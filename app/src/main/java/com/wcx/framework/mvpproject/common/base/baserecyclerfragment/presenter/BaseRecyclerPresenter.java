package com.wcx.framework.mvpproject.common.base.baserecyclerfragment.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import com.wcx.framework.mvpproject.common.base.baserecyclerfragment.model.BaseRecyclerModel;
import com.wcx.framework.mvpproject.common.base.baserecyclerfragment.recyclerinterface.RecyclerViewNotifyListener;
import com.wcx.framework.mvpproject.common.base.baserecyclerfragment.view.BaseRecyclerFragment;
import com.wcx.framework.mvpproject.common.utils.MVPInstantiationUtils;
import com.wcx.framework.mvpproject.common.utils.ObserverableRecyclerData;
import io.reactivex.disposables.Disposable;
import org.jetbrains.annotations.NotNull;

/**
 * @author wangchenxing
 * @data 30/11/2018 9:12 AM
 */
public class BaseRecyclerPresenter<T extends BaseRecyclerModel, E extends BaseRecyclerFragment> implements LifecycleObserver {
    public T model;
    public E context;
    public Disposable disposable;
    public ObserverableRecyclerData<T> observerableRecyclerData = new ObserverableRecyclerData<T>(new RecyclerViewNotifyListener() {
        @Override
        public void notifyUI() {
            context.notifyRecyclerView(observerableRecyclerData.getAsyncData());
        }
    });

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
