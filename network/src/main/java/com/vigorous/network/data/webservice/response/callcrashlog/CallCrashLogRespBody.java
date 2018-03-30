package com.vigorous.network.data.webservice.response.callcrashlog;



import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by vigorous.liang
 * Created on 2018/3/28
 */
//坑，这里只能是Body,不能使soap:Body,不然解析不出来
@Root(name = "Body", strict = false)
public class CallCrashLogRespBody {

    @Element(name = "CallCrashLogResponse", required = false)
    private CallCrashLogResponse body;

    public CallCrashLogResponse getBody() {
        return body;
    }

    public void setBody(CallCrashLogResponse body) {
        this.body = body;
    }

    public CallCrashLogRespBody(){

    }
}