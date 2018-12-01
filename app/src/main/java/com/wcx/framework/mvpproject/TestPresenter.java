package com.wcx.framework.mvpproject;

import android.arch.lifecycle.LifecycleOwner;
import com.wcx.framework.mvpproject.common.base.baseactivity.presenter.BasePresenter;
import com.wcx.framework.mvpproject.common.network.Network;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TestPresenter extends BasePresenter<TestModel, MainActivity> {

    @Override
    protected void onCreate(@NotNull LifecycleOwner owner) {
        super.onCreate(owner);
    }

    public void getData() {
        disposable = Network.getApi()
                .search("可爱")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List>() {
                    @Override
                    public void accept(List list) throws Exception {

                    }
                });
    }
}
