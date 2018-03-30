package com.vigorous.network.data.webservice.response.callcrashlog;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by vigorous.liang
 * Created on 2018/3/28
 */
@Root(name = "soap:Envelope")
@NamespaceList({
        @Namespace( prefix = "soap", reference = "http://www.w3.org/2003/05/soap-envelope"),
        @Namespace( prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace( prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema")
})
public class CallCrashLogRespEnvelope {

    @Element(name = "Body", required = false)
    private CallCrashLogRespBody body;

    public CallCrashLogRespBody getBody() {
        return body;
    }

    public void setBody(CallCrashLogRespBody body) {
        this.body = body;
    }

    public CallCrashLogRespEnvelope(){

    }
}