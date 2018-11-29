package com.wcx.framework.mvpproject.component.base.basemodel;

import com.wcx.framework.mvpproject.component.base.basepresenter.BaseRecyclerViewFragmentPresenter;

public class BaseRecyclerViewFragmentModel<T extends BaseRecyclerViewFragmentPresenter> {
    public T presenter;

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }
}
