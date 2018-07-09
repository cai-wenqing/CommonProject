package com.example.qiany.commonproject.ui.home;

import android.util.Log;

import com.example.qiany.commonproject.bean.ArticleBean;
import com.example.qiany.commonproject.net.DataManager;
import com.example.qiany.commonproject.net.RxSchedulers;
import com.example.qiany.commonproject.ui.base.BaseObserver;
import com.example.qiany.commonproject.ui.base.BasePresenter;

/**
 * @author caiwenqing
 * @data 2018/5/12
 * description:
 */
public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {
    private static final String TAG = "HomePresenter测试";

    @Override
    public void getBannerData() {

    }


    @Override
    public void getArtistData(int page) {
        DataManager.getInstance().getNewestArticles(page)
                .compose(RxSchedulers.<ArticleBean>applySchedulers())
                .compose(mView.<ArticleBean>bindToLife())
                .subscribe(new BaseObserver<ArticleBean>() {

                    @Override
                    public void onSuccess(ArticleBean articleBean) {
                        if (articleBean != null) {
                            Log.i(TAG, articleBean.toString());
                        }
                        if (mView != null) {
                            Log.i(TAG, "mView不为null");
                        } else {
                            Log.i(TAG, "mView为null");
                        }
                    }

                    @Override
                    public void onFail(Throwable e) {

                    }
                });
    }
}
