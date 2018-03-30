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
import com.vigorous.network.data.webservice.request.callcrashlog.CallCrashLogRequestBody;
import com.vigorous.network.data.webservice.request.calldbweb.CallDBWebRequestBody;
import com.vigorous.network.data.webservice.request.callscan.CallScanRequestBody;
import com.vigorous.network.data.webservice.request.callwebservice.CallWebServiceRequestBody;
import com.vigorous.network.data.webservice.request.likequery.CallLikeQueryRequestBody;
import com.vigorous.network.data.webservice.request.login.LoginRequestBody;
import com.vigorous.network.data.webservice.response.callcrashlog.CallCrashLogRespEnvelope;
import com.vigorous.network.data.webservice.response.calldbweb.CallDBWebRespEnvelope;
import com.vigorous.network.data.webservice.response.callscan.CallScanRespEnvelope;
import com.vigorous.network.data.webservice.response.callwebservice.CallWebServiceRespEnvelope;
import com.vigorous.network.data.webservice.response.likequery.CallLikeQueryRespEnvelope;
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


    /**
     * 请求call webservice
     * @param context
     * @param requestID
     * @param type
     * @param param
     * @param callBack
     */
    public void sendWSPostMessageForCallWebService(Context context, int requestID,
                                           int type, Soap12RequestEnvelope<CallWebServiceRequestBody>
                                                   param,RequestListener<CallWebServiceRespEnvelope> callBack) {
        if (null==requestServiceSoftReference.get() ) {
            getWebServiceAPI(context);
        }
        if (param != null) {
            CompositeDisposable disposables = new CompositeDisposable();
            AsyncWSSubscriberCreater<CallWebServiceRespEnvelope> asyncSubscriberCreater = new AsyncWSSubscriberCreater<>();
            Observable<CallWebServiceRespEnvelope> observable = requestServiceSoftReference
                    .get().callWebService(param);
            disposables.add(observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(asyncSubscriberCreater
                            .create(callBack, requestID)));
            if (type == REQUEST_TYPE_CANCEL_WITH_ACTIVITY) {
                mCancelableRequestQueue.add(disposables);
            }
        }
    }


    /**
     * 请求call scan
     * @param context
     * @param requestID
     * @param type
     * @param param
     * @param callBack
     */
    public void sendWSPostMessageForCallScan(Context context, int requestID,
                                                   int type, Soap12RequestEnvelope<CallScanRequestBody>
                                                           param,RequestListener<CallScanRespEnvelope> callBack) {
        if (null==requestServiceSoftReference.get() ) {
            getWebServiceAPI(context);
        }
        if (param != null) {
            CompositeDisposable disposables = new CompositeDisposable();
            AsyncWSSubscriberCreater<CallScanRespEnvelope> asyncSubscriberCreater = new AsyncWSSubscriberCreater<>();
            Observable<CallScanRespEnvelope> observable = requestServiceSoftReference
                    .get().callScan(param);
            disposables.add(observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(asyncSubscriberCreater
                            .create(callBack, requestID)));
            if (type == REQUEST_TYPE_CANCEL_WITH_ACTIVITY) {
                mCancelableRequestQueue.add(disposables);
            }
        }
    }


    /**
     * 请求CallLikeQuery
     * @param context
     * @param requestID
     * @param type
     * @param param
     * @param callBack
     */
    public void sendWSPostMessageForCallLikeQuery(Context context, int requestID,
                                             int type, Soap12RequestEnvelope<CallLikeQueryRequestBody>
                                                     param,RequestListener<CallLikeQueryRespEnvelope> callBack) {
        if (null==requestServiceSoftReference.get() ) {
            getWebServiceAPI(context);
        }
        if (param != null) {
            CompositeDisposable disposables = new CompositeDisposable();
            AsyncWSSubscriberCreater<CallLikeQueryRespEnvelope> asyncSubscriberCreater = new AsyncWSSubscriberCreater<>();
            Observable<CallLikeQueryRespEnvelope> observable = requestServiceSoftReference
                    .get().callLikeQuery(param);
            disposables.add(observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(asyncSubscriberCreater
                            .create(callBack, requestID)));
            if (type == REQUEST_TYPE_CANCEL_WITH_ACTIVITY) {
                mCancelableRequestQueue.add(disposables);
            }
        }
    }

    /**
     * 请求CallLikeQuery
     * @param context
     * @param requestID
     * @param type
     * @param param
     * @param callBack
     */
    public void sendWSPostMessageForCallDBWeb(Context context, int requestID,
                                                  int type, Soap12RequestEnvelope<CallDBWebRequestBody>
                                                          param,RequestListener<CallDBWebRespEnvelope> callBack) {
        if (null==requestServiceSoftReference.get() ) {
            getWebServiceAPI(context);
        }
        if (param != null) {
            CompositeDisposable disposables = new CompositeDisposable();
            AsyncWSSubscriberCreater<CallDBWebRespEnvelope> asyncSubscriberCreater = new AsyncWSSubscriberCreater<>();
            Observable<CallDBWebRespEnvelope> observable = requestServiceSoftReference
                    .get().callDBWeb(param);
            disposables.add(observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(asyncSubscriberCreater
                            .create(callBack, requestID)));
            if (type == REQUEST_TYPE_CANCEL_WITH_ACTIVITY) {
                mCancelableRequestQueue.add(disposables);
            }
        }
    }


    /**
     * CallCrashLog
     * @param context
     * @param requestID
     * @param type
     * @param param
     * @param callBack
     */
    public void sendWSPostMessageForCallCrashLog(Context context, int requestID,
                                              int type, Soap12RequestEnvelope<CallCrashLogRequestBody>
                                                      param,RequestListener<CallCrashLogRespEnvelope> callBack) {
        if (null==requestServiceSoftReference.get() ) {
            getWebServiceAPI(context);
        }
        if (param != null) {
            CompositeDisposable disposables = new CompositeDisposable();
            AsyncWSSubscriberCreater<CallCrashLogRespEnvelope> asyncSubscriberCreater = new AsyncWSSubscriberCreater<>();
            Observable<CallCrashLogRespEnvelope> observable = requestServiceSoftReference
                    .get().callCrashLog(param);
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