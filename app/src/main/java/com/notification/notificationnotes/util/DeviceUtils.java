package com.notification.notificationnotes.util;

import android.os.Build;

public class DeviceUtils {

    public static boolean isXiaomiDevice() {
        return Build.MANUFACTURER.equalsIgnoreCase("Xiaomi") ||
                Build.BRAND.equalsIgnoreCase("Xiaomi") ||
                Build.BRAND.equalsIgnoreCase("Redmi");
    }

    public static boolean isHuaweiDevice() {
        return Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") ||
                Build.BRAND.equalsIgnoreCase("HUAWEI") ||
                Build.BRAND.equalsIgnoreCase("Honor");
    }

    public static boolean isOppoDevice() {
        return Build.MANUFACTURER.equalsIgnoreCase("OPPO") ||
                Build.BRAND.equalsIgnoreCase("OPPO");
    }

    public static boolean isVivoDevice() {
        return Build.MANUFACTURER.equalsIgnoreCase("vivo") ||
                Build.BRAND.equalsIgnoreCase("vivo");
    }

    public static boolean isOnePlusDevice() {
        return Build.MANUFACTURER.equalsIgnoreCase("OnePlus") ||
                Build.BRAND.equalsIgnoreCase("OnePlus");
    }

    public static boolean hasAggressiveBatteryOptimization() {
        return isXiaomiDevice() || isHuaweiDevice() || isOppoDevice() ||
                isVivoDevice() || isOnePlusDevice();
    }
}
