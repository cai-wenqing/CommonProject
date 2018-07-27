package com.example.qiany.commonproject.ui.tree;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.qiany.commonproject.R;
import com.example.qiany.commonproject.ui.base.BaseFragment;

import butterknife.BindView;

/**
 * @author caiwenqing
 * @data 2018/5/12
 * description:
 */
public class TreeFragment extends BaseFragment<TreePresenter> implements TreeContract.View {
    @BindView(R.id.tree_tv)
    TextView treeTv;

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

    @Override
    public void onRetry(int status) {

    }
}
