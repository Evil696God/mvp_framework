package com.wcx.framework.mvpproject.common.base.baserecyclerfragment.recyclerinterface;

import java.util.ArrayList;

/**
 * @author wangchenxing
 * @data 30/11/2018 1:40 PM
 * @description 被观察者接口
 */
public interface RecyclerAsyncDataObserverable<T> {
    void synchronizeData(ArrayList<T> asyncData);

    void notifyObserver();
}
