package com.vigorous.network.data.webservice.request.callscan;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by vigorousliang
 * Created on 2018/3/28
 */

@Root(name = "CallScan", strict = false)
@Namespace(reference = "http://www.gtja.com.cn/")
public class CallScanRequest {

    @Element(name = "addr", required = false)
    private String addr;
    @Element(name = "session", required = false)
    private String session;
    @Element(name = "ip", required = false)
    private String ip;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
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

    public CallScanRequest(){

    }
}