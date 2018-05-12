package com.example.qiany.commonproject.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author caiwenqing
 * @data 2018/5/10
 * description:
 */
public class RetrofitFactory {
    private static RetrofitFactory mInstance;
    private static API mApi;

    private RetrofitFactory() {
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(InterceptorUtil.LogInterceptor())
                .build();

        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_URL)
                //添加gson转换器
                .addConverterFactory(GsonConverterFactory.create())
                //添加string转换器
                .addConverterFactory(ScalarsConverterFactory.create())
                //添加rxjava转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mOkHttpClient)
                .build();

        mApi = mRetrofit.create(API.class);
    }

    public static RetrofitFactory getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitFactory.class) {
                mInstance = new RetrofitFactory();
            }
        }
        return mInstance;
    }


    public API getApi() {
        return mApi;
    }
}
