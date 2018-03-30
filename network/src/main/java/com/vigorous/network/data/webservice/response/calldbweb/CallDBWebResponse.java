package com.vigorous.network.data.webservice.response.calldbweb;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by vigorousliang
 * Created on 2018/3/28
 */

@Root(name = "CallCrashLogResponse", strict = false)
@Namespace(reference = "http://www.gtja.com.cn/")
public class CallDBWebResponse {

    @Element(name = "CallDBWebResult", required = false)
    private String callDBWebResult;

    public String getCallDBWebResult() {
        return callDBWebResult;
    }

    public void setCallDBWebResult(String callDBWebResult) {
        this.callDBWebResult = callDBWebResult;
    }

    public CallDBWebResponse(){

    }

}