package com.example.qiany.commonproject.ui.mine;

import android.os.Bundle;
import android.view.View;

import com.example.qiany.commonproject.R;
import com.example.qiany.commonproject.ui.base.BaseFragment;

/**
 * @author caiwenqing
 * @data 2018/5/13
 * description:
 */
public class MineFragment extends BaseFragment<MinePresenter> implements MineContract.View {

    public static MineFragment newInstance(){
        Bundle bundle = new Bundle();
        MineFragment fragment = new MineFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public MinePresenter createPresenter() {
        return new MinePresenter();
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void initData() {

    }
}
