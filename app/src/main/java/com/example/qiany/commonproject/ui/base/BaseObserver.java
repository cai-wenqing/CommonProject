package com.example.qiany.commonproject.ui.base;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.qiany.commonproject.net.APIException;
import com.example.qiany.commonproject.utils.ToastUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author caiwenqing
 * @data 2018/5/12
 * description:基础观察者
 */
public abstract class BaseObserver<T> implements Observer<T> {

    public abstract void onSuccess(T t);


    public abstract void onFail(Throwable e);


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException) {
            ToastUtils.ToastCenter("网络中断，请检查您的网络状态");
        } else if (e instanceof ConnectException) {
            ToastUtils.ToastCenter("网络中断，请检查您的网络状态");
        } else if (e instanceof APIException) {
            ToastUtils.ToastCenter(e.getMessage());
            Log.e("xdw", "apiCode=" + ((APIException) e).getCode());
        } else {
            ToastUtils.ToastCenter("未知异常");
            Log.e("xdw", "apiCode=" + ((APIException) e).getCode());
        }
        onFail(e);
    }

    @Override
    public void onComplete() {

    }
}
