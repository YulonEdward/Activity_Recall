package com.example.yulon.activityrecall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadCastReceiver1 extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String sender = intent.getStringExtra("sender_name");
        Toast.makeText(context, "BroadCastReceiver1 收到" + sender + "發送的 BroadCast 訊息", Toast.LENGTH_LONG).show();
    }
}
