package com.youngly.leaktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class NoLeakActivity extends AppCompatActivity {

    private static final String TAG = "NoLeakActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_leak);
        Log.i(TAG, "NoLeakActivity onCreate address = " + this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "NoLeakActivity onDestroy address = " + this);

        // 添加leakcanary和未添加leakcanary 日志上区别（GC）
        // leakcanary 在什么时机触发GC
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.i(TAG, "NoLeakActivity released address = " + this);
    }
}