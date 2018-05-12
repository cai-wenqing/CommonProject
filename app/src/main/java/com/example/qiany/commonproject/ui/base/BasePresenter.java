package com.example.qiany.commonproject.ui.base;

/**
 * @author caiwenqing
 * @data 2018/5/11
 * description:
 */
public class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter<T> {

    protected T mView;

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        if (mView != null){
            mView = null;
        }
    }
}
