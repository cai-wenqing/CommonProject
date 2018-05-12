package com.example.qiany.commonproject.net;

import com.example.qiany.commonproject.bean.HttpResult;

import io.reactivex.functions.Function;

/**
 * @author caiwenqing
 * @data 2018/5/12
 * description:
 */
public class ResultFunc<T> implements Function<HttpResult<T>,T> {
    @Override
    public T apply(HttpResult<T> tHttpResult) throws Exception {
        if (!tHttpResult.isSuccess()) {
            throw new APIException(tHttpResult.getErrorCode(), tHttpResult.getErrorMsg());
        }
        return tHttpResult.getData();
    }
}
