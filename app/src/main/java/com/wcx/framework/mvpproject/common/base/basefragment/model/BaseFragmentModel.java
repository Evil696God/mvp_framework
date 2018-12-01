package com.wcx.framework.mvpproject.common.base.basefragment.model;

import com.wcx.framework.mvpproject.common.base.basefragment.presenter.BaseFragmentPresenter;

/**
 * @author wangchenxing
 * @data 30/11/2018 9:12 AM
 */
public class BaseFragmentModel<T extends BaseFragmentPresenter> {
    public T presenter;

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }
}
