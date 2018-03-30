package com.vigorous.network.data.webservice.request.likequery;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by vigorousliang
 * Created on 2018/3/28
 */

@Root(name = "CallLikeQuery", strict = false)
@Namespace(reference = "http://www.gtja.com.cn/")
public class CallLikeQueryRequest {

    @Element(name = "userId", required = false)
    private String userId;
    @Element(name = "keyword", required = false)
    private String keyword;
    @Element(name = "ip", required = false)
    private String ip;
    @Element(name = "session", required = false)
    private String session;
    @Element(name = "type", required = false)
    private String type;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CallLikeQueryRequest(){

    }
}