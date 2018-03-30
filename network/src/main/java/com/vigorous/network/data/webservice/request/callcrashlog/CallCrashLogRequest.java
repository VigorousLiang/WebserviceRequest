package com.vigorous.network.data.webservice.request.callcrashlog;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by vigorousliang
 * Created on 2018/3/28
 */

@Root(name = "CallCrashLog", strict = false)
@Namespace(reference = "http://www.gtja.com.cn/")
public class CallCrashLogRequest {

    @Element(name = "userId", required = false)
    private String userId;
    @Element(name = "reason", required = false)
    private String reason;
    @Element(name = "name", required = false)
    private String name;
    @Element(name = "info", required = false)
    private String info;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public CallCrashLogRequest(){

    }
}