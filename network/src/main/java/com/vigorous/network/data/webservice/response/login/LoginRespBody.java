package com.vigorous.network.data.webservice.response.login;



import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by vigorous.liang
 * Created on 2018/3/28
 */
//坑，这里只能是Body,不能使soap:Body,不然解析不出来
@Root(name = "Body", strict = false)
public class LoginRespBody {

    @Element(name = "LoginResponse", required = false)
    private LoginResponse body;

    public LoginResponse getBody() {
        return body;
    }

    public void setBody(LoginResponse body) {
        this.body = body;
    }

    public LoginRespBody(){

    }
}