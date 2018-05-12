package com.example.qiany.commonproject.ui.tree;

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
public class TreeFragment extends BaseFragment<TreePresenter> implements TreeContract.View {

    public static TreeFragment newInstance() {
        Bundle bundle = new Bundle();
        TreeFragment fragment = new TreeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_tree;
    }

    @Override
    public TreePresenter createPresenter() {
        return new TreePresenter();
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
    }

    @Override
    public void initData() {
    }
}
