package com.example.yulon.activityrecall;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ServiceDemo extends AppCompatActivity {

    private final String LOG_TAG = "ServiceDemo";

    private Button mBtnStartService, mBtnStopService, mBtnBindService, mBtnUnBindService, mBtnCallServiceMethod;

    private MyService mMyServ = null;

    private ServiceConnection mServConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(LOG_TAG, "onServiceConnected() " + componentName.getClassName());
            mMyServ = ((MyService.LocalBinder)iBinder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(LOG_TAG, "onServiceDisconnected() " + componentName.getClassName());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);

        mBtnStartService = (Button)findViewById(R.id.btnStartService);
        mBtnStopService = (Button)findViewById(R.id.btnStopService);
        mBtnBindService = (Button)findViewById(R.id.btnBindService);
        mBtnUnBindService = (Button)findViewById(R.id.btnUnBindService);
        mBtnCallServiceMethod = (Button)findViewById(R.id.btnCallServiceMethod);

        mBtnStartService.setOnClickListener(btnStartMyservOnClk);
        mBtnStopService.setOnClickListener(btnStopMyservOnClk);
        mBtnBindService.setOnClickListener(btnBindMyservOnClk);
        mBtnUnBindService.setOnClickListener(btnUnBindMyservOnClk);
        mBtnCallServiceMethod.setOnClickListener(btnCallMyservOnClk);
    }

    private View.OnClickListener btnStartMyservOnClk = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mMyServ = null;
            Intent it = new Intent(ServiceDemo.this, MyService.class);
            startService(it);
        }
    };

    private View.OnClickListener btnStopMyservOnClk = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mMyServ = null;
            Intent it = new Intent(ServiceDemo.this, MyService.class);
            stopService(it);
        }
    };

    private View.OnClickListener btnBindMyservOnClk = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mMyServ = null;
            Intent it = new Intent(ServiceDemo.this, MyService.class);
            bindService(it, mServConn, BIND_AUTO_CREATE);
        }
    };

    private View.OnClickListener btnUnBindMyservOnClk = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mMyServ = null;
            unbindService(mServConn);
        }
    };

    private View.OnClickListener btnCallMyservOnClk = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(mMyServ != null){
                mMyServ.myMethod();
            }
        }
    };
}
