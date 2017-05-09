package com.lmd.demo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;

import com.lmd.screeninfolibrary.PhoneInfoUtils;
import com.lmd.screeninfolibrary.ScreenUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.phone_brand)
    TextView phoneBrand;
    @BindView(R.id.phone_model)
    TextView phoneModel;
    @BindView(R.id.screen_resolution)
    TextView screenResolution;
    @BindView(R.id.screen_density)
    TextView screenDensity;
    @BindView(R.id.screen_densityDpi)
    TextView screenDensityDpi;
    @BindView(R.id.screen_xdpi)
    TextView screenXdpi;
    @BindView(R.id.screen_ydpi)
    TextView screenYdpi;
    @BindView(R.id.screen_titleBarHeight)
    TextView screenTitleBarHeight;
    @BindView(R.id.screen_statusBarHeight)
    TextView screenStatusBarHeight;
    @BindView(R.id.screen_navigationBarHeight)
    TextView screenNavigationBarHeight;
    private String mPhoneBrand;
    private String mPhoneModel;
    private String mScreenResolution;
    private String[] DPI;
    private String mNavigationHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //getNavigationBarHeight();
        initData();
        initView();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        String mStatusBarHeight = ScreenUtils.getInstance(this).getStatusBarHeight();
        String mTitleBarHeight = ScreenUtils.getInstance(this).getTitleBarHeight();
        String mNavigationHeight = ScreenUtils.getInstance(this).getNavigationBarHeight();

        screenTitleBarHeight.setText("状态栏高度：" + mStatusBarHeight);
        screenStatusBarHeight.setText("标题栏高度：" + mTitleBarHeight);

        screenNavigationBarHeight.setText("导航栏高度：" + mNavigationHeight);
    }

    private void initData() {
        mPhoneBrand = PhoneInfoUtils.getPhoneBrand();
        mPhoneModel = PhoneInfoUtils.getPhoneModel();
        mScreenResolution = ScreenUtils.getInstance(this).getScreenResolution();
        DPI = ScreenUtils.getInstance(this).getDpi();
    }

    private void initView() {
        phoneBrand.setText("手机品牌：" + mPhoneBrand);
        phoneModel.setText("手机型号：" + mPhoneModel);
        screenResolution.setText("屏幕分辨率：" + mScreenResolution);
        screenDensity.setText("屏幕密度：" + DPI[0]);
        screenDensityDpi.setText("屏幕DPI：" + DPI[1]);
        screenXdpi.setText("xDPI：" + DPI[2]);
        screenYdpi.setText("yDPI：" + DPI[3]);
    }

    public void getNavigationBarHeight() {
        int heightPixels = getResources().getDisplayMetrics().heightPixels;
        Log.e("heightPixels", "heightPixels: " + heightPixels);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        Log.e("displayMetrics.heightPixels", "displayMetrics.heightPixels: " + displayMetrics.heightPixels);
        int navigationBarHeight = displayMetrics.heightPixels - heightPixels;
        Log.e("navigationBarHeight", "navigationBarHeight: "+navigationBarHeight);
    }
}
