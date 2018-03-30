package com.vigorous.webservice.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;


import com.vigorous.network.AsyncNetWorkAPIFactory;
import com.vigorous.network.data.NetWorkRequestConst;
import com.vigorous.network.data.RequestId;
import com.vigorous.network.data.webservice.request.Soap12RequestEnvelope;
import com.vigorous.network.data.webservice.request.login.LoginRequest;
import com.vigorous.network.data.webservice.request.login.LoginRequestBody;
import com.vigorous.network.data.webservice.response.login.LoginRespEnvelope;
import com.vigorous.network.data.webservice.response.login.LoginRespBody;
import com.vigorous.network.listener.RequestListener;
import com.vigorous.webservice.network.webservicenetwork.R;
import com.vigorous.webservice.ui.base.WSBaseActivity;
import com.vigorous.webservice.util.EncryptUtils;
import com.vigorous.webservice.util.SystemUtils;
import com.vigorous.webservice.util.VersionUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends WSBaseActivity {

    @BindView(R.id.btn_example)
    Button mBtnExample;

    protected void setContentView() {
        super.setContentView();
        setContentView(R.layout.activity_main);
    }

    // 启动顺序 1
    protected void findView() {
        super.findView();
    }

    // 启动顺序 2
    protected void initIntent(Intent intent) {
        super.initIntent(intent);
    }

    // 启动顺序 3
    protected void initView() {
        super.initView();
    }

    public void onCreateAfterSuper(Bundle savedInstanceState) {
        ButterKnife.bind(this);
    }

    public void onDestroyBeforeSuper() {

    }

    public void onDestroyAfterSuper() {

    }

    @OnClick(R.id.btn_example)
    void example() {
        sendWSPostRequestExample();
    }



    private void sendWSPostRequestExample() {
        Log.e("http", "StartRequest");

        Soap12RequestEnvelope<LoginRequestBody> requestEnvelope =new Soap12RequestEnvelope();
        LoginRequestBody loginRequestBody =new LoginRequestBody();
        LoginRequest loginRequest=new LoginRequest();
        try {
            loginRequest.setPassword(EncryptUtils.EncryptAsDoNet("G@123","gtja0041"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        loginRequest.setUserId("004195");
        loginRequest.setIsencrypt("true");
        loginRequest.setDesc(android.os.Build.VERSION.RELEASE+"|"+ VersionUtils.getAppVersion(MainActivity.this)+"|"+ SystemUtils.getDeviceInfo(MainActivity.this));
        loginRequestBody.setBody(loginRequest);
        requestEnvelope.setBody(loginRequestBody);

        getAPIFactory().sendWSPostMessageForSignIn(getApplicationContext(),
                NetWorkRequestConst.REQUEST_EXAMPLE,
                AsyncNetWorkAPIFactory.REQUEST_TYPE_CANCEL_WITH_ACTIVITY,
                requestEnvelope, new RequestListener<LoginRespEnvelope>() {
                    @Override
                    public void onResult(RequestId requestID, LoginRespEnvelope resp) {
                        System.out.println(resp.getBody().getBody().getLoginResult());
                    }

                    @Override
                    public void onError(RequestId requestID, String errorCode, String errorDesc) {

                    }
                });
    }
}
