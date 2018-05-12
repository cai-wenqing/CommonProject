package com.example.qiany.commonproject.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.qiany.commonproject.R;
import com.example.qiany.commonproject.ui.base.BaseFragment;

/**
 * @author caiwenqing
 * @data 2018/5/12
 * description:
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {

    public static HomeFragment newInstance() {
        Bundle bundle = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void initData() {
        mPresenter.getArtistData(0);
    }

    @Override
    public void loadMoreArtist() {

    }
}
