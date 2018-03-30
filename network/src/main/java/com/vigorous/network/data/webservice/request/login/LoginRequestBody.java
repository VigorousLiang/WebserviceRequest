package com.vigorous.network.data.webservice.request.login;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by vigorous.liang
 * Created on 2018/3/28
 */

@Root(name = "soap12:Body", strict = false)
public class LoginRequestBody {

    @Element(name = "Login", required = false)
    private LoginRequest body;

    public LoginRequest getBody() {
        return body;
    }

    public void setBody(LoginRequest body) {
        this.body = body;
    }

    public LoginRequestBody(){

    }
}