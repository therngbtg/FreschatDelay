package com.example.demoapp;

import android.app.Application;
import android.content.Context;
import android.net.Uri;


import androidx.core.app.NotificationManagerCompat;

import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.FreshchatConfig;
import com.freshchat.consumer.sdk.FreshchatNotificationConfig;

public class AppChat extends Application {
    private Freshchat freshchat;

    @Override
    public void onCreate() {
        super.onCreate();
        initialiseFreshchat();
    }


    private void initialiseFreshchat() {

        FreshchatConfig freshchatConfig = new FreshchatConfig("6df0d971-eb56-4188-9088-275e8b34dee4", "28037ec3-75e0-4053-8057-0ddcf5a1b90d");
        getFreshchatInstance(getApplicationContext()).init(freshchatConfig);

//        noti
        Uri soundUri = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.raw.musical003);

        FreshchatNotificationConfig notificationConfig = new FreshchatNotificationConfig()
                .setNotificationSoundEnabled(true)
                .setNotificationSound(soundUri)
                .setImportance(NotificationManagerCompat.IMPORTANCE_MAX);

        getFreshchatInstance(getApplicationContext()).setNotificationConfig(notificationConfig);
    }

    private Freshchat getFreshchatInstance(Context context) {
        if (freshchat == null) {
            freshchat = Freshchat.getInstance(context);
        }
        return freshchat;
    }
}
