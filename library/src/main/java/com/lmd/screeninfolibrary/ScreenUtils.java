package com.lmd.screeninfolibrary;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * 作者 : LMD
 * 时间 : 2017/5/8 15:36
 * 功能 : 屏幕信息工具类
 */

public class ScreenUtils {
    AppCompatActivity mActivity;

    private static ScreenUtils mInstance;

    public ScreenUtils(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    public static ScreenUtils getInstance(AppCompatActivity activity) {
        ScreenUtils mInstance = new ScreenUtils(activity);
        return mInstance;
    }

    /**
     * 获取手机屏幕密度
     */
    public String[] getDpi() {
        DisplayMetrics displayMetrics = mActivity.getResources().getDisplayMetrics();

        float density = displayMetrics.density;
        int densityDpi = displayMetrics.densityDpi;
        int heightPixels = displayMetrics.heightPixels;
        int widthPixels = displayMetrics.widthPixels;
        float xdpi = displayMetrics.xdpi;
        float ydpi = displayMetrics.ydpi;

        Log.e("DPI", "density: " + density + "densityDpi: " + densityDpi + "heightPixels: " + heightPixels + "widthPixels: " + widthPixels + "xdpi: " + xdpi + "ydpi: " + ydpi);

        return new String[]{String.valueOf(density), String.valueOf(densityDpi), String.valueOf(xdpi), String.valueOf(ydpi)};
    }

    public String getScreenResolution() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mActivity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        Log.e("screenResolution", "screenResolution: " + displayMetrics.widthPixels + "x" + displayMetrics.heightPixels);

        return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
    }

    /**
     * 状态栏高度
     */
    public String getStatusBarHeight() {
        Rect rect = new Rect();
        mActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int statusBarHeight = rect.top;

        Log.e("statusBarHeight", "statusBarHeight: " + statusBarHeight);

        return String.valueOf(statusBarHeight) + "px";
    }

    /**
     * 标题栏高度
     */
    public String getTitleBarHeight() {
        ActionBar actionBar = mActivity.getSupportActionBar();
        int titleBarHeight = actionBar.getHeight();

        Log.e("titleBarHeight", "titleBarHeight: " + titleBarHeight);

        return String.valueOf(titleBarHeight) + "px";
    }

    /**
     * 菜单栏高度
     */
    public String getNavigationBarHeight() {
        int heightPixels = mActivity.getResources().getDisplayMetrics().heightPixels;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mActivity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        }

        int navigationBarHeight = displayMetrics.heightPixels - heightPixels;
        Log.e("navigationBarHeight", "navigationBarHeight: " + navigationBarHeight);

        return String.valueOf(navigationBarHeight) + "px";
    }
}
