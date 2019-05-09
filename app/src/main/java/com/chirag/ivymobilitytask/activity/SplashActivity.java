package com.chirag.ivymobilitytask.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.chirag.ivymobilitytask.R;

public class SplashActivity extends AppNavigationActivity {

    Handler handler;

    @Override
    protected void onResume() {
        super.onResume();
        startHandler();
    }

    private void startHandler() {
        handler = new Handler();
        handler.postDelayed(runnable, 3000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    }


    @Override
    protected void onPause() {
        super.onPause();
        if (handler != null)
            handler.removeCallbacks(runnable);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();


        }
    };
}
