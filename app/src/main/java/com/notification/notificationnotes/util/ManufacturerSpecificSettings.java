package com.notification.notificationnotes.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

public class ManufacturerSpecificSettings {

    public static void openManufacturerSettings(Activity activity) {
        if (DeviceUtils.isXiaomiDevice()) {
            openXiaomiSettings(activity);
        } else if (DeviceUtils.isHuaweiDevice()) {
            openHuaweiSettings(activity);
        } else if (DeviceUtils.isOppoDevice()) {
            openOppoSettings(activity);
        } else if (DeviceUtils.isVivoDevice()) {
            openVivoSettings(activity);
        } else {
            openGenericSettings(activity);
        }
    }

    private static void openXiaomiSettings(Activity activity) {
        try {
            // MIUI自動起動管理画面
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName(
                    "com.miui.securitycenter",
                    "com.miui.permcenter.autostart.AutoStartManagementActivity"
            );
            intent.setComponent(componentName);
            activity.startActivity(intent);
        } catch (Exception e) {
            openGenericSettings(activity);
        }
    }

    private static void openHuaweiSettings(Activity activity) {
        try {
            // Huawei保護されたアプリ画面
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName(
                    "com.huawei.systemmanager",
                    "com.huawei.systemmanager.optimize.process.ProtectActivity"
            );
            intent.setComponent(componentName);
            activity.startActivity(intent);
        } catch (Exception e) {
            openGenericSettings(activity);
        }
    }

    private static void openOppoSettings(Activity activity) {
        try {
            // OPPO自動起動管理画面
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName(
                    "com.coloros.safecenter",
                    "com.coloros.safecenter.permission.startup.FakeActivity"
            );
            intent.setComponent(componentName);
            activity.startActivity(intent);
        } catch (Exception e) {
            openGenericSettings(activity);
        }
    }

    private static void openVivoSettings(Activity activity) {
        try {
            // Vivo自動起動管理画面
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName(
                    "com.iqoo.secure",
                    "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity"
            );
            intent.setComponent(componentName);
            activity.startActivity(intent);
        } catch (Exception e) {
            try {
                // 別のVivoコンポーネント
                Intent intent2 = new Intent();
                ComponentName componentName2 = new ComponentName(
                        "com.vivo.permissionmanager",
                        "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"
                );
                intent2.setComponent(componentName2);
                activity.startActivity(intent2);
            } catch (Exception e2) {
                openGenericSettings(activity);
            }
        }
    }

    private static void openGenericSettings(Activity activity) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + activity.getPackageName()));
        activity.startActivity(intent);
    }
}
