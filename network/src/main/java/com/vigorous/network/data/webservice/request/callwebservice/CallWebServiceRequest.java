package com.vigorous.network.data.webservice.request.callwebservice;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by vigorousliang
 * Created on 2018/3/28
 */

@Root(name = "CallWebService", strict = false)
@Namespace(reference = "http://www.gtja.com.cn/")
public class CallWebServiceRequest {

    @Element(name = "request", required = false)
    private String request;
    @Element(name = "session", required = false)
    private String session;
    @Element(name = "ip", required = false)
    private String ip;
    @Element(name = "isencrypt", required = false)
    private String isencrypt;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIsencrypt() {
        return isencrypt;
    }

    public void setIsencrypt(String isencrypt) {
        this.isencrypt = isencrypt;
    }

    public CallWebServiceRequest(){

    }
}