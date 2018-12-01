package com.wcx.framework.mvpproject.common.base.baserecyclerfragment.view;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * @author wangchenxing
 * @data 1/12/2018 4:07 PM
 */
public abstract class BaseItemView<DataType> extends RelativeLayout {
    public Context context;

    public BaseItemView(Context context) {
        super(context);
        this.context = context;
        View view = initView(context);
        if (view != null) {
            this.addView(view);
        }
    }

    public abstract void bindCell(DataType data, int position);

    public abstract View initView(Context context);
}
