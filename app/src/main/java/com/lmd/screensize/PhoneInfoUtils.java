package com.lmd.screensize;

import android.os.Build;
import android.util.Log;

/**
 * 作者 : LMD
 * 时间 : 2017/5/8 16:14
 * 功能 : 手机信息工具类
 */

public class PhoneInfoUtils {
    private static final String TAG = "PhoneInfoUtils";

    /**
     * 获取手机品牌
     */
    public static String getPhoneBrand() {
        String phoneBrand = Build.BRAND;
        Log.e(TAG, "PhoneBrand: " + phoneBrand);
        return phoneBrand;
    }

    /**
     * 获取手机型号
     */
    public static String getPhoneModel() {
        String phoneModel = Build.MODEL;
        Log.e(TAG, "PhoneModel: " + phoneModel);
        return phoneModel;

    }
}
