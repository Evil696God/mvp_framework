package com.wcx.framework.mvpproject.common.application;

import android.app.Application;
import android.content.Context;
import com.wcx.framework.mvpproject.common.database.IOTDatabase;

/**
 * @author wangchenxing
 * @data 30/11/2018 9:12 AM
 */
public class IOTApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        //初始加载数据库
        IOTDatabase.getDatabase(getApplicationContext());

        context = this;
    }
}
