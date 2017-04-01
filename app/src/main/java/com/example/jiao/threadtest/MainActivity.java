package com.example.jiao.threadtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public final static String TAG = "ThreadTest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ThreadUtil.printProcessInfo(this, MainActivity.class.getSimpleName());
        ViewGroup parent = (ViewGroup) findViewById(R.id.activity_main);
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            child.setOnClickListener(this);
        }
    }

    private void createIntentStartService(Class serviceClass) {
        Log.d(TAG, "createIntentStartService:" + serviceClass.getName());
        Intent serviceIntent = new Intent(getApplicationContext(), serviceClass);
        startService(serviceIntent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.two_TestService2:
                createIntentStartService(TestService2.class);
                createIntentStartService(TestService2.class);
                break;
            case R.id.TestService_TestService2:
                createIntentStartService(TestService.class);
                createIntentStartService(TestService2.class);
                break;
            case R.id.TestService2_TestService3:
                createIntentStartService(TestService2.class);
                createIntentStartService(TestService3.class);
                break;
            case R.id.two_TestIntentService2:
                createIntentStartService(TestIntentService2.class);
                createIntentStartService(TestIntentService2.class);
                break;
            case R.id.TestIntentService_TestIntentService2:
                createIntentStartService(TestIntentService.class);
                createIntentStartService(TestIntentService2.class);
                break;
            case R.id.TestIntentService2_TestIntentService3:
                createIntentStartService(TestIntentService2.class);
                createIntentStartService(TestIntentService3.class);
                break;
            default:
                break;
        }
    }
}
