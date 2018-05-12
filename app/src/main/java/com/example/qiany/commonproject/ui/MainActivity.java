package com.example.qiany.commonproject.ui;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.view.View;
import android.widget.FrameLayout;

import com.example.qiany.commonproject.R;
import com.example.qiany.commonproject.ui.base.BaseActivity;
import com.example.qiany.commonproject.ui.base.BaseContract;
import com.example.qiany.commonproject.utils.BottomNavigationViewHelper;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_frameLayout)
    FrameLayout mFrameLayout;
    @BindView(R.id.main_bottomNavigation)
    BottomNavigationView mBottomNavigation;

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public BaseContract.Presenter createPresenter() {
        return null;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        //解决多余三个tab时滑动问题
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigation);
    }

    @Override
    public void initData() {

    }
}
