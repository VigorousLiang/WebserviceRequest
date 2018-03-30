package com.vigorous.network.data.webservice.response.likequery;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by vigorousliang
 * Created on 2018/3/28
 */

@Root(name = "CallCrashLogResponse", strict = false)
@Namespace(reference = "http://www.gtja.com.cn/")
public class CallLikeQueryResponse {

    @Element(name = "CallLikeQueryResult", required = false)
    private String callLikeQueryResult;

    public String getCallLikeQueryResult() {
        return callLikeQueryResult;
    }

    public void setCallLikeQueryResult(String callLikeQueryResult) {
        this.callLikeQueryResult = callLikeQueryResult;
    }

    public CallLikeQueryResponse(){

    }

}