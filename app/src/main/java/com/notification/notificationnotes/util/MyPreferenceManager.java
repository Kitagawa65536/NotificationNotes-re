package com.notification.notificationnotes.util;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreferenceManager {
    private static final String PREF_NAME = "app_prefs";
    private static final String KEY_FIRST_LAUNCH = "is_first_launch";
    private static final String KEY_BATTERY_DIALOG = "show_battery_dialog";

    private SharedPreferences prefs;

    public MyPreferenceManager(Context context) {
        this.prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public boolean isFirstLaunch() {
        return prefs.getBoolean(KEY_FIRST_LAUNCH, true);
    }

    public void setFirstLaunchCompleted() {
        prefs.edit().putBoolean(KEY_FIRST_LAUNCH, false).apply();
    }

    public boolean shouldShowBatteryOptimizationDialog() {
        return prefs.getBoolean(KEY_BATTERY_DIALOG, true);
    }

    public void setBatteryOptimizationDialogShown() {
        prefs.edit().putBoolean(KEY_BATTERY_DIALOG, false).apply();
    }
}
