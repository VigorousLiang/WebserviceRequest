package com.vigorous.network.data.webservice.response.calldbweb;



import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by vigorous.liang
 * Created on 2018/3/28
 */
//坑，这里只能是Body,不能使soap:Body,不然解析不出来
@Root(name = "Body", strict = false)
public class CallDBWebRespBody {

    @Element(name = "CallCrashLogResponse", required = false)
    private CallDBWebResponse body;

    public CallDBWebResponse getBody() {
        return body;
    }

    public void setBody(CallDBWebResponse body) {
        this.body = body;
    }

    public CallDBWebRespBody(){

    }
}