package com.example.qiany.commonproject.ui.mine.aboutme;

import android.os.Bundle;
import android.view.View;

import com.example.qiany.commonproject.R;
import com.example.qiany.commonproject.ui.base.BaseActivity;

/**
 * @author caiwenqing
 * @data 2018/7/26
 * description:
 */
public class AboutMeActivity extends BaseActivity<AboutMePresenter> implements AboutMeContract.View {

    @Override
    public void onRetry(int status) {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_aboutme;
    }

    @Override
    public AboutMePresenter createPresenter() {
        return new AboutMePresenter();
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void initData() {

    }
}
