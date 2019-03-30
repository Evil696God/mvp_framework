package com.wcx.framework.mvpproject.common.base.baserecyclerfragment.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * @author wangchenxing
 * @data 30/11/2018 10:34 AM
 */
public class BaseRecyclerView extends RecyclerView {
    private Context context;

    private RecyclerView.OnScrollListener pullDownOrUpRefreshData = new OnScrollListener() {
        boolean isUp = false;
        boolean isPullDown = false;

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            int lastPosition = -1;
            int firstPosition = -1;
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof GridLayoutManager) {
                    // 通过LayoutManager找到当前显示的最后的item的position
                    lastPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                    firstPosition = ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
                } else if (layoutManager instanceof LinearLayoutManager) {
                    lastPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    firstPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                    // 因为StaggeredGridLayoutManager的特殊性可能导致最后显示的item存在多个，所以这里取到的是一个数组
                    // 得到这个数组后再取到数组中position值最大的那个就是最后显示的position值了
                    int[] lastPositions = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                    ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(lastPositions);
                    lastPosition = findMax(lastPositions);
                }

                // 判断界面显示的最后item的position是否等于itemCount总数-1也就是最后一个item的position
                // 如果相等则说明已经滑动到最后了
                int num = recyclerView.getLayoutManager().getItemCount();
                if (lastPosition == num - 1 && isUp) {
                    if(context instanceof Activity) {
                        Activity activity = (Activity) BaseRecyclerView.this.context;
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                loadData();
                            }
                        });
                    }
                } else if (firstPosition == 0 && isPullDown) {
                    if(context instanceof Activity) {
                        Activity activity = (Activity) BaseRecyclerView.this.context;
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                refresh();
                            }
                        });
                    }
                }
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (dy > 0) {
                isUp = true;
            } else {
                isPullDown = true;
            }
        }

    };

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

        addOnScrollListener(pullDownOrUpRefreshData);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN && this.getScrollState() == RecyclerView.SCROLL_STATE_IDLE) {
            this.stopScroll();
        }
        return super.onInterceptTouchEvent(event);
    }

    //找到数组中的最大值
    public int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public void loadData() {
    }

    public void refresh() {
    }
}
