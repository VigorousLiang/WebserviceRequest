package com.vigorous.network.data.webservice.request.likequery;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by vigorous.liang
 * Created on 2018/3/28
 */

@Root(name = "soap12:Body", strict = false)
public class CallLikeQueryRequestBody {

    @Element(name = "CallLikeQuery", required = false)
    private CallLikeQueryRequest body;

    public CallLikeQueryRequest getBody() {
        return body;
    }

    public void setBody(CallLikeQueryRequest body) {
        this.body = body;
    }

    public CallLikeQueryRequestBody(){

    }
}