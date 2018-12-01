package com.wcx.framework.mvpproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.wcx.framework.mvpproject.common.base.baseactivity.view.BaseActivity;

/**
 * @author wangchenxing
 * @data 1/12/2018 4:07 PM
 */
public class MainActivity extends BaseActivity<TestPresenter> {

    @Override
    public int getLayoutResourceID() {
        return R.layout.activity_main;
    }

    @SuppressLint("ResourceType")
    @Override
    public void initView(Bundle savedInstanceState) {
    }

    @Override
    public void loadData() {
    }
}
