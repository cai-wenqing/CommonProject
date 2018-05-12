package com.example.qiany.commonproject.ui.project;

import android.os.Bundle;
import android.view.View;

import com.example.qiany.commonproject.R;
import com.example.qiany.commonproject.ui.base.BaseFragment;

/**
 * @author caiwenqing
 * @data 2018/5/13
 * description:
 */
public class ProjectFragment extends BaseFragment<ProjectPresenter> implements ProjectContract.View {

    public static ProjectFragment newInstance(){
        Bundle bundle = new Bundle();
        ProjectFragment fragment = new ProjectFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_project;
    }

    @Override
    public ProjectPresenter createPresenter() {
        return new ProjectPresenter();
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void initData() {

    }
}
