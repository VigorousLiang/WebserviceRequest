package com.vigorous.network.data.webservice.request.calldbweb;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by vigorous.liang
 * Created on 2018/3/28
 */

@Root(name = "soap12:Body", strict = false)
public class CallDBWebRequestBody {

    @Element(name = "CallDBWeb", required = false)
    private CallDBWebRequest body;

    public CallDBWebRequest getBody() {
        return body;
    }

    public void setBody(CallDBWebRequest body) {
        this.body = body;
    }

    public CallDBWebRequestBody(){

    }
}