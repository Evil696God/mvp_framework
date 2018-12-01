package com.wcx.framework.mvpproject.common.base.baserecyclerfragment.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * @author wangchenxing
 * @data 30/11/2018 10:34 AM
 */
public class BaseRecyclerView extends RecyclerView {
    private Context context;

    public BaseRecyclerView(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    {
        setLayoutManager(new LinearLayoutManager(
                context,
                LinearLayout.VERTICAL,
                false
        ));
        setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));

        ItemAnimator itemAnimator = getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN && this.getScrollState() == RecyclerView.SCROLL_STATE_IDLE) {
            this.stopScroll();
        }
        return super.onInterceptTouchEvent(event);
    }

}
