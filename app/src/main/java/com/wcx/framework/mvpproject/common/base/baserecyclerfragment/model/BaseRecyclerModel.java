package com.wcx.framework.mvpproject.common.base.baserecyclerfragment.model;

import com.wcx.framework.mvpproject.common.base.baserecyclerfragment.presenter.BaseRecyclerPresenter;

/**
 * @author wangchenxing
 * @data 30/11/2018 9:12 AM
 */
public class BaseRecyclerModel<T extends BaseRecyclerPresenter> {
    public T presenter;

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }
}
