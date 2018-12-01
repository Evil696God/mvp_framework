package com.wcx.framework.mvpproject.common.base.baseactivity.model;

import com.wcx.framework.mvpproject.common.base.baseactivity.presenter.BasePresenter;

/**
 * @author wangchenxing
 * @data 30/11/2018 9:12 AM
 */
public class BaseModel<T extends BasePresenter> {

    public T presenter;

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }
}
