package com.vigorous.network.data.webservice.request.callscan;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by vigorous.liang
 * Created on 2018/3/28
 */

@Root(name = "soap12:Body", strict = false)
public class CallScanRequestBody {

    @Element(name = "CallScan", required = false)
    private CallScanRequest body;

    public CallScanRequest getBody() {
        return body;
    }

    public void setBody(CallScanRequest body) {
        this.body = body;
    }

    public CallScanRequestBody(){

    }
}