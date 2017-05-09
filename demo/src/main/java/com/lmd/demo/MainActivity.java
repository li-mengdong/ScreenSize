package com.lmd.demo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
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
    private String mPhoneBrand;
    private String mPhoneModel;
    private String mScreenResolution;
    private String[] DPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {

            actionBar.getHeight();
        }

        initData();
        initView();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        String mStatusBarHeight = ScreenUtils.getInstance(this).getStatusBarHeight();
        String mTitleBarHeight = ScreenUtils.getInstance(this).getTitleBarHeight();

        int contentTop = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
        //statusBarHeight是上面状态栏的高度
        int titleBarHeight = contentTop - Integer.parseInt(mStatusBarHeight);

        screenTitleBarHeight.setText("状态栏高度：" + mStatusBarHeight);
        screenStatusBarHeight.setText("标题栏高度：" + contentTop);
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

}
