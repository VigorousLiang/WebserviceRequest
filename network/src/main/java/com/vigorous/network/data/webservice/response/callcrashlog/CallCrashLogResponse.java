package com.vigorous.network.data.webservice.response.callcrashlog;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by vigorousliang
 * Created on 2018/3/28
 */

@Root(name = "CallCrashLogResponse", strict = false)
@Namespace(reference = "http://www.gtja.com.cn/")
public class CallCrashLogResponse {

    @Element(name = "CallCrashLogResult", required = false)
    private String CallCrashLogResult;

    public String getCallCrashLogResult() {
        return CallCrashLogResult;
    }

    public void setCallCrashLogResult(String callCrashLogResult) {
        this.CallCrashLogResult = callCrashLogResult;
    }

    public CallCrashLogResponse(){

    }

}