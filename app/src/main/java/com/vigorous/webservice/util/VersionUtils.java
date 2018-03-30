package com.vigorous.webservice.util;

import android.content.Context;
import android.content.pm.PackageManager;


public class VersionUtils {

    public static String getAppVersion(Context context) {
        String pkName = context.getPackageName();
        String versionName = "";
        try {
            versionName =context.getPackageManager().getPackageInfo(pkName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            versionName="";
        }
        return versionName;
    }
}
