package com.example.jiao.threadtest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class TestIntentService2 extends IntentService {
    public TestIntentService2() {
        super("TestIntentService2");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(MainActivity.TAG, "START TestIntentService2");
    }

    @Override
    public void onDestroy() {
        Log.d(MainActivity.TAG, "DESTROY TestIntentService2");
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        Log.d(MainActivity.TAG, "START handling TestIntentService2");
        ThreadUtil.printProcessInfo(this, TestIntentService2.class.getSimpleName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(MainActivity.TAG, "END handling TestIntentService2");
    }
}