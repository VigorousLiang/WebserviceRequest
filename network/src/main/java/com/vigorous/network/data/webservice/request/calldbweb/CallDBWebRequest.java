package com.vigorous.network.data.webservice.request.calldbweb;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by vigorousliang
 * Created on 2018/3/28
 */

@Root(name = "CallDBWeb", strict = false)
@Namespace(reference = "http://www.gtja.com.cn/")
public class CallDBWebRequest {

    @Element(name = "data", required = false)
    private String data;
    @Element(name = "session", required = false)
    private String session;
    @Element(name = "ip", required = false)
    private String ip;
    @Element(name = "isencrypt", required = false)
    private String isencrypt;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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

    public CallDBWebRequest(){

    }
}