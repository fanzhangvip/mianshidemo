package com.yunnex.ndkdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by zero on 2018/8/1.
 */

public class MyService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("Zero", "MyService onCreate");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("Zero", "MyService onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.i("Zero", "MyService onStart");

    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("Zero", "MyService onBind");
        return new MyBind();
    }

    class MyBind extends IMyAidlInterface.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            Log.i("Zero", "MyService MyBind: " + anInt + " " + aLong + " " + aBoolean + " " + aFloat + " " + aDouble + " " + aString);
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("Zero", "MyService onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i("Zero", "MyService onDestroy");
        super.onDestroy();
    }
}
