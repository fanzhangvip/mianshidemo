package com.yunnex.ndkdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Log.i("Zero", "BActivity onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Zero", "BActivity onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Zero", "BActivity onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Zero", "BActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Zero", "BActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Zero", "BActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Zero", "BActivity onDestroy");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i("Zero", "BActivity onConfigurationChanged");
    }

    int count1 = 0;

    public void onClick1(View view) {
        Log.i("Zero", "BActivity count1: " + (count1++));
        Intent intent = new Intent(BActivity.this, MyService.class);
        startService(intent);
    }

    IMyAidlInterface iMyAidlInterface;

    ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            Log.i("Zero", "BActivity onServiceConnected: " + iMyAidlInterface);
            try {
                iMyAidlInterface.basicTypes(1, 2, true, 3.0f, 4d, "hello world");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("Zero", "BActivity onServiceDisconnected");
//            iMyAidlInterface = null;
        }
    };

    int count2 = 0;

    public void onClick2(View view) {
        Log.i("Zero", "BActivity count2: " + (count2++));
        Intent intent = new Intent(BActivity.this, MyService.class);
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
    }

    int count3 = 0;

    public void onClick3(View view) {
        Log.i("Zero", "BActivity count3: " + (count3++));
        Intent intent = new Intent(BActivity.this, MyService.class);
        stopService(intent);
    }

    int count4 = 0;

    public void onClick4(View view) {
        Log.i("Zero", "BActivity count4: " + (count4++));
        unbindService(mServiceConnection);
    }

    public void onClick5(View view) {
        Intent intent = new Intent(BActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
