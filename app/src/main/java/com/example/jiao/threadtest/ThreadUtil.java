package com.example.jiao.threadtest;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.util.Log;

public class ThreadUtil {
    public static void printProcessInfo(Context context, String tag) {
        Log.d(MainActivity.TAG, tag + " - printProcessInfo:"
                + ", [runningAppProcessCount]:" + getRunningAppProcessCount(context)
                + ", [Thread.activeCount()]:" + Thread.activeCount()
        );
        Log.d(MainActivity.TAG, tag + " -- process:" + " [Process.myPid()]:" + Process.myPid()
                + ", [Process name]:" + ThreadUtil.getCurrentProcessName(context)
        );
        Log.d(MainActivity.TAG, tag + " -- thread:" +" [Process.myTid()]:" + Process.myTid()
                + ", [Thread.currentThread().getId()]:" + Thread.currentThread().getId()
                + ", [.getName()]:" + Thread.currentThread().getName()
        );
    }

    public static String getCurrentProcessName(Context context) {
        // Log.d(TAG, "getCurrentProcessName");
        int pid = android.os.Process.myPid();
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
            // Log.d(TAG, processInfo.processName);
            if (processInfo.pid == pid)
                return processInfo.processName;
        }
        return "";
    }

    public static int getRunningAppProcessCount(Context context) {
        // Log.d(TAG, "getCurrentProcessName");
        int pid = android.os.Process.myPid();
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        return manager.getRunningAppProcesses().size();
    }
}
