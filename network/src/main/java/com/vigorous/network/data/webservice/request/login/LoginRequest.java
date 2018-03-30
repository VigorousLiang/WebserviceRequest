package com.vigorous.network.data.webservice.request.login;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by vigorousliang
 * Created on 2018/3/28
 */

@Root(name = "Login", strict = false)
@Namespace(reference = "http://www.gtja.com.cn/")
public class LoginRequest {

    @Element(name = "userId", required = false)
    private String userId;
    @Element(name = "password", required = false)
    private String password;
    @Element(name = "system", required = false)
    private String system="android";
    @Element(name = "desc", required = false)
    private String desc;
    @Element(name = "isencrypt", required = false)
    private String isencrypt;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIsencrypt() {
        return isencrypt;
    }

    public void setIsencrypt(String isencrypt) {
        this.isencrypt = isencrypt;
    }

    public LoginRequest(){

    }
}