package com.example.qiany.commonproject.net;

import com.example.qiany.commonproject.bean.ArticleBean;

import io.reactivex.Observable;

/**
 * @author caiwenqing
 * @data 2018/5/12
 * description:
 */
public class DataManager {

    private static DataManager mInstance;

    private static API mApi;

    private DataManager() {
        mApi = RetrofitFactory.getInstance().getApi();
    }

    public static DataManager getInstance() {
        if (mInstance == null) {
            mInstance = new DataManager();
        }
        return mInstance;
    }

    /**
     * 获取最新文章列表
     * @param page
     * @return
     */
    public Observable<ArticleBean> getNewestArticles(int page) {
        return mApi.getNewestArticles(page).map(new ResultFunc<ArticleBean>());
    }
}
