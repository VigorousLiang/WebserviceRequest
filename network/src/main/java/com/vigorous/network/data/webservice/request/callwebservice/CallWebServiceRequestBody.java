package com.vigorous.network.data.webservice.request.callwebservice;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by vigorous.liang
 * Created on 2018/3/28
 */

@Root(name = "soap12:Body", strict = false)
public class CallWebServiceRequestBody {

    @Element(name = "CallWebService", required = false)
    private CallWebServiceRequest body;

    public CallWebServiceRequest getBody() {
        return body;
    }

    public void setBody(CallWebServiceRequest body) {
        this.body = body;
    }

    public CallWebServiceRequestBody(){

    }
}