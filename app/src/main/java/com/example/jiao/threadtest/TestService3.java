package com.example.jiao.threadtest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class TestService3 extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(MainActivity.TAG, "START TestService3");
    }

    @Override
    public void onDestroy() {
        Log.d(MainActivity.TAG, "DESTROY TestService3");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(MainActivity.TAG, "START handling TestService3");
        ThreadUtil.printProcessInfo(this, TestService3.class.getSimpleName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(MainActivity.TAG, "END handling TestService3");
        stopSelf();
        return START_NOT_STICKY;
    }
}