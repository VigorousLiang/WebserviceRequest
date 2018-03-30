package com.vigorous.network.data.webservice.response.login;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by vigorousliang
 * Created on 2018/3/28
 */

@Root(name = "CallScanResponse", strict = false)
@Namespace(reference = "http://www.gtja.com.cn/")
public class LoginResponse {

    @Element(name = "LoginResult", required = false)
    private String loginResult;

    public String getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(String loginResult) {
        this.loginResult = loginResult;
    }

    public LoginResponse(){

    }

}