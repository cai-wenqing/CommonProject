package com.example.qiany.commonproject.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author caiwenqing
 * @data 2018/5/11
 * description:
 */
public interface IBase<T1 extends BaseContract.Presenter> {

    View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    int getContentLayout();

    T1 createPresenter();

    View getView();

    void initView(View view,Bundle savedInstanceState);

    void initData();
}
