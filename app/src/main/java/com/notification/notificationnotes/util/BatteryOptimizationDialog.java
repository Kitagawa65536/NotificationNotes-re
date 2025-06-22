package com.notification.notificationnotes.util;

import android.app.Activity;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.notification.notificationnotes.R;

public class BatteryOptimizationDialog {
    public interface DialogCallback {
        void onSettingsClicked();
        void onDismissed();
    }

    public static void showDialog(Activity activity, DialogCallback callback) {
        String deviceName = getDeviceName(activity);

        String message = activity.getString(R.string.battery_optimization_dialog_title,deviceName);

        new AlertDialog.Builder(activity)
                .setTitle(activity.getString(R.string.important_notice))
                .setMessage(message)
                .setPositiveButton(activity.getString(R.string.open_settings), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        callback.onSettingsClicked();
                    }
                })
                .setNegativeButton(activity.getString(R.string.open_later), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        callback.onDismissed();
                    }
                })
                .setCancelable(false)
                .show();
    }

    private static String getDeviceName(Activity activity) {
        if (DeviceUtils.isXiaomiDevice()) {
            return "Xiaomi/Redmi";
        } else if (DeviceUtils.isHuaweiDevice()) {
            return "Huawei/Honor";
        } else if (DeviceUtils.isOppoDevice()) {
            return "OPPO";
        } else if (DeviceUtils.isVivoDevice()) {
            return "Vivo";
        } else if (DeviceUtils.isOnePlusDevice()) {
            return "OnePlus";
        } else {
            return activity.getString(R.string.this_device);
        }
    }
}
