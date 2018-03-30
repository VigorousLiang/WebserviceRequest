package com.vigorous.network.api;



import io.reactivex.Observable;

import com.vigorous.network.data.webservice.request.Soap12RequestEnvelope;
import com.vigorous.network.data.webservice.response.login.LoginRespEnvelope;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by vigorous.liang
 * Created on 2018/3/28
 */

public interface WebServiceRequestService {
    @Headers({
            "Content-Type: application/soap+xml",
            "charset: utf-8",
            "SOAPAction: \"http://www.gtja.com.cn/Login\""
    })
    @POST("callservice.asmx?op=Login")
    Observable<LoginRespEnvelope> login(@Body Soap12RequestEnvelope param);
}
