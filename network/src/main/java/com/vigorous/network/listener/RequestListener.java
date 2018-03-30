package com.vigorous.network.listener;


import com.vigorous.network.data.RequestId;
import com.vigorous.network.data.webservice.response.login.LoginRespEnvelope;

/**
 * Created by Vigorous.Liang on 2017/9/18.
 */

public interface RequestListener <T> {

    // 网络正确返回回调
    public void onResult(RequestId requestID, T resp);

    // 网络错误返回回调
    public void onError(RequestId requestID, String errorCode, String errorDesc);
}
