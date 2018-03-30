package com.vigorous.network;

import android.content.Context;


import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import com.vigorous.network.api.WebServiceRequestService;
import com.vigorous.network.data.webservice.request.Soap12RequestEnvelope;
import com.vigorous.network.data.webservice.request.login.LoginRequestBody;
import com.vigorous.network.data.webservice.response.login.LoginRespEnvelope;
import com.vigorous.network.exception.AsyncHttpManagerNotInitException;
import com.vigorous.network.listener.RequestListener;
import com.vigorous.network.request.AsyncHttpManager;
import com.vigorous.network.request.AsyncWSSubscriberCreater;

/**
 * Created by Vigorous.Liang on 2017/9/18.
 */
public class AsyncNetWorkAPIFactory {


    private SoftReference<WebServiceRequestService> requestServiceSoftReference;
    private ConcurrentLinkedQueue<CompositeDisposable> mCancelableRequestQueue;
    public final static int REQUEST_TYPE_CANCEL_WITH_ACTIVITY = 1;
    public final static int REQUEST_TYPE_BACKGROUND = REQUEST_TYPE_CANCEL_WITH_ACTIVITY
            + 1;

    public AsyncNetWorkAPIFactory(Context context) {
        mCancelableRequestQueue = new ConcurrentLinkedQueue<CompositeDisposable>();
        getWebServiceAPI(context);
    }


    private void getWebServiceAPI(Context context) {
        AsyncHttpManager asyncHttpManager = AsyncHttpManager
                .getInstance(context);
        try {
            requestServiceSoftReference = new SoftReference<WebServiceRequestService>(
                    asyncHttpManager.getWebServiceAPI());
        } catch (AsyncHttpManagerNotInitException e) {
            e.printStackTrace();
        }
    }

    public void cancelAllCancelableRequest() {
        Iterator<CompositeDisposable> iterator = mCancelableRequestQueue
                .iterator();
        while (iterator.hasNext()) {
            CompositeDisposable compositeDisposable = mCancelableRequestQueue
                    .poll();
            compositeDisposable.dispose();
            compositeDisposable.clear();
        }
    }


    /**
     * 请求登录接口
     * @param context
     * @param requestID
     * @param type
     * @param param
     * @param callBack
     */
    public void sendWSPostMessageForSignIn(Context context, int requestID,
                                           int type, Soap12RequestEnvelope<LoginRequestBody>
                                                   param,RequestListener<LoginRespEnvelope> callBack) {
        if (null==requestServiceSoftReference.get() ) {
            getWebServiceAPI(context);
        }
        if (param != null) {
            CompositeDisposable disposables = new CompositeDisposable();
            AsyncWSSubscriberCreater<LoginRespEnvelope> asyncSubscriberCreater = new AsyncWSSubscriberCreater<>();
            Observable<LoginRespEnvelope> observable = requestServiceSoftReference
                    .get().login(param);
            disposables.add(observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(asyncSubscriberCreater
                            .create(callBack, requestID)));
            if (type == REQUEST_TYPE_CANCEL_WITH_ACTIVITY) {
                mCancelableRequestQueue.add(disposables);
            }
        }
    }
}