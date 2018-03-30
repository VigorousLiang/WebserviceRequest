package com.vigorous.network.data.webservice.response.calldbweb;


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
public class CallDBWebRespEnvelope {

    @Element(name = "Body", required = false)
    private CallDBWebRespBody body;

    public CallDBWebRespBody getBody() {
        return body;
    }

    public void setBody(CallDBWebRespBody body) {
        this.body = body;
    }

    public CallDBWebRespEnvelope(){

    }
}