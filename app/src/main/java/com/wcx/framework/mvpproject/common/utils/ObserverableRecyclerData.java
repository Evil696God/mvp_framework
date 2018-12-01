package com.wcx.framework.mvpproject.common.utils;

import com.wcx.framework.mvpproject.common.base.baserecyclerfragment.recyclerinterface.RecyclerAsyncDataObserverable;
import com.wcx.framework.mvpproject.common.base.baserecyclerfragment.recyclerinterface.RecyclerViewNotifyListener;

import java.util.ArrayList;

/**
 * @author wangchenxing
 * @data 30/11/2018 4:49 PM
 * @description 列表数据更改被观察者
 */
public class ObserverableRecyclerData<T> implements RecyclerAsyncDataObserverable<T> {

    public ObserverableRecyclerData(RecyclerViewNotifyListener recyclerViewNotifyListener) {
        this.recyclerViewNotifyListener = recyclerViewNotifyListener;
    }

    private ArrayList<T> asyncData = new ArrayList<T>();
    private RecyclerViewNotifyListener recyclerViewNotifyListener;

    @Override
    public void synchronizeData(ArrayList<T> asyncData) {
        this.asyncData = asyncData;
        notifyObserver();
    }

    public ArrayList<T> getAsyncData() {
        return asyncData;
    }

    @Override
    public void notifyObserver() {
        recyclerViewNotifyListener.notifyUI();
    }

    public void setRecyclerViewNotifyListener(RecyclerViewNotifyListener recyclerViewNotifyListener) {
        this.recyclerViewNotifyListener = recyclerViewNotifyListener;
    }
}
