package com.vigorous.network.data.webservice.response.callscan;


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
public class CallScanRespEnvelope {

    @Element(name = "Body", required = false)
    private CallScanRespBody body;

    public CallScanRespBody getBody() {
        return body;
    }

    public void setBody(CallScanRespBody body) {
        this.body = body;
    }

    public CallScanRespEnvelope(){

    }
}