package com.wcx.framework.mvpproject.common.base.baserecyclerfragment.view;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wcx.framework.mvpproject.common.base.baserecyclerfragment.presenter.BaseRecyclerPresenter;
import com.wcx.framework.mvpproject.common.utils.MVPInstantiationUtils;

import java.util.ArrayList;

/**
 * @author wangchenxing
 * @data 30/11/2018 9:12 AM
 */
public abstract class BaseRecyclerFragment<T extends BaseRecyclerPresenter> extends Fragment {
    public T presenter;
    private LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
    public BaseRecyclerView recyclerView;
    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        presenter = MVPInstantiationUtils.getInstantiation(this, MVPInstantiationUtils.FIRSTGENERICITY);
        presenter.bindViewAndModel(this);
        getLifecycle().addObserver(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return recyclerView;
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }

    private void initView() {
        if (recyclerView == null) {
            recyclerView = new BaseRecyclerView(context);
        }
    }

    public abstract void setRecyclerViewAdapter(ArrayList asyncData);

    public void notifyRecyclerView(ArrayList asyncData) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            setRecyclerViewAdapter(asyncData);
        } else {
            adapter.notifyDataSetChanged();
        }
    }
}
