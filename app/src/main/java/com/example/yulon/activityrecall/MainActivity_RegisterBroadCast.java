package com.example.yulon.activityrecall;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity_RegisterBroadCast extends AppCompatActivity {

    private Button mBtnRegister, mBtnUnregister, mBtnSendbroadcast1, mBtnSendbroadcast2;

    private BroadCastReceiver2 mMyReceiver2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register_broad_cast);

        mBtnRegister = (Button)findViewById(R.id.btnRegister);
        mBtnUnregister = (Button)findViewById(R.id.btnUnregister);
        mBtnSendbroadcast1 = (Button)findViewById(R.id.btnSendBroadCast1);
        mBtnSendbroadcast2 = (Button)findViewById(R.id.btnSendBroadCast2);

        mBtnRegister.setOnClickListener(btnRegReceiverOnClk);
        mBtnUnregister.setOnClickListener(btnUnRegReceiverOnClk);
        mBtnSendbroadcast1.setOnClickListener(btnSendReceiver1OnClk);
        mBtnSendbroadcast2.setOnClickListener(btnSendReceiver2OnClk);
    }

    private View.OnClickListener btnRegReceiverOnClk = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            IntentFilter itFilter = new IntentFilter("com.android.MY_BROADCAST2");
            mMyReceiver2 = new BroadCastReceiver2();
            registerReceiver(mMyReceiver2, itFilter);
        }
    };

    private View.OnClickListener btnUnRegReceiverOnClk = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(mMyReceiver2!=null){
                unregisterReceiver(mMyReceiver2);
            }
        }
    };

    private View.OnClickListener btnSendReceiver1OnClk = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent("com.android.MY_BROADCAST1");
            it.putExtra("sender_name", "主程式");
            sendBroadcast(it);
        }
    };

    private View.OnClickListener btnSendReceiver2OnClk = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent("com.android.MY_BROADCAST2");
            it.putExtra("sender_name", "主程式");
            sendBroadcast(it);
        }
    };
}
