package com.vigorous.webservice.util;

import android.content.Context;
import android.telephony.TelephonyManager;


public class SystemUtils {

    // 获取App版本号

    // 获取设备信息
    public static String getDeviceInfo(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceinfo =android.os.Build.MODEL ;
//		String deviceinfo = "设备类型:" + android.os.Build.MODEL + ",唯一标识id:"+ tm.getDeviceId();

        return deviceinfo;
    }
}
