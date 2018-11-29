package com.wcx.framework.mvpproject.component.base.basemodel;

import com.wcx.framework.mvpproject.component.base.basepresenter.BasePresenter;

public class BaseModel<T extends BasePresenter> {

    public T presenter;

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }
}
