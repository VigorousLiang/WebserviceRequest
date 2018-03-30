package com.vigorous.network.api;



import io.reactivex.Observable;

import com.vigorous.network.data.webservice.request.Soap12RequestEnvelope;
import com.vigorous.network.data.webservice.response.callcrashlog.CallCrashLogRespEnvelope;
import com.vigorous.network.data.webservice.response.calldbweb.CallDBWebRespEnvelope;
import com.vigorous.network.data.webservice.response.callscan.CallScanRespEnvelope;
import com.vigorous.network.data.webservice.response.callwebservice.CallWebServiceRespEnvelope;
import com.vigorous.network.data.webservice.response.likequery.CallLikeQueryRespEnvelope;
import com.vigorous.network.data.webservice.response.login.LoginRespEnvelope;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by vigorous.liang
 * Created on 2018/3/28
 */

public interface WebServiceRequestService {
    /**
     * 登录接口
     * @param param
     * @return
     */
    @Headers({
            "Content-Type: application/soap+xml",
            "charset: utf-8",
            "SOAPAction: \"http://www.gtja.com.cn/Login\""
    })
    @POST("callservice.asmx?op=Login")
    Observable<LoginRespEnvelope> login(@Body Soap12RequestEnvelope param);

    /**
     * callWebservice接口
     * @param param
     * @return
     */
    @Headers({
            "Content-Type: application/soap+xml",
            "charset: utf-8",
            "SOAPAction: \"http://www.gtja.com.cn/CallWebService\""
    })
    @POST("callservice.asmx?op=CallWebService")
    Observable<CallWebServiceRespEnvelope> callWebService(@Body Soap12RequestEnvelope param);


    /**
     * callScan接口
     * @param param
     * @return
     */
    @Headers({
            "Content-Type: application/soap+xml",
            "charset: utf-8",
            "SOAPAction: \"http://www.gtja.com.cn/CallScan\""
    })
    @POST("callservice.asmx?op=CallScan")
    Observable<CallScanRespEnvelope> callScan(@Body Soap12RequestEnvelope param);


    /**
     * CallLikeQuery接口
     * @param param
     * @return
     */
    @Headers({
            "Content-Type: application/soap+xml",
            "charset: utf-8",
            "SOAPAction: \"http://www.gtja.com.cn/CallLikeQuery\""
    })
    @POST("callservice.asmx?op=CallLikeQuery")
    Observable<CallLikeQueryRespEnvelope> callLikeQuery(@Body Soap12RequestEnvelope param);


    /**
     * CallLikeQuery接口
     * @param param
     * @return
     */
    @Headers({
            "Content-Type: application/soap+xml",
            "charset: utf-8",
            "SOAPAction: \"http://www.gtja.com.cn/CallLikeQuery\""
    })
    @POST("callservice.asmx?op=CallLikeQuery")
    Observable<CallLikeQueryRespEnvelope> CallLikeQuery(@Body Soap12RequestEnvelope param);

    /**
     * CallDBWeb接口
     * @param param
     * @return
     */
    @Headers({
            "Content-Type: application/soap+xml",
            "charset: utf-8",
            "SOAPAction: \"http://www.gtja.com.cn/CallDBWeb\""
    })
    @POST("callservice.asmx?op=CallLikeQuery")
    Observable<CallDBWebRespEnvelope> callDBWeb(@Body Soap12RequestEnvelope param);

    /**
     * CallCrashLog接口
     * @param param
     * @return
     */
    @Headers({
            "Content-Type: application/soap+xml",
            "charset: utf-8",
            "SOAPAction: \"http://www.gtja.com.cn/CallCrashLog\""
    })
    @POST("callservice.asmx?op=CallCrashLog")
    Observable<CallCrashLogRespEnvelope> callCrashLog(@Body Soap12RequestEnvelope param);
}
