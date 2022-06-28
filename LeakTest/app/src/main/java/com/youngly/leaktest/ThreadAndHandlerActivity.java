package com.youngly.leaktest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class ThreadAndHandlerActivity extends AppCompatActivity {

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            updateUI();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_and_thread);

        // 学会看leakcanary和hprof文件
        // 什么是内部类？什么是匿名内部类？怎么区分？
        // javap -c
        // this$0 是什么？
        // AsyncAndThreadActivity$1 是什么？ 怎么确认 ？
        // 为何内部类将自动持有外部类的引用？ 尝试从静态变量和成员变量开始解释

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    handler.sendEmptyMessage(0);
                    // 制造oom
//                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img);
                    Thread.sleep(20_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void updateUI() {
    }
}