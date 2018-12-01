package com.wcx.framework.mvpproject.common.utils;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * @author wangchenxing
 * @data 1/12/2018 4:07 PM
 * @description Activity相关扩展方法
 */
public class ActivityExtensionUtils {
    public static void addFragment(AppCompatActivity activity, int containerID, Fragment fragment, String fragmentTag) {
        if (activity != null) {
            activity.getSupportFragmentManager().beginTransaction().add(containerID, fragment, fragmentTag).commitAllowingStateLoss();
        }
    }
}
