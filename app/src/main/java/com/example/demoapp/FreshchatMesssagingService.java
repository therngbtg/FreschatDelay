package com.example.demoapp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.freshchat.consumer.sdk.Freshchat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FreshchatMesssagingService extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String token) {
        sendRegistrationToServer(token);
    }

    public void sendRegistrationToServer(String token) {
        Freshchat.getInstance(this).setPushRegistrationToken(token);
    }


    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {

        if (Freshchat.isFreshchatNotification(remoteMessage)) {
            Freshchat.handleFcmMessage(this, remoteMessage);
        } else {
            //Handle notifications for app
            Log.i("send","you have message now");
        }
    }
}
