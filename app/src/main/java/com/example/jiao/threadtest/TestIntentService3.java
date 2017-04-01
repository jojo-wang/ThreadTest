package com.example.jiao.threadtest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class TestIntentService3 extends IntentService {
    public TestIntentService3() {
        super("TestIntentService3");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(MainActivity.TAG, "START TestIntentService3");
    }

    @Override
    public void onDestroy() {
        Log.d(MainActivity.TAG, "DESTROY TestIntentService3");
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        Log.d(MainActivity.TAG, "START handling TestIntentService3");
        ThreadUtil.printProcessInfo(this, TestIntentService3.class.getSimpleName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(MainActivity.TAG, "END handling TestIntentService3");
    }
}