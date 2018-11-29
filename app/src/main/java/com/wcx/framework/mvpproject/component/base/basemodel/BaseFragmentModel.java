package com.wcx.framework.mvpproject.component.base.basemodel;

import com.wcx.framework.mvpproject.component.base.basepresenter.BaseFragmentPresenter;

public class BaseFragmentModel<T extends BaseFragmentPresenter> {
    public T presenter;

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }
}
