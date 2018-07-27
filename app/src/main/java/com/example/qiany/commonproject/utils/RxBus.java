package com.example.qiany.commonproject.utils;


import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;

import io.reactivex.Observable;

/**
 * @author caiwenqing
 * @data 2018/7/25
 * description:
 */
public class RxBus {
    private static volatile RxBus mInstance;
    private final Relay<Object> mBus;

    private RxBus() {
        mBus = PublishRelay.create().toSerialized();
    }

    public static RxBus getInstance() {
        if (mInstance == null) {
            synchronized (RxBus.class) {
                if (mInstance == null) {
                    mInstance = new RxBus();
                }
            }
        }
        return mInstance;
    }

    public void post(Object event) {
        mBus.accept(event);
    }

    public <T> Observable<T> tObservable(final Class<T> eventType) {
        return mBus.ofType(eventType);
    }

    public boolean hasObservable() {
        return mBus.hasObservers();
    }

    public void reset() {
        mInstance = null;
    }
}
