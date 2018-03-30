package com.vigorous.network.request;


import io.reactivex.observers.DisposableObserver;
import com.vigorous.network.data.NetWorkRequestConst;
import com.vigorous.network.data.RequestId;
import com.vigorous.network.listener.RequestListener;

/**
 * Created by Vigorous.Liang on 2017/9/18.
 */

public class AsyncWSSubscriberCreater<T> {

    public DisposableObserver<T> create(final RequestListener<T> listener,
                                                        int requestID) {
        final RequestId requestId = new RequestId(requestID);
        DisposableObserver subscriber = new DisposableObserver<T>() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                listener.onError(requestId,
                        NetWorkRequestConst.RESPONSE_TIME_OUT,
                        NetWorkRequestConst.RESPONSE_TIME_OUT_STR);
            }

            @Override
            public void onNext(T t) {
                if (listener != null && t != null) {
                    listener.onResult(requestId, t);
                }
            }
        };
        return subscriber;
    }
}
