package com.vigorous.network.data.webservice.response.likequery;



import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by vigorous.liang
 * Created on 2018/3/28
 */
//坑，这里只能是Body,不能使soap:Body,不然解析不出来
@Root(name = "Body", strict = false)
public class CallLikeQueryRespBody {

    @Element(name = "CallCrashLogResponse", required = false)
    private CallLikeQueryResponse body;

    public CallLikeQueryResponse getBody() {
        return body;
    }

    public void setBody(CallLikeQueryResponse body) {
        this.body = body;
    }

    public CallLikeQueryRespBody(){

    }
}