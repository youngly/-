package com.youngly.leaktest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void noLeak(View view) {
        startActivity(new Intent(this, NoLeakActivity.class));
    }


    public void asyncLeak(View view) {
        startActivity(new Intent(this, AsyncLeakActivity.class));
    }


    public void threadAndHandlerLeak(View view) {
        startActivity(new Intent(this, ThreadAndHandlerActivity.class));
    }
}