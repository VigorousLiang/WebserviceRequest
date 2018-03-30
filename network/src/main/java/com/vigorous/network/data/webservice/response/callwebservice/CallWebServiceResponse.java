package com.vigorous.network.data.webservice.response.callwebservice;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by vigorousliang
 * Created on 2018/3/28
 */

@Root(name = "CallScanResponse", strict = false)
@Namespace(reference = "http://www.gtja.com.cn/")
public class CallWebServiceResponse {

    @Element(name = "CallWebServiceResult", required = false)
    private String callWebServiceResult;

    public String getCallWebServiceResult() {
        return callWebServiceResult;
    }

    public void setCallWebServiceResult(String callWebServiceResult) {
        this.callWebServiceResult = callWebServiceResult;
    }

    public CallWebServiceResponse(){

    }

}