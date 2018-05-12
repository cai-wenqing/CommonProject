package com.example.qiany.commonproject.net;

import com.example.qiany.commonproject.bean.ArticleBean;
import com.example.qiany.commonproject.bean.HttpResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author caiwenqing
 * @data 2018/5/10
 * description:
 */
public interface API {

    /**
     * 获取最新文章列表
     * @param page 页码 从0开始
     * @return
     */
    @GET("/article/list/{page}/json")
    Observable<HttpResult<ArticleBean>> getNewestArticles(@Path("page") int page);
}
