package com.vigorous.network.data.webservice.request.callcrashlog;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by vigorous.liang
 * Created on 2018/3/28
 */

@Root(name = "soap12:Body", strict = false)
public class CallCrashLogRequestBody {

    @Element(name = "CallCrashLog", required = false)
    private CallCrashLogRequest body;

    public CallCrashLogRequest getBody() {
        return body;
    }

    public void setBody(CallCrashLogRequest body) {
        this.body = body;
    }

    public CallCrashLogRequestBody(){

    }
}